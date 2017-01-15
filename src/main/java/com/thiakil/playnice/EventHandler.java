package com.thiakil.playnice;

import com.thiakil.playnice.capabilities.CofhHammerProvider;
import com.thiakil.playnice.capabilities.GenericWrenchProvider;
import com.thiakil.playnice.util.WrenchChecker;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public static CofhHammerProvider hammerProvider = new CofhHammerProvider();
	public static GenericWrenchProvider genericWrenchProvider = new GenericWrenchProvider();

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void attachCapabilitites(AttachCapabilitiesEvent<Item> e){
		//PlayNice.log("Attach capabilities, "+e.getObject().toString());
		Item theItem = e.getObject();
		if (WrenchChecker.cofhHammerPresent && theItem instanceof cofh.api.item.IToolHammer){
			e.addCapability(new ResourceLocation(PlayNice.MODID, "com.thiakil.playnice.capabilities.CofhHammerProvider"), hammerProvider);
		} else if (WrenchChecker.isAWrench(theItem)){
			e.addCapability(new ResourceLocation(PlayNice.MODID, "com.thiakil.playnice.capabilities.GenericWrenchProvider"), genericWrenchProvider);
		}
	}
}
