package io.github.mc_umod.corelib.plugin;

import io.github.mc_umod.corelib.CoreLib;
import io.github.mc_umod.corelib.util.ModMetadataFetcher;
import net.minecraftforge.fml.common.ModMetadata;

public class CoreLibMetadataFetcher extends ModMetadataFetcher {
	
	public CoreLibMetadataFetcher() {
		super("/corelib.info", CoreLib.modid);
	}
	
	@Override
	public ModMetadata getModmeta() {
		ModMetadata modmeta = super.getModmeta();
		modmeta.name = CoreLib.name;
		modmeta.version = CoreLib.version;
		return modmeta;
	}
}
