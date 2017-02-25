package io.github.mc_umod.corelib.plugin;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.*;

@TransformerExclusions("io.github.mc_umod.corelib.asm.transformer")
@Name(value = "CoreLibPlugin")
public class CoreLibPlugin implements IFMLLoadingPlugin {
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[] { "io.github.mc_umod.corelib.asm.transformer.CoreLibTransformer" };
	}
	
	@Override
	public String getModContainerClass() {
		return "io.github.mc_umod.corelib.plugin.CoreLibModContainer";
	}
	
	@Override
	public String getSetupClass() {
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) {
	}
	
	@Override
	public String getAccessTransformerClass() {
		return null;
	}
	
}
