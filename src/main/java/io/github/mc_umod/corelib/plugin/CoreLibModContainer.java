package io.github.mc_umod.corelib.plugin;

import com.google.common.eventbus.Subscribe;

import io.github.mc_umod.corelib.CoreLib;
import io.github.mc_umod.corelib.api.process.ProcessHandler;
import io.github.mc_umod.corelib.util.CoreDummyModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public final class CoreLibModContainer extends CoreDummyModContainer {
	
	public CoreLibModContainer() {
		super(new CoreLibMetadataFetcher().getModmeta());
		new CoreLib(this);
	}
	
	@Subscribe
	public void init(FMLInitializationEvent event) {
		CoreLib.getInstance().getCommonRegistry().registerEventHandler(new ProcessHandler());
	}
	
}
