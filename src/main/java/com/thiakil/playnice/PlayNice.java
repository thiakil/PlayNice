package com.thiakil.playnice;

import com.thiakil.playnice.api.capabilities.IWrench;
import com.thiakil.playnice.proxy.CommonProxy;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thiakil.playnice.capabilities.Capabilities;

@Mod(modid = PlayNice.MODID, version = PlayNice.VERSION)
public class PlayNice
{
    public static final String MODID = "wecanhavenicethings";
    public static final String VERSION = "_VERSION_";
    
    private Logger logger;

    @Mod.Instance(PlayNice.MODID)
    public static PlayNice instance;

    @SidedProxy(clientSide = "com.thiakil.wecanhavenicethings.proxy.ClientProxy", serverSide = "com.thiakil.wecanhavenicethings.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public PlayNice(){
    	logger = LogManager.getLogger();
    }

    public static PlayNice instance() { return instance; }

	@CapabilityInject(IWrench.class)
	public static Capability<IWrench> WRENCH_CAPABILITY = null;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Capabilities.registerCapabilities();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	//wrenchRegistry.initKnownWrenches();
    }
    
    public static void logError(String msg) {
        instance.logger.log(Level.ERROR, msg);
    }
    
    public static void log(String message) {
        instance.logger.log(Level.INFO, message);
    }
}
