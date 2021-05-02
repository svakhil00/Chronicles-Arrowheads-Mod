package com.github.svakhil00.c_ah_mod.client;

import com.github.svakhil00.c_ah_mod.Arrowheads;
import com.github.svakhil00.c_ah_mod.client.renderer.entity.FlameArrowRenderer;
import com.github.svakhil00.c_ah_mod.client.renderer.entity.LightningArrowRenderer;
import com.github.svakhil00.c_ah_mod.client.renderer.entity.TNTArrowRenderer;
import com.github.svakhil00.c_ah_mod.client.renderer.entity.TeleportationArrowRenderer;
import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Arrowheads.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {
	
	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TNT_ARROW_ENTITY.get(),
				manager -> new TNTArrowRenderer(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FLAME_ARROW_ENTITY.get(),
				manager -> new FlameArrowRenderer(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LIGHTNING_ARROW_ENTITY.get(),
				manager -> new LightningArrowRenderer(manager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TELEPORTATION_ARROW_ENTITY.get(),
				manager -> new TeleportationArrowRenderer(manager, Minecraft.getInstance().getItemRenderer()));
		
	}
}
