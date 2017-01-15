package com.thiakil.playnice.capabilities;

import cofh.api.item.IToolHammer;
import com.thiakil.playnice.api.capabilities.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

public class GenericWrenchProvider implements ICapabilityProvider, IWrench {
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == com.thiakil.playnice.api.capabilities.Capabilities.WRENCH_HANDLER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return capability == com.thiakil.playnice.api.capabilities.Capabilities.WRENCH_HANDLER ? (T)this : null;
	}

	@Override
	public WrenchMode canWrench(ItemStack stack, EntityPlayer player) {
		return player.isSneaking() ? WrenchMode.DISMANTLE : WrenchMode.ROTATE;
	}

	@Override
	public void wrenched(ItemStack stack, EntityPlayer player) {

	}
}
