package com.mahco.enderpearlsword.item;

import com.mahco.enderpearlsword.EnderPearlSword;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnderPearlSword.MOD_ID);

    public static final RegistryObject<Item> SWORD = ITEMS.register("sword",
            () -> new EnderSword(ModTiers.Ender, 5, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
