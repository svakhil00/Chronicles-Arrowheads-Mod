package com.github.svakhil00.c_ah_mod.client.renderer.entity;

import com.github.svakhil00.c_ah_mod.entity.projectile.TNTArrowEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class TNTArrowRenderer extends ArrowRenderer<TNTArrowEntity>{
	public static final ResourceLocation TNT_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");

	public TNTArrowRenderer(EntityRendererManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	public TNTArrowRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(TNTArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return TNT_ARROW_LOCATION;
	}

}
