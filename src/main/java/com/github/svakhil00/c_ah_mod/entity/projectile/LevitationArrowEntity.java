package com.github.svakhil00.c_ah_mod.entity.projectile;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class LevitationArrowEntity extends AbstractArrowEntity {

	public LevitationArrowEntity(EntityType<? extends AbstractArrowEntity> livingEntity, World world) {
		super(livingEntity, world);
	}

	public LevitationArrowEntity(World world, LivingEntity livingEntity) {
		super(ModEntityTypes.LEVITATION_ARROW_ENTITY.orElseThrow(IllegalStateException::new), livingEntity, world);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// TODO Auto-generated method stub
		Entity entity = result.getEntity();
		Entity owner = this.getOwner();
		LivingEntity livingEntity = owner instanceof LivingEntity ? (LivingEntity) owner : null;
		boolean flag = entity.hurt(DamageSource.indirectMobAttack(this, livingEntity).setProjectile(), 4.0F);
		if (flag) {
			this.doEnchantDamageEffects(livingEntity, entity);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).addEffect(new EffectInstance(Effects.LEVITATION, 100));
			}
		}
		super.onHitEntity(result);
		this.remove();
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
	}

	@Override
	protected ItemStack getPickupItem() {
		return null;
		// TODO Auto-generated method stub
		// return new ItemStack(ModItems.TNT_ARROW.get());
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
