package io.github.mc_umod.corelib.util.asm;

import org.objectweb.asm.Type;

public class MappedType {
	
	private String className;
	
	public static MappedType from(String clazzName) {
		return new MappedType(clazzName);
	}
	
	public static MappedType from(Class<?> clazz) {
		return new MappedType(clazz.getName().replace('.', '/'));
	}
	
	private MappedType(String clsName) {
		this.className = AsmUtil.getMappedName(clsName);
	}
	
	public String getName() {
		return className;
	}
	
	public Type getType() {
		return Type.getObjectType(className);
	}
	
}
