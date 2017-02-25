package io.github.mc_umod.corelib.asm;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;

import java.io.*;
import java.util.*;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;

import io.github.mc_umod.corelib.CoreLib;

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
			
			try {
				FileOutputStream stream = new FileOutputStream(new File("TestClass.class"));
				stream.write(writer.toByteArray());
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return writer.toByteArray();
		}
		return bytes;
	}
	
}
