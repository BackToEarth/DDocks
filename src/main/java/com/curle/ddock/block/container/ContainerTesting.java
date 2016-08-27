package com.curle.ddock.block.container;

import com.curle.ddock.block.tile.TileEntityContainerTesting;
import com.sun.istack.internal.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerTesting extends Container {
	
	private TileEntityContainerTesting te;
	
	public ContainerTesting(IInventory pInv, TileEntityContainerTesting te) {
		this.te = te;
		addOwnSlots();
		addPlayerSlots(pInv);
		
	}
	
	private void addPlayerSlots(IInventory pInv) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 9 + col * 18;
				int y = row * 18 + 70;
				this.addSlotToContainer(new Slot(pInv, col + row * 9 + 10, x, y));
			}
		}
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int x = 9;
		int y = 6;
		int slotIndex = 0;
		for (int i = 0; i < slotIndex; i++) {
			addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
			slotIndex++;
			x += 18;
		}
	}
	
	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack item = null;
		Slot slot = this.inventorySlots.get(slotIndex);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack = slot.getStack();
			item = itemstack.copy();
			if (slotIndex < TileEntityContainerTesting.INV_SIZE) {
				if (!this.mergeItemStack(itemstack, TileEntityContainerTesting.INV_SIZE, this.inventorySlots.size(), true));
				return null;
			} else if (!this.mergeItemStack(itemstack, 0, TileEntityContainerTesting.INV_SIZE, false)) {
				return null;
			}
			if (itemstack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return item;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.canInteractWith(player);
	}

}
