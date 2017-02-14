package io.github.mc_umod.corelib;

import java.io.File;

import org.apache.logging.log4j.*;

import io.github.mc_umod.corelib.api.*;
import io.github.mc_umod.corelib.core.*;
import io.github.mc_umod.corelib.plugin.CoreLibModContainer;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.WrongMinecraftVersionException;
import net.minecraftforge.fml.relauncher.*;
import scala.actors.threadpool.Arrays;

public final class CoreLib {
	
	private static CoreLib instance;
	
	private CoreLibModContainer modcontainer;
	
	public static final String modid = "corelib";
	public static final String name = "CoreLib";
	public static final String mcversion = "1.10;1.10.2";
	public static final String version = "1.0";
	
	private static final Logger logger = LogManager.getLogger(modid);
	
	public CoreLib(CoreLibModContainer mod) {
		instance = this;
		modcontainer = mod;
		if (!Arrays.asList(mcversion.split(";")).contains(ForgeVersion.mcVersion)) {
			throw new WrongMinecraftVersionException(modcontainer, mcversion);
		}
	}
	
	public static CoreLib getInstance() {
		return instance;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	@SideOnly(Side.CLIENT)
	public ClientRegistry getClientRegistry() {
		return new CoreClientRegistry();
	}
	
	public CommonRegistry getCommonRegistry() {
		return new CoreCommonRegistry();
	}
	
	public File getMainDirectory() {
		return new File(System.getProperty("user.dir"));
	}
	
	public CoreLibModContainer getModcontainer() {
		return modcontainer;
	}
}
