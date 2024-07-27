package net.mariseto.maric.datagen;

import net.mariseto.maric.Maric;
import net.mariseto.maric.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Maric.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
       blockWithItem(ModBlocks.OPALIUM_BLOCK);
       blockWithItem(ModBlocks.OPALIUM_BRICK_BLOCK);

        blockWithItem(ModBlocks.OPALIUM_ORE);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
