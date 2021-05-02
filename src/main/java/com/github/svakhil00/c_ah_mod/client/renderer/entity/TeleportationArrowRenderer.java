package com.github.svakhil00.c_ah_mod.client.renderer.entity;

import com.github.svakhil00.c_ah_mod.entity.projectile.TeleportationArrowEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class TeleportationArrowRenderer extends ArrowRenderer<TeleportationArrowEntity>{
	public static final ResourceLocation TELEPORTATION_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");


	public TeleportationArrowRenderer(EntityRendererManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public TeleportationArrowRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(renderManagerIn);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TeleportationArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return TELEPORTATION_ARROW_LOCATION;
	}
}
