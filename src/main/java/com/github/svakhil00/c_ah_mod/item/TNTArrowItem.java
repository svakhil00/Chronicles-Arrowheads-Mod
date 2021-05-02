package com.github.svakhil00.c_ah_mod.item;

import com.github.svakhil00.c_ah_mod.entity.projectile.TNTArrowEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TNTArrowItem extends ArrowItem {

	public TNTArrowItem(Properties builder) {
		super(builder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractArrowEntity createArrow(World world, ItemStack itemStack, LivingEntity livingEntity) {
		// TODO Auto-generated method stub
		return new TNTArrowEntity(world, livingEntity);
	}
	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, PlayerEntity player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
	      return enchant <= 0 ? false : this.getClass() == TNTArrowItem.class;
	}
}
