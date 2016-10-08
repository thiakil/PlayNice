package com.thiakil.wecanhavenicethings.blocks;

import com.thiakil.wecanhavenicethings.NiceThings;
import com.thiakil.wecanhavenicethings.api.capabilities.IWrench;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WrenchTestBlock extends Block /*implements ITileEntityProvider*/ {
	
	public static ItemBlock itemblock;

    @CapabilityInject(IWrench.class)
    public static Capability<IWrench> WRENCH_CAPABILITY = null;
	
    public WrenchTestBlock() {
        super(Material.ROCK);
        setUnlocalizedName(NiceThings.MODID + ".wrenchtestblock");
        setRegistryName("wrenchtestblock");
        GameRegistry.register(this);
        itemblock = new ItemBlock(this);
	    itemblock.setRegistryName("wrenchtestblock");
        GameRegistry.register(itemblock);
	    setCreativeTab(CreativeTabs.MISC);
    }

	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if (worldIn.isRemote)
			return false;
		if (heldItem != null && heldItem.hasCapability(WRENCH_CAPABILITY, null)){
			IWrench wrench = heldItem.getCapability(WRENCH_CAPABILITY, null);
			switch (wrench.canWrench(heldItem, playerIn)){
				case UNABLE:
					playerIn.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Wrench used, but not able: "+heldItem.getItem().getClass().toString()));
					break;
				case ROTATE:
					playerIn.addChatComponentMessage(new TextComponentString(TextFormatting.GREEN + "Wrench says rotate: "+heldItem.getItem().getClass().toString()));
					break;
				case DISMANTLE:
					playerIn.addChatComponentMessage(new TextComponentString(TextFormatting.GREEN + "Wrench says dismantle: "+heldItem.getItem().getClass().toString()));
					break;
			}
			return true;
		}

		playerIn.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Activated, but no wrench."));

		return false;
    }

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(itemblock, 0, new ModelResourceLocation(itemblock.getRegistryName(), "inventory"));
	}

}
