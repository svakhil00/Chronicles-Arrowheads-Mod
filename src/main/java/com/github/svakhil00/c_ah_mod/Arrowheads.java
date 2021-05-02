package com.github.svakhil00.c_ah_mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.svakhil00.c_ah_mod.init.ModEntityTypes;
import com.github.svakhil00.c_ah_mod.init.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Arrowheads.MODID)
public class Arrowheads
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String 	MODID = "c_ah_mod";

    public Arrowheads() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);
       
        ModItems.ITEMS.register(bus);
        ModEntityTypes.ENTITY_TYPES.register(bus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
     
    }

   
}
