package com.curle.ddock.item;

import com.curle.ddock.block.DBlocks;
import com.curle.ddock.item.other.ItemTesting;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DItems {
	
	public static ItemTesting TestingItem;
	
	public static void init() {
		TestingItem = new ItemTesting();
		registerItems();
	}
	
	public static void registerItems() {
		GameRegistry.register(TestingItem);
		GameRegistry.register(new ItemBlock(DBlocks.BlockTesting), DBlocks.BlockTesting.getRegistryName());
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		TestingItem.initModel();
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DBlocks.BlockTesting), 0, new ModelResourceLocation(DBlocks.BlockTesting.getRegistryName(), "inventory"));
	}

}
