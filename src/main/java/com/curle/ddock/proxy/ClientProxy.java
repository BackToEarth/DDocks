package com.curle.ddock.proxy;

import com.curle.ddock.gui.GuiHandler;
import com.curle.ddock.item.DItems;
import com.curle.ddock.main.DDocks;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		DItems.initModels();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(DDocks.instance, new GuiHandler());
	}
	
		
}
