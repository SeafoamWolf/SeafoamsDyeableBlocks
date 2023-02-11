package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import seafoamwolf.seafoamsdyeableblocks.datagen.DyeableBlocksRecipeProvider;

public class SeafoamsDyeableBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    	pack.addProvider(DyeableBlocksRecipeProvider::new);
	}
}