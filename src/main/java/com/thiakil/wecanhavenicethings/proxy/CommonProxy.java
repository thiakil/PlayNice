package com.thiakil.wecanhavenicethings.proxy;

import com.thiakil.wecanhavenicethings.blocks.WrenchTestBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	protected static WrenchTestBlock testBlock;

	public void preInit(FMLPreInitializationEvent e) {
		testBlock = new WrenchTestBlock();
	}
}
