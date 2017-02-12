package io.github.mc_umod.corelib.api.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;

public class NetworkUtil {
	
	public static void addPosToBuffer(ByteBuf buf, BlockPos ps) {
		buf.writeInt(ps.getX());
		buf.writeInt(ps.getY());
		buf.writeInt(ps.getZ());
	}
	
	public static BlockPos getPosFromBuffer(ByteBuf buf) {
		return new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
	}
}
