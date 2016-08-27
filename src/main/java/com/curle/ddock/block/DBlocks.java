package com.curle.ddock.block;

import com.curle.ddock.block.other.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DBlocks {
	
	public static Block BlockTesting;
	public static Block BlockDisappearing;
	
	
	public static void init() {
		BlockTesting = new BlockTesting();
		BlockDisappearing = new BlockDisappearing();
		registerBlocks();
	}
	
	public static void registerBlocks() {
		GameRegistry.register(BlockTesting);
	}

}
