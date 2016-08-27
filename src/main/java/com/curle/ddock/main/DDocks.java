package com.curle.ddock.main;

import org.apache.logging.log4j.Logger;

import com.curle.ddock.block.DBlocks;
import com.curle.ddock.item.DItems;
import com.curle.ddock.proxy.ClientProxy;
import com.curle.ddock.proxy.CommonProxy;
import com.curle.ddock.utility.Utils;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Utils.MODID, version = Utils.VER, name = Utils.NAME, dependencies = "required-after:Forge@[12.18.1.2065,]", useMetadata = Utils.USEMETA)

public class DDocks {
	
	@SidedProxy(clientSide = "com.curle.ddock.proxy.ClientProxy", serverSide = "com.curle.ddock.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static DDocks instance;
	
	public static Logger log;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		DBlocks.init();
		DItems.init();
		ClientProxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ClientProxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
