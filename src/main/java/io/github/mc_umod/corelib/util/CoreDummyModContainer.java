package io.github.mc_umod.corelib.util;

import java.io.File;
import java.net.*;

import com.google.common.eventbus.EventBus;

import net.minecraftforge.fml.client.FMLFileResourcePack;
import net.minecraftforge.fml.common.*;

public abstract class CoreDummyModContainer extends DummyModContainer {
	
	public CoreDummyModContainer(ModMetadata metadata) {
		super(metadata);
	}
	
	@Override
	public final boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}
	
	@Override
	public final Class<?> getCustomResourcePackClass() {
		return FMLFileResourcePack.class;
	}
	
	@Override
	public final File getSource() {
		URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
		File file = null;
		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			file = new File(url.getPath());
		}
		return file;
	}
	
}
