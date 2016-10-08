package com.thiakil.wecanhavenicethings.capabilities;

import com.thiakil.wecanhavenicethings.api.capabilities.IWrench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityManager;


public class DefaultWrench implements IWrench {

	public static void register(){
		CapabilityManager.INSTANCE.register(IWrench.class, new NullStorage<>(), DefaultWrench.class);
	}

	@Override
	public WrenchMode canWrench(ItemStack stack, EntityPlayer player){
		return player.isSneaking() ? WrenchMode.DISMANTLE : WrenchMode.ROTATE;
	}

	public void wrenched(ItemStack stack, EntityPlayer player){}
}
