package com.thiakil.playnice.proxy;

import com.thiakil.playnice.blocks.WrenchTestBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	protected static WrenchTestBlock testBlock;

	public void preInit(FMLPreInitializationEvent e) {
		testBlock = new WrenchTestBlock();
	}
}
