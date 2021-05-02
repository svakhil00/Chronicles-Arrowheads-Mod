package com.github.svakhil00.c_ah_mod.entity.projectile;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;
import com.github.svakhil00.c_ah_mod.init.ModItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningArrowEntity extends AbstractArrowEntity{
	public LightningArrowEntity(EntityType<? extends AbstractArrowEntity> livingEntity, World world) {
		super(livingEntity, world);
	}

	public LightningArrowEntity(World world, LivingEntity livingEntity) {
		super(ModEntityTypes.LIGHTNING_ARROW_ENTITY.orElseThrow(IllegalStateException::new), livingEntity, world);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// TODO Auto-generated method stub
		super.onHitEntity(result);
		if(this.level instanceof ServerWorld) {
			LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(this.level);
			lightning.moveTo(result.getLocation());
			lightning.setCause(this.getOwner() instanceof ServerPlayerEntity ? (ServerPlayerEntity)this.getOwner() : null);
			this.level.addFreshEntity(lightning);
		}
		this.remove();
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		if(this.level instanceof ServerWorld) {
			LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(this.level);
			lightning.moveTo(result.getLocation());
			lightning.setCause(this.getOwner() instanceof ServerPlayerEntity ? (ServerPlayerEntity)this.getOwner() : null);
			this.level.addFreshEntity(lightning);
		}
		this.remove();
	}
	

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(ModItems.LIGHTNING_ARROW.get());
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
