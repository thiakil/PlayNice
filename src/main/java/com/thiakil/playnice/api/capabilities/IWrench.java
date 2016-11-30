package com.thiakil.playnice.api.capabilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IWrench {

	/**
	 * Called to determine if the wrench is capable of performing a function, and if so, which function.
	 * @param stack - ItemStack to test for usability
	 * @param player - The Player performing the action
	 * @return - enum WrenchMode.
	 */
	public WrenchMode canWrench(ItemStack stack, EntityPlayer player);

	/**
	 * Called when an action has been performed using the wrench. Here is where you would subtract durability, power, etc.
	 * @param stack - ItemStack that was used
	 * @param player - The Player who performed the action.
	 */
	public void wrenched(ItemStack stack, EntityPlayer player);

	/**
	 * UNABLE - Wrench is not in a mode to function, no power, etc.
	 * ROTATE - Wrench would like to rotate the block.
	 * DISMANTLE - wrench would like to dismantle (break) the block.
	 */
	public enum WrenchMode {
		UNABLE,
		ROTATE,
		DISMANTLE
	}
}
