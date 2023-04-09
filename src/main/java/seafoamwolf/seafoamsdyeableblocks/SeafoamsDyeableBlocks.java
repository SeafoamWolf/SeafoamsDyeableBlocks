package seafoamwolf.seafoamsdyeableblocks;

import java.util.List;
import java.util.function.Supplier;
import java.util.ArrayList;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterNamedRenderTypesEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.tab.SeafoamsDyeableBlocksItemTab;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.DyedItem;

@Mod(SeafoamsDyeableBlocks.MODID)
public class SeafoamsDyeableBlocks {
	public static final String MODID = "seafoamsdyeableblocks";

	public static final SeafoamsDyeableBlocksItemTab ITEM_TAB = new SeafoamsDyeableBlocksItemTab(CreativeModeTab.TABS.length, "dyeable_blocks_item_tab");

	public static List<Block> DYEABLE_BLOCKS = new ArrayList<>();
	public static List<DyeableBlockItem> DYEABLE_BLOCK_ITEMS = new ArrayList<>();
	public static List<DyedItem> DYEABLE_ITEMS = new ArrayList<>();

	public SeafoamsDyeableBlocks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

		DyeableBlocks.BLOCKS.register(modEventBus);
		DyeableBlocks.BLOCK_ENTITY_TYPES.register(modEventBus);
		DyeableItems.ITEMS.register(modEventBus);
        
		MinecraftForge.EVENT_BUS.register(this);
    }

	private void commonSetup(final FMLCommonSetupEvent event) {
		DyeableItems.register();
	}
    
    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler {
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            DYEABLE_BLOCKS.forEach(block -> event.register((state, blockAndTintGetter, pos, tintIndex) -> {
                if (blockAndTintGetter == null)
                    return 0;
                
                BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(pos);

                if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
                    return ((DyeableBlockEntity)blockEntity).getColor();
                
                return 16777215;
            }, block));
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            DYEABLE_BLOCK_ITEMS.forEach(blockItem -> event.register((stack, tintIndex) -> {
                return ((DyeableBlockItem)stack.getItem()).getColor(stack);
            }, blockItem));
            
            DYEABLE_ITEMS.forEach(item -> event.register((stack, layer) -> {
                return (layer == 1 ? ((DyedItem)stack.getItem()).getColor(stack) : 16777215);
            }, item));
        }
    }
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class BlockInit {
        @SubscribeEvent
        public static void onRegisterItems(final RegisterEvent event) {
            if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)){
                DyeableBlocks.BLOCKS.getEntries().forEach((blockRegistryObject) -> {
                    Block block = blockRegistryObject.get();
                    Item.Properties properties = new Item.Properties().tab(ITEM_TAB);
                    DyeableBlockItem item = new DyeableBlockItem(block, properties);
                    event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), () -> item);
                    DYEABLE_BLOCK_ITEMS.add(item);
                });
            }
        }
    }
}
