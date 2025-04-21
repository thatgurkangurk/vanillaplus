package me.gurkz.vanillaplus.client.datagen;

import me.gurkz.vanillaplus.block.ModBlocks;
import me.gurkz.vanillaplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.item.Items.IRON_NUGGET;
import static net.minecraft.item.Items.ROTTEN_FLESH;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerSmelting(recipeExporter,
                List.of(ModItems.INCOMPLETE_BACKERIUM_NUGGET),
                RecipeCategory.MISC, ModItems.BACKERIUM_NUGGET,
                0.25f,
                200,
                "backerium_nugget"
        );
        offerBlasting(recipeExporter,
                List.of(ModItems.INCOMPLETE_BACKERIUM_NUGGET),
                RecipeCategory.MISC, ModItems.BACKERIUM_NUGGET,
                0.25f,
                200,
                "backerium_nugget"
        );

        offerReversibleCompactingRecipes(recipeExporter,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.BACKERIUM_NUGGET,
                RecipeCategory.DECORATIONS,
                ModBlocks.BACKERIUM_BLOCK
        );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INCOMPLETE_BACKERIUM_NUGGET)
                .pattern("#W#")
                .input('#', ROTTEN_FLESH)
                .input('W', IRON_NUGGET)
                .criterion(hasItem(ROTTEN_FLESH), conditionsFromItem(ROTTEN_FLESH))
                .criterion(hasItem(IRON_NUGGET), conditionsFromItem(IRON_NUGGET))
                .offerTo(recipeExporter);
    }
}
