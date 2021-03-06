package com.curle.ddock.gui;

import com.curle.ddock.block.container.ContainerTesting;
import com.curle.ddock.block.tile.TileEntityContainerTesting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof TileEntityContainerTesting) {
			return new ContainerTesting(player.inventory, (TileEntityContainerTesting) te);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof TileEntityContainerTesting) {
			TileEntityContainerTesting teCont = (TileEntityContainerTesting) te;
			return new GuiContainerTesting(teCont, new ContainerTesting(player.inventory, teCont));
		} else {
			return null;
		}
	}

}
