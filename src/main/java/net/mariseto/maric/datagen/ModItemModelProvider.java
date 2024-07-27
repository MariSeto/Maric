package net.mariseto.maric.datagen;

import net.mariseto.maric.Maric;
import net.mariseto.maric.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Maric.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.OPALIUM_INGOT);
        simpleItem(ModItems.OPALIUM_NUGGET);
        simpleItem(ModItems.OPALIUM_DUST);
        simpleItem(ModItems.DIAMOND_DUST);

        simpleItem(ModItems.BLOOCUP);

        simpleItem(ModItems.PIECE_OF_COAL);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Maric.MOD_ID,"item/" + item.getId().getPath()));
    }
}
