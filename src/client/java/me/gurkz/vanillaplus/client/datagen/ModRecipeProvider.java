package me.gurkz.vanillaplus.client.datagen;

import me.gurkz.vanillaplus.block.ModBlocks;
import me.gurkz.vanillaplus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.item.Items.*;

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
        offerBlasting(recipeExporter,
                List.of(ModItems.BACKERIUM_NUGGET),
                RecipeCategory.MISC, ModItems.SUPERHEATED_BACKERIUM_NUGGET,
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BACKERIUM_STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', ModItems.BACKERIUM_NUGGET)
                .criterion(hasItem(ModItems.BACKERIUM_NUGGET), conditionsFromItem(ModItems.BACKERIUM_NUGGET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BACKERIUM_DAGGER)
                        .pattern(" # ")
                        .pattern(" # ")
                        .pattern(" I ")
                        .input('#', ModItems.SUPERHEATED_BACKERIUM_NUGGET)
                        .input('I', ModItems.SHORT_BACKERIUM_STICK)
                        .criterion(hasItem(ModItems.BACKERIUM_NUGGET), conditionsFromItem(ModItems.BACKERIUM_NUGGET))
                        .offerTo(recipeExporter);

        StonecuttingRecipeJsonBuilder
                .createStonecutting(Ingredient.ofItems(ModItems.BACKERIUM_STICK), RecipeCategory.MISC, ModItems.SHORT_BACKERIUM_STICK, 2)
                .criterion(hasItem(ModItems.BACKERIUM_STICK), conditionsFromItem(ModItems.BACKERIUM_STICK))
                .offerTo(recipeExporter);
    }
}
