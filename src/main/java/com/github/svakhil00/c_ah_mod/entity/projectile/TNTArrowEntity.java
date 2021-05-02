package com.github.svakhil00.c_ah_mod.entity.projectile;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TNTArrowEntity extends AbstractArrowEntity {

	public TNTArrowEntity(EntityType<? extends AbstractArrowEntity> livingEntity, World world) {
		super(livingEntity, world);
	}

	public TNTArrowEntity(World world, LivingEntity livingEntity) {
		super(ModEntityTypes.TNT_ARROW_ENTITY.orElseThrow(IllegalStateException::new), livingEntity, world);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// TODO Auto-generated method stub
		super.onHitEntity(result);
		if (!this.level.isClientSide) {
			explode();
		}
		this.remove();
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		if (!this.level.isClientSide) {
			explode();
		}
		this.remove();
	}
	
	private void explode() {
		this.level.explode(this, this.getX(), this.getY(), this.getZ(), 4.0F, Explosion.Mode.BREAK);
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
