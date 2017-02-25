package io.github.mc_umod.corelib.asm.visitor;

public class LayerCapeVisitorOLD  {
	
//	private MethodMatcher matcher;
//	
//	public LayerCapeVisitor(String name, ClassVisitor cw) {
//		super(name, cw);
//		Type type = Type.getMethodType(Type.VOID_TYPE, MappedType.from(AbstractClientPlayer.class).getType(), Type.FLOAT_TYPE, Type.FLOAT_TYPE, Type.FLOAT_TYPE, Type.FLOAT_TYPE, Type.FLOAT_TYPE, Type.FLOAT_TYPE, Type.FLOAT_TYPE);
//		matcher = new MethodMatcher(name, type.getDescriptor(), "doRenderLayer", "doRenderLayer");
//	}
//	
//	@Override
//	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//		MethodVisitor parent = super.visitMethod(access, name, desc, signature, exceptions);
//		if(matcher.match(name, desc)) {
//			return transform(parent);
//		}
//		return parent;
//	}
//	
//	private MethodVisitor transform(MethodVisitor mv) {
//		System.out.println(mv);
//		mv.visitCode();
//	    mv.visitTypeInsn(Opcodes.NEW, "com/github/jcgay/maven/color/logger/AnsiColorLogger");
//	    mv.visitInsn(Opcodes.DUP);
//		return mv;
//	}
//	
////	private static class Visitor extends MethodVisitor {
////		
////		// private final Method method;
////		
////		public Visitor(MethodVisitor mv) {
////			super(Opcodes.ASM5, mv);
////			
////			try {
////				// method = Method.getMethod(RenderPlayerVisitor.class.getMethod("injectMethod", AbstractClientPlayer.class, float.class));
////			} catch (Exception e) {
////				throw Throwables.propagate(e);
////			}
////			System.out.println("starting");
////			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, " net/minecraft/client/entity/AbstractClientPlayer", "getLocationCae", "()Lnet/minecraft/util/ResourceLocation;", false);
////		}
////		
////		@Override
////		public void visitMethodInsn(int opcode, String owner, String name, String desc) {
////			System.out.println(opcode + " : " + owner + " : " + name + " : " + desc);
////		}
////		
////		@Override
////		public void visitInsn(int opcode) {
////		}
////	}
	
}
