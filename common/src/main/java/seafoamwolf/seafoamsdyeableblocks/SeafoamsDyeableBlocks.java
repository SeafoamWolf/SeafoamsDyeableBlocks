package seafoamwolf.seafoamsdyeableblocks;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.item.DyedItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SeafoamsDyeableBlocks {
    public static final String MOD_ID = "seafoamsdyeableblocks";
    
	public static List<Block> DYEABLE_BLOCKS = new ArrayList<>();
	public static List<DyeableBlockItem> DYEABLE_BLOCK_ITEMS = new ArrayList<>();
	public static List<DyedItem> DYEABLE_ITEMS = new ArrayList<>();
    
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);


    // Registering a new creative tab
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> ITEM_TAB = TABS.register("item_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".item_tab"),
                    () -> new ItemStack(DyeableItems.PAINTBRUSH)));
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registries.BLOCK_ENTITY_TYPE);
    
    public static void init() {
        DyeableBlocks.init();
        DyeableItems.init();

        TABS.register();
        
        System.out.println(DyeableBlocksExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
