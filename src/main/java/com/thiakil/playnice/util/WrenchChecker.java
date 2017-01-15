package com.thiakil.playnice.util;

/* Copied from https://github.com/McJty/McJtyLib/blob/1.10/src/main/java/mcjty/lib/varia/WrenchChecker.java

Props to McJty & the user who helped him with it initially.
 */

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class WrenchChecker {

	private static List<Class> wrenchClasses=new ArrayList<Class>();

	public static boolean cofhHammerPresent = false;

	public static void init() {
		for (String className : new String[] {
                /*
                 * Can add or remove class names here
                 * Use API interface names where possible, in case of refactoring
                 * note that many mods implement BC wrench API iff BC is installed
                 * and include no wrench API of their own - we use implementation
                 * classes here to catch these cases.
                */
				"cofh.api.item.IToolHammer",                    //Thermal Expansion and compatible
                "buildcraft.api.tools.IToolWrench",             //Buildcraft
				"resonant.core.content.ItemScrewdriver",        //Resonant Induction
				"ic2.core.item.tool.ItemToolWrench",            //IC2
				"ic2.core.item.tool.ItemToolWrenchElectric",    //IC2 (more)
				"mrtjp.projectred.api.IScrewdriver",            //Project Red
				"mods.railcraft.api.core.items.IToolCrowbar",   //Railcraft
				"com.bluepowermod.items.ItemScrewdriver",       //BluePower
				"thermalexpansion.item.tool.ItemWrench",
				"appeng.items.tools.quartz.ToolQuartzWrench",   //Applied Energistics
				"crazypants.enderio.api.tool.ITool",            //Ender IO
				"mekanism.api.IMekWrench",                      //Mekanism
				"mcjty.rftools.items.smartwrench",              //RFTools
				"pneumaticCraft.common.item.ItemPneumaticWrench",
				"powercrystals.minefactoryreloaded.api.IToolHammer"

		}) {
			try {
				wrenchClasses.add(Class.forName(className));
				if (className.equals("cofh.api.item.IToolHammer")){
					cofhHammerPresent = true;
				}
			} catch (ClassNotFoundException e) {

			}
		}
	}

	public static boolean isAWrench(Item item) {
		for (Class c : wrenchClasses) {
			if (c.isAssignableFrom(item.getClass())) {
				return true;
			}
		}
		return false;
	}

}
