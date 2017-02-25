package io.github.mc_umod.corelib.asm.visitor;

import java.util.ListIterator;

import org.objectweb.asm.tree.*;

import io.github.mc_umod.corelib.asm.MinecraftClassVisitor;
import io.github.mc_umod.corelib.event.CapeUpdatedEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

public class LayerCapeVisitor extends MinecraftClassVisitor {
	
	@Override
	public void transform(ClassNode node) {
		for (MethodNode methodNode : node.methods) {
			
			if (methodNode.name.equals("doRenderLayer")) {
				
				boolean injectmethod = false;
				
				ListIterator<AbstractInsnNode> it = methodNode.instructions.iterator();
				
				while (it.hasNext()) {
					
					AbstractInsnNode ain = it.next();
					
					if (ain instanceof MethodInsnNode) {
						
						MethodInsnNode min = (MethodInsnNode) ain;
						
						if (min.name.equals("getLocationCape")) { // TODO Methodmatcher (obfuscation)
							
							if (!injectmethod) {
								
								injectmethod = true;
								
								InsnList list = new InsnList();
								
								list.add(new LabelNode());
								list.add(new VarInsnNode(ALOAD, 1));
								list.add(new MethodInsnNode(INVOKESTATIC, "io/github/mc_umod/corelib/asm/visitor/LayerCapeVisitor", "getCapeLocation", "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;", false));
								list.add(new VarInsnNode(ASTORE, 100));
								
								methodNode.instructions.insert(list);
								
							}
							
							it.remove();
							
							it.previous();
							it.remove();
							
							it.add(new VarInsnNode(ALOAD, 100));
						}
					}
				}
			}
		}
	}
	
	public static ResourceLocation getCapeLocation(AbstractClientPlayer player) {
		CapeUpdatedEvent event = new CapeUpdatedEvent(player);
		MinecraftForge.EVENT_BUS.post(event);
		return event.getResourceLocation();
	}
	
}
