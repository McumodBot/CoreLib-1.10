package io.github.mc_umod.corelib.util.asm;

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

public class MethodMatcher {
	
	private String className;
	private String methodDescription;
	private String methodMcpName;
	private String methodSrgName;
	
	public MethodMatcher(String className, String methoddescription, String methodMcpName, String methodSrgName) {
		this.className = className;
		this.methodDescription = methoddescription;
		this.methodMcpName = methodMcpName;
		this.methodSrgName = methodSrgName;
	}
	
	public MethodMatcher(MappedType mappedtype, String methoddescription, String methodMcpName, String methodSrgName) {
		this(mappedtype.getName(), methoddescription, methodMcpName, methodSrgName);
	}
	
	public boolean match(String methodName, String methodDescription) {
		if (!methodDescription.equals(methodDescription))
			return false;
		if (methodName.equals(methodMcpName))
			return true;
		if (!AsmUtil.useSrgNames())
			return false;
		String mapped = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(className, methodName, methodDescription);
		return mapped.equals(methodSrgName);
	}
	
	@Override
	public String toString() {
		return String.format("%s.[%s,%s] %s", className, methodSrgName, methodMcpName, methodDescription);
	}
	
}