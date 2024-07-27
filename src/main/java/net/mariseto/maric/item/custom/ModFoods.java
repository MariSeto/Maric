package net.mariseto.maric.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BLOOCUP = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 400), 1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400), 1f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400), 1f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200), 1f).effect(() -> new MobEffectInstance(MobEffects.WITHER, 200), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 1f).build();
}
