package com.github.svakhil00.c_ah_mod.entity.projectile;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TeleportationArrowEntity extends AbstractArrowEntity {

	public TeleportationArrowEntity(EntityType<? extends AbstractArrowEntity> livingEntity, World world) {
		super(livingEntity, world);
	}

	public TeleportationArrowEntity(World world, LivingEntity livingEntity) {
		super(ModEntityTypes.TELEPORTATION_ARROW_ENTITY.orElseThrow(IllegalStateException::new), livingEntity, world);
	}

	@Override
	public void tick() {
		Entity entity = this.getOwner();
		if (entity instanceof PlayerEntity && !entity.isAlive()) {
			this.remove();
		} else {
			super.tick();
		}
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// TODO Auto-generated method stub
		
		Entity entity = this.getOwner();

		for (int i = 0; i < 32; ++i) {
			this.level.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D,
					this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
		}

		if (!this.level.isClientSide && !this.removed) {
			if (entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
				if (serverplayerentity.connection.getConnection().isConnected()
						&& serverplayerentity.level == this.level && !serverplayerentity.isSleeping()) {
					if (this.random.nextFloat() < 0.05F
							&& this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
						EndermiteEntity endermiteentity = EntityType.ENDERMITE.create(this.level);
						endermiteentity.setPlayerSpawned(true);
						endermiteentity.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.yRot, entity.xRot);
						this.level.addFreshEntity(endermiteentity);
					}

					if (entity.isPassenger()) {
						entity.stopRiding();
					}

					Entity mob = result.getEntity();
					mob.teleportTo(entity.getX(), entity.getY(), entity.getZ());
					entity.teleportTo(this.getX(), this.getY(), this.getZ());
					entity.fallDistance = 0.0F;
				}

			} else if (entity != null) {
				Entity mob = result.getEntity();
				mob.teleportTo(entity.getX(), entity.getY(), entity.getZ());
				entity.teleportTo(this.getX(), this.getY(), this.getZ());
				entity.fallDistance = 0.0F;
			}

		}

		super.onHitEntity(result);
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		Entity entity = this.getOwner();

		for (int i = 0; i < 32; ++i) {
			this.level.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D,
					this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
		}

		if (!this.level.isClientSide && !this.removed) {
			if (entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
				if (serverplayerentity.connection.getConnection().isConnected()
						&& serverplayerentity.level == this.level && !serverplayerentity.isSleeping()) {
					if (this.random.nextFloat() < 0.05F
							&& this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
						EndermiteEntity endermiteentity = EntityType.ENDERMITE.create(this.level);
						endermiteentity.setPlayerSpawned(true);
						endermiteentity.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.yRot, entity.xRot);
						this.level.addFreshEntity(endermiteentity);
					}

					if (entity.isPassenger()) {
						entity.stopRiding();
					}

					entity.teleportTo(this.getX(), this.getY(), this.getZ());
					entity.fallDistance = 0.0F;
					entity.hurt(DamageSource.FALL, .5F);
				}

			} else if (entity != null) {
				entity.teleportTo(this.getX(), this.getY(), this.getZ());
				entity.fallDistance = 0.0F;
			}

			this.remove();
		}

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
