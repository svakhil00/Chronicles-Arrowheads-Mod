package com.github.svakhil00.c_ah_mod.client.renderer.entity;

import com.github.svakhil00.c_ah_mod.entity.projectile.FlameArrowEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class FlameArrowRenderer extends ArrowRenderer<FlameArrowEntity>{
	public static final ResourceLocation FLAME_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");

	public FlameArrowRenderer(EntityRendererManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public FlameArrowRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(FlameArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return FLAME_ARROW_LOCATION;
	}
}
