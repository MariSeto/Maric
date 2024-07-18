package net.mariseto.maric.item;

import net.mariseto.maric.Maric;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Maric.MOD_ID);
    public static final RegistryObject<CreativeModeTab> MARIC_TAB = CREATIVE_MODE_TABS.register("maric_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OPALIUM_INGOT.get()))
                .title(Component.translatable("creativetab.maric_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.OPALIUM_NUGGET.get());
                    output.accept(ModItems.OPALIUM_INGOT.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
