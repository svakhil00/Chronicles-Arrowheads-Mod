package com.github.svakhil00.c_ah_mod.client.renderer.entity;

import com.github.svakhil00.c_ah_mod.Arrowheads;
import com.github.svakhil00.c_ah_mod.entity.projectile.LevitationArrowEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class LevitationArrowRenderer extends ArrowRenderer<LevitationArrowEntity>{

	public static final ResourceLocation LEVITATION_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");

	public LevitationArrowRenderer(EntityRendererManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	public LevitationArrowRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(LevitationArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return LEVITATION_ARROW_LOCATION;
	}
}
