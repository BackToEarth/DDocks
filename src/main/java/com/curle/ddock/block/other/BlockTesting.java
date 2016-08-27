package com.curle.ddock.block.other;

import com.curle.ddock.block.tile.TileEntityContainerTesting;
import com.curle.ddock.main.DDocks;
import com.curle.ddock.utility.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTesting extends Block implements ITileEntityProvider {
	
	public static final int GUID = 1;
	
	public BlockTesting() {
		super(Material.ROCK);
		setUnlocalizedName(Utils.MODID + ".blocktesting");
		setRegistryName("blocktesting");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityContainerTesting();
	}
	
	@Override
	public boolean onBlockActivated(World wrld, BlockPos pos, IBlockState ste, EntityPlayer plr, EnumHand hnd, ItemStack itm, EnumFacing sde,
			float hitX, float hitY, float hitZ) {
		
		if(wrld.isRemote) {
			return true;
		}
		
		TileEntity te = wrld.getTileEntity(pos);
		if (!(te instanceof TileEntityContainerTesting)) {
			return false;
		}
		
		plr.openGui(DDocks.instance, GUID, wrld, pos.getX(), pos.getY(), pos.getZ());
		
		return true;
	}
}
