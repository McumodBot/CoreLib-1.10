package io.github.mc_umod.corelib.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public abstract class MinecraftClassVisitor implements Opcodes {
	
	public abstract void transform(ClassNode node);
	
}
