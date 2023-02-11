package seafoamwolf.seafoamsdyeableblocks.datagen;

import java.util.function.Consumer;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class DyeableBlocksRecipeProvider extends FabricRecipeProvider {
	public DyeableBlocksRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
        List<DyeableBlockRegister> dyeableBlocks = DyeableBlocks.GetDyeable();

		for (int i = 0; i < dyeableBlocks.size(); i++) {
			Block block = dyeableBlocks.get(i).Block;
			offerShapelessRecipe(exporter, block, block, getName(), 1);
		}
	}
}
