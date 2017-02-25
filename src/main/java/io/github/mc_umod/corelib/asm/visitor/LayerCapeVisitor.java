package io.github.mc_umod.corelib.asm.visitor;

import java.util.Iterator;

import org.objectweb.asm.tree.*;

import io.github.mc_umod.corelib.util.asm.MinecraftClassVisitor;

public class LayerCapeVisitor extends MinecraftClassVisitor {
	
	@Override
	public void transform(ClassNode node) {
		//Only Testings - EventBus should be implemented..
		for (MethodNode methodNode : node.methods) {
			if (methodNode.name.equals("doRenderLayer")) {
				
				Iterator<AbstractInsnNode> it = methodNode.instructions.iterator();
				
				while (it.hasNext()) {
					AbstractInsnNode ain = it.next();
					
					if (ain instanceof MethodInsnNode) {
						MethodInsnNode min = (MethodInsnNode) ain;
						if (min.name.equals("getLocationCape")) {
							System.out.println(min.owner + " : " + min.name + " : " + min.desc + " : " + min.getOpcode());
							methodNode.instructions.insert(min, new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/client/entity/AbstractClientPlayer", "getLocationSkin", "()Lnet/minecraft/util/ResourceLocation;", false));
							it.remove();
						}
					}
					
				}
			}
		}
	}
	
}
