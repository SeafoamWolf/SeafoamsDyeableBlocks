package net.seafoamstuff.world;

import java.util.Arrays;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;

import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.YOffset;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.Identifier;

import net.seafoamstuff.SeafoamStuff;
import net.seafoamstuff.blocks.SeafoamBlocks;

public class SeafoamWorldGen {
	public static ConfiguredFeature<?, ?> SEAFOAMIUM_ORE_GEN = new ConfiguredFeature<OreFeatureConfig, Feature<OreFeatureConfig>>(
		Feature.ORE, new OreFeatureConfig(
			OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
			SeafoamBlocks.DEEPSLATE_SEAFOAMIUM_ORE.getDefaultState(),
			5)
	);
	
	public static PlacedFeature SEAFOAMIUM_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(SEAFOAMIUM_ORE_GEN),
			Arrays.asList(
				CountPlacementModifier.of(2),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
			));
	
	public static void register() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(SeafoamStuff.MOD_ID, "deepslate_seafoamium_ore"), SEAFOAMIUM_ORE_GEN);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(SeafoamStuff.MOD_ID, "deepslate_seafoamium_ore"), SEAFOAMIUM_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(SeafoamStuff.MOD_ID, "deepslate_seafoamium_ore")));
	}
}