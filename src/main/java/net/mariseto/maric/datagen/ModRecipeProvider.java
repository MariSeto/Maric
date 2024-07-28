package net.mariseto.maric.datagen;

import net.mariseto.maric.Maric;
import net.mariseto.maric.block.ModBlocks;
import net.mariseto.maric.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //create a list for the smeltables for each smeltable. Lists the items and blocks that get smelted. The build recipe further down dictates what is actually created.
    private static final List<ItemLike> OPALIUM_SMELTABLES = List.of(ModItems.OPALIUM_DUST.get(), ModBlocks.OPALIUM_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        /*the 2 lines below this comment are what create the recipes for smelting and blasting opalium ore blocks and (in this case) the dust.
         (just whats in the OPALIUM_SMELTABLES list). If i wanted it to take longer to cook or drop more xp, here is where i would change those values.
         IF YOU WANT TO SEE THE OTHER CRAFTING THINGS LIKE STONECUTTING, DOUBLE SHIFT FOR RecipeProvider!!!!!!!!*/
        oreSmelting(pWriter, OPALIUM_SMELTABLES, RecipeCategory.MISC, ModItems.OPALIUM_INGOT.get(), 0.25f, 200, "opalium");
        oreBlasting(pWriter, OPALIUM_SMELTABLES, RecipeCategory.MISC, ModItems.OPALIUM_INGOT.get(), 0.25f, 100, "opalium");
        //shaped recipe, the unlockedBy tells the game when to add this recipe to the recipe book.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPALIUM_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.OPALIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.OPALIUM_INGOT.get()), has(ModItems.OPALIUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OPALIUM_INGOT.get(), 9)
                .requires(ModBlocks.OPALIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.OPALIUM_BLOCK.get()), has(ModBlocks.OPALIUM_BLOCK.get()))
                .save(pWriter);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.OPALIUM_BLOCK.get()), RecipeCategory.MISC, ModBlocks.OPALIUM_BRICK_BLOCK.get(), 4)
                .unlockedBy("opalium_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.OPALIUM_BLOCK.get()).build()))
                .save(pWriter);


    }
    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, Maric.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
