package io.github.mc_umod.corelib.asm;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;

import java.util.*;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;

import io.github.mc_umod.corelib.CoreLib;
import io.github.mc_umod.corelib.util.asm.MinecraftClassVisitor;

public class VisitorHelper {
	
	private Map<String, MinecraftClassVisitor> visitors;
	
	public VisitorHelper(HashMap<String, MinecraftClassVisitor> visitor) {
		this.visitors = visitor;
	}
	
	public byte[] transform(byte[] bytes, String name) {
		if (visitors.containsKey(name)) {
			CoreLib.getLogger().info("Trying to patch class " + name);
			
			ClassNode node = new ClassNode();
			ClassReader reader = new ClassReader(bytes);
			
			reader.accept(node, EXPAND_FRAMES);
			
			MinecraftClassVisitor visitor = visitors.get(name);
			visitor.transform(node);
			
			ClassWriter writer = new ClassWriter(reader, COMPUTE_FRAMES);
			node.accept(writer);
			
			CoreLib.getLogger().info("Successfully patched class " + name);
			
			return writer.toByteArray();
		}
		return bytes;
	}
	
}
