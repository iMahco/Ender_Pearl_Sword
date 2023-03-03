package com.mahco.enderpearlsword.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier Ender = new ForgeTier(
            3,2423,8.0f,3.0f,10, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.DRAGON_BREATH));
}
