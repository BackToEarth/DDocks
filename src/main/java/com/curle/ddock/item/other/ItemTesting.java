package com.curle.ddock.item.other;

import com.curle.ddock.utility.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTesting extends Item {
	
	public ItemTesting() {
		super();
		setUnlocalizedName(Utils.MODID + ".itemtesting");
		setRegistryName("itemtesting");
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
}
