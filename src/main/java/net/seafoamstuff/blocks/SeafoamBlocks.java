package net.seafoamstuff.blocks;

import java.util.List;
import java.util.ArrayList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ObserverBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntityType;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.seafoamstuff.SeafoamStuff;
import net.seafoamstuff.blocks.rgb.RGBBlock;
import net.seafoamstuff.blocks.rgb.RGBBlockEntity;
import net.seafoamstuff.blocks.rgb.RGBBlockItem;

public class SeafoamBlocks {
	// Blocks
    public static final Block SEAFOAMIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
    public static final Block DEEPSLATE_SEAFOAMIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).requiresTool());
    public static final Block RAW_SEAFOAMIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
    public static final Block SEAFOAMIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());

    public static final Block OwObserver = new ObserverBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool().solidBlock(SeafoamBlocks::never));

    public static final Block RGB_CONCRETE = new RGBBlock(FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool());

	public static BlockEntityType<RGBBlockEntity> RGB_BLOCK_ENTITY;

	private static List<Block> rgbBlocks = new ArrayList<Block>();
	private static List<RGBBlockItem> rgbItems = new ArrayList<RGBBlockItem>();

	public static void register() {
		// Blocks
        Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, "seafoamium_ore"), SEAFOAMIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "seafoamium_ore"), new BlockItem(SEAFOAMIUM_ORE, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));

        Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, "deepslate_seafoamium_ore"), DEEPSLATE_SEAFOAMIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "deepslate_seafoamium_ore"), new BlockItem(DEEPSLATE_SEAFOAMIUM_ORE, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));
		
        Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, "raw_seafoamium_block"), RAW_SEAFOAMIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "raw_seafoamium_block"), new BlockItem(RAW_SEAFOAMIUM_BLOCK, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));

        Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, "seafoamium_block"), SEAFOAMIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "seafoamium_block"), new BlockItem(SEAFOAMIUM_BLOCK, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));

        Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, "owobserver"), OwObserver);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "owobserver"), new BlockItem(OwObserver, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));
		
		// RGB Blocks
		
		CreateRGB("rgb_concrete", RGB_CONCRETE);

		RGB_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(SeafoamStuff.MOD_ID, "rgb_block_entity"), FabricBlockEntityTypeBuilder.create(RGBBlockEntity::new, RGB_CONCRETE).build(null));
	}

	private static void CreateRGB(String id, Block blockRegistry) {
		Block block = Registry.register(Registry.BLOCK, new Identifier(SeafoamStuff.MOD_ID, id), blockRegistry);
		RGBBlockItem item = Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, id), new RGBBlockItem(blockRegistry, new FabricItemSettings().group(SeafoamStuff.SEAFOAM_STUFF)));

		rgbBlocks.add(block);
		rgbItems.add(item);
	}

	@Environment(EnvType.CLIENT)
	public static void registerClient() {
		rgbBlocks.forEach((block) -> ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			if (view.getBlockEntity(pos) != null) {
				return ((RGBBlockEntity)view.getBlockEntity(pos)).getColor();
			} else {
				return 16777215;
			}
		}, block));

		rgbItems.forEach((item) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((RGBBlockItem)stack.getItem()).getColor(stack), item));
	}

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
}
