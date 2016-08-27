package com.curle.ddock.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityContainerTesting  extends TileEntity {
	
	public static final int INV_SIZE = 9;
	private ItemStackHandler itemHandler = new ItemStackHandler(INV_SIZE) {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityContainerTesting.this.markDirty();
		}
	};
	
	@Override
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);
		if (comp.hasKey("items")) {
			itemHandler.deserializeNBT((NBTTagCompound) comp.getTag("items"));
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound comp) {
		super.writeToNBT(comp);
		comp.setTag("items", itemHandler.serializeNBT());
		return comp;
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}
	
	@Override
	public boolean hasCapability(Capability<?> cap, EnumFacing face) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(cap, face);
	}
	
	@Override
	public <T> T getCapability(Capability<T> cap, EnumFacing face) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) itemHandler;
		}
		return super.getCapability(cap, face);
	}

}
