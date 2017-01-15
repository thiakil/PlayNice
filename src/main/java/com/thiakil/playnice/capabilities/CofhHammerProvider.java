package com.thiakil.playnice.capabilities;

import cofh.api.item.IToolHammer;
import com.thiakil.playnice.api.capabilities.*;
import com.thiakil.playnice.api.capabilities.Capabilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

public class CofhHammerProvider implements ICapabilityProvider, IWrench {
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == Capabilities.WRENCH_HANDLER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return capability == Capabilities.WRENCH_HANDLER ? (T)this : null;
	}

	@Override
	public WrenchMode canWrench(ItemStack stack, EntityPlayer player) {
		if (((IToolHammer)stack.getItem()).isUsable(stack, player, player.getPosition())){
			return player.isSneaking() ? WrenchMode.DISMANTLE : WrenchMode.ROTATE;
		}
		return WrenchMode.UNABLE;
	}

	@Override
	public void wrenched(ItemStack stack, EntityPlayer player) {
		((IToolHammer)stack.getItem()).toolUsed(stack,player, player.getPosition());
	}
}
