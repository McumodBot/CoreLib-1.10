package io.github.mc_umod.corelib.api.util;

import java.util.Random;

import io.github.mc_umod.corelib.api.gen.OreGen;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenerationUtil {
	
	public static void generateOre(OreGen oregen, Random random, int x, int z, World world) {
		
		int vienSize = 2 + oregen.getMinVienSize() + random.nextInt(oregen.getMaxVienSize() - oregen.getMinVienSize() + 1);
		int hightRange = oregen.getMaxY() - oregen.getMinY();
		
		for (int i = 0; i < oregen.getChance(); i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(hightRange) + oregen.getMinY();
			int posZ = z + random.nextInt(16);
			new WorldGenMinable(oregen.getState(), vienSize, BlockMatcher.forBlock(oregen.getBlockin())).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
}
