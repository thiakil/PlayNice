package com.thiakil.wecanhavenicethings.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		testBlock.initModel();
	}
}
