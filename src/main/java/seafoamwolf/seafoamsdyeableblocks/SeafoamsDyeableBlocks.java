package seafoamwolf.seafoamsdyeableblocks;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.tab.SeafoamsDyeableBlocksItemTab;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.DyedItem;

@Mod(SeafoamsDyeableBlocks.MODID)
public class SeafoamsDyeableBlocks {
	public static final String MODID = "seafoamsdyeableblocks";

	public static final SeafoamsDyeableBlocksItemTab ITEM_TAB = new SeafoamsDyeableBlocksItemTab(CreativeModeTab.TABS.length, "item_tab");

	public static List<DyeableBlockRegister> DYEABLE_BLOCKS = new ArrayList<>();
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

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            DYEABLE_BLOCKS.forEach(block -> event.register((state, blockAndTintGetter, pos, tintIndex) -> {
                if (blockAndTintGetter == null)
                    return 0;
                
                int color = 16777215;
                
                BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(pos);

                if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
                    color = ((DyeableBlockEntity)blockEntity).getColor();
                
                return color;
            }, block.Block.get()));
        }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            DYEABLE_BLOCKS.forEach(block -> event.register((stack, tintIndex) -> {
                return ((DyeableBlockItem)stack.getItem()).getColor(stack);
            }, block.Item.get()));
            
            DYEABLE_ITEMS.forEach(item -> event.register((stack, layer) -> {
                return (layer == 1 ? ((DyedItem)stack.getItem()).getColor(stack) : 16777215);
            }, item));
        }
    }
}
