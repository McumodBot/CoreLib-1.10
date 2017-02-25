package io.github.mc_umod.corelib.plugin;

import com.google.common.eventbus.Subscribe;

import io.github.mc_umod.corelib.CoreLib;
import io.github.mc_umod.corelib.event.CapeUpdatedEvent;
import io.github.mc_umod.corelib.process.ProcessHandler;
import io.github.mc_umod.corelib.util.CoreDummyModContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class CoreLibModContainer extends CoreDummyModContainer {
	
	public CoreLibModContainer() {
		super(new CoreLibMetadataFetcher().getModmeta());
		new CoreLib(this);
	}
	
	@Subscribe
	public void init(FMLInitializationEvent event) {
		CoreLib.getInstance().getCommonRegistry().registerEventHandler(new ProcessHandler());
		CoreLib.getInstance().getCommonRegistry().registerEventHandler(this);
	}
	
	//ONLY DEBUG
	//WILL BE REMOVED.
	@SubscribeEvent
	public void a(CapeUpdatedEvent event) {
		event.setResourceLocation(new ResourceLocation("textures/blocks/ice.png"));
	}
}
