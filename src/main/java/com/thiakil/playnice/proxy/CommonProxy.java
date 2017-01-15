package com.thiakil.playnice.proxy;

import com.thiakil.playnice.EventHandler;
import com.thiakil.playnice.blocks.WrenchTestBlock;
import com.thiakil.playnice.capabilities.Capabilities;
import com.thiakil.playnice.util.WrenchChecker;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	protected static WrenchTestBlock testBlock;
	private static EventHandler evt = new EventHandler();

	public void preInit(FMLPreInitializationEvent e) {
		testBlock = new WrenchTestBlock();
		Capabilities.registerCapabilities();
		MinecraftForge.EVENT_BUS.register(evt);
	}

	public void init(FMLInitializationEvent e){
		WrenchChecker.init();
	}
}
