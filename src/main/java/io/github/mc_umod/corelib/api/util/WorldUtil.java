package io.github.mc_umod.corelib.api.util;

import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class WorldUtil {
	
	public static boolean isBlockOver(World world, BlockPos blockpos) {
		for (int i = 1; i < 257; i++) {
			if (!(world.getBlockState(blockpos.up(i)).getBlock() instanceof BlockAir)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNight(World w) {
		WorldServer server = Minecraft.getMinecraft().getIntegratedServer().worldServers[0];
		return !server.isDaytime();
	}
}
