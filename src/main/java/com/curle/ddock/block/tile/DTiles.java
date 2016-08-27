package com.curle.ddock.block.tile;

import com.curle.ddock.utility.Utils;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DTiles {
	
	public static void initTiles() {
		GameRegistry.registerTileEntity(TileEntityContainerTesting.class, Utils.MODID + "_testingblock");
	}

}
