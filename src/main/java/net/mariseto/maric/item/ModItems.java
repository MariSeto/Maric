package net.mariseto.maric.item;

import net.mariseto.maric.Maric;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Maric.MOD_ID );

    public static final RegistryObject<Item> OPALIUM_NUGGET = ITEMS.register("opalium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPALIUM_INGOT = ITEMS.register("opalium_ingot", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
