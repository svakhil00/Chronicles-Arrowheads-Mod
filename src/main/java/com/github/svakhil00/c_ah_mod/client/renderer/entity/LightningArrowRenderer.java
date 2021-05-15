package com.github.svakhil00.c_ah_mod.client.renderer.entity;

import com.github.svakhil00.c_ah_mod.Arrowheads;
import com.github.svakhil00.c_ah_mod.entity.projectile.LightningArrowEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class LightningArrowRenderer extends ArrowRenderer<LightningArrowEntity>{
	public static final ResourceLocation LIGHTNING_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");

	public LightningArrowRenderer(EntityRendererManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public LightningArrowRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(LightningArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return LIGHTNING_ARROW_LOCATION;
	}
}
