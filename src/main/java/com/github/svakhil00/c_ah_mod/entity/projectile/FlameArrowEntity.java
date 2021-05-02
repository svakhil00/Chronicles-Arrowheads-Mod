package com.github.svakhil00.c_ah_mod.entity.projectile;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;
import com.github.svakhil00.c_ah_mod.init.ModItems;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.TNTBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FlameArrowEntity extends AbstractArrowEntity {
	public FlameArrowEntity(EntityType<? extends AbstractArrowEntity> livingEntity, World world) {
		super(livingEntity, world);
	}

	public FlameArrowEntity(World world, LivingEntity livingEntity) {
		super(ModEntityTypes.FLAME_ARROW_ENTITY.orElseThrow(IllegalStateException::new), livingEntity, world);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		// TODO Auto-generated method stub
		super.onHitEntity(result);
		result.getEntity().setRemainingFireTicks(100);
		blaze();
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		blaze();
		this.remove();
	}

	@SuppressWarnings("deprecation")
	private void blaze() {
		if(!this.level.isClientSide && this.level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
			BlockPos blockpos = this.blockPosition();
			BlockState blockstate = AbstractFireBlock.getState(this.level, blockpos);
			if(this.level.getBlockState(blockpos).isAir() && blockstate.canSurvive(this.level,  blockpos)) {
				this.level.setBlockAndUpdate(blockpos, blockstate);
			}
			
			for(int i = -2; i < 2; i++) {
				for(int j = -2; j < 2; j++) {
					for(int k = -2; k < 2; k++) {
						BlockPos blockpos1 = blockpos.offset(i, j, k);
						blockstate = AbstractFireBlock.getState(this.level, blockpos1);
						if(this.level.getBlockState(blockpos1).isAir() && blockstate.canSurvive(this.level, blockpos1)) {
							this.level.setBlockAndUpdate(blockpos1, blockstate);
						}
					}
				}
			}
		}
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(ModItems.FLAME_ARROW.get());
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
