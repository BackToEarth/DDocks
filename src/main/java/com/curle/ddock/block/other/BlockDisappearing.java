package com.curle.ddock.block.other;

import com.curle.ddock.utility.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDisappearing extends Block {
	
	public BlockDisappearing() {
		super(Material.ROCK);
		setUnlocalizedName(Utils.MODID + ".blocktesting");
		setRegistryName("blocktesting");
	}

}
