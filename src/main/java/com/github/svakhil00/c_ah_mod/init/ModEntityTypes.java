package com.github.svakhil00.c_ah_mod.init;

import com.github.svakhil00.c_ah_mod.Arrowheads;
import com.github.svakhil00.c_ah_mod.entity.projectile.FlameArrowEntity;
import com.github.svakhil00.c_ah_mod.entity.projectile.LevitationArrowEntity;
import com.github.svakhil00.c_ah_mod.entity.projectile.LightningArrowEntity;
import com.github.svakhil00.c_ah_mod.entity.projectile.TNTArrowEntity;
import com.github.svakhil00.c_ah_mod.entity.projectile.TeleportationArrowEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Arrowheads.MODID);

	public static final RegistryObject<EntityType<TNTArrowEntity>> TNT_ARROW_ENTITY = ENTITY_TYPES.register("tnt_arrow", () -> EntityType.Builder.<TNTArrowEntity>of(TNTArrowEntity::new, EntityClassification.MISC).sized(.5F, .5F)
					.clientTrackingRange(4).updateInterval(20).build(Arrowheads.MODID + ":tnt_arrow"));
	public static final RegistryObject<EntityType<FlameArrowEntity>> FLAME_ARROW_ENTITY = ENTITY_TYPES.register("flame_arrow", () -> EntityType.Builder.<FlameArrowEntity>of(FlameArrowEntity::new, EntityClassification.MISC).sized(.5F, .5F)
			.clientTrackingRange(4).updateInterval(20).build(Arrowheads.MODID + ":flame_arrow"));
	public static final RegistryObject<EntityType<LightningArrowEntity>> LIGHTNING_ARROW_ENTITY = ENTITY_TYPES.register("lightning_arrow", () -> EntityType.Builder.<LightningArrowEntity>of(LightningArrowEntity::new, EntityClassification.MISC).sized(.5F, .5F)
			.clientTrackingRange(4).updateInterval(20).build(Arrowheads.MODID + ":lightning_arrow"));
	public static final RegistryObject<EntityType<TeleportationArrowEntity>> TELEPORTATION_ARROW_ENTITY = ENTITY_TYPES.register("teleportation_arrow", () -> EntityType.Builder.<TeleportationArrowEntity>of(TeleportationArrowEntity::new, EntityClassification.MISC).sized(.5F, .5F)
			.clientTrackingRange(4).updateInterval(20).build(Arrowheads.MODID + ":teleportation_arrow"));
	public static final RegistryObject<EntityType<LevitationArrowEntity>> LEVITATION_ARROW_ENTITY = ENTITY_TYPES.register("levitation_arrow", () -> EntityType.Builder.<LevitationArrowEntity>of(LevitationArrowEntity::new, EntityClassification.MISC).sized(.5F, .5F)
			.clientTrackingRange(4).updateInterval(20).build(Arrowheads.MODID + ":levitation_arrow"));

}
