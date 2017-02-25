package io.github.mc_umod.corelib.asm.transformer;

import java.util.HashMap;

import io.github.mc_umod.corelib.asm.*;
import io.github.mc_umod.corelib.asm.visitor.LayerCapeVisitor;
import net.minecraft.launchwrapper.IClassTransformer;

public class CoreLibTransformer implements IClassTransformer {
	
	private HashMap<String, MinecraftClassVisitor> visitors;
	private VisitorHelper helper;
	
	public CoreLibTransformer() {
		this.visitors = new HashMap<>();
		this.registerNodes();
		this.helper = new VisitorHelper(visitors);
	}
	
	private void registerNodes() {
		this.visitors.put("net.minecraft.client.renderer.entity.layers.LayerCape", new LayerCapeVisitor());
	}
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] bytes) {
		return this.helper.transform(bytes, transformedName);
	}
	
}
