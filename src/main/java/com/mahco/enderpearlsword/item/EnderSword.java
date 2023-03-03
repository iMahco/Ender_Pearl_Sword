package com.mahco.enderpearlsword.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EnderSword extends SwordItem {


    public EnderSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    public InteractionResultHolder<ItemStack> use(Level lvl, Player user, InteractionHand useHand) {
        ItemStack epearl = new ItemStack(Items.ENDER_PEARL);
        ItemStack wep = user.getItemInHand(useHand);
        lvl.playSound((Player)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (user.getRandom().nextFloat() * 0.4F + 0.8F));
        user.getCooldowns().addCooldown(this, 20);
        if (!lvl.isClientSide) {
            ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(lvl, user);
            thrownenderpearl.setItem(epearl);
            thrownenderpearl.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 1.5F, 1.0F);
            lvl.addFreshEntity(thrownenderpearl);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!user.getAbilities().instabuild) {
            //itemstack.shrink(1); //will remove 1 item, but since its a wep we don't want it gone; just durability dmg
            wep.hurtAndBreak(3, user, e -> e.broadcastBreakEvent(useHand));
        }

        return InteractionResultHolder.sidedSuccess(wep, lvl.isClientSide());
    }

}
