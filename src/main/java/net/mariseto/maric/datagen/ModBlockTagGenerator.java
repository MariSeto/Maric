package net.mariseto.maric.datagen;

import net.mariseto.maric.Maric;
import net.mariseto.maric.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Maric.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(BlockTags.NEEDS_STONE_TOOL)
        //        .add()

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OPALIUM_BLOCK.get(),
                ModBlocks.OPALIUM_BRICK_BLOCK.get());

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
        //        .add()

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.OPALIUM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OPALIUM_ORE.get(),
                ModBlocks.OPALIUM_BRICK_BLOCK.get(),
                ModBlocks.OPALIUM_BLOCK.get());

        //this.tag(BlockTags.MINEABLE_WITH_AXE)
        //this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
        //this.tag(BlockTags.MINEABLE_WITH_HOE)
        //spacer line

    }

}
