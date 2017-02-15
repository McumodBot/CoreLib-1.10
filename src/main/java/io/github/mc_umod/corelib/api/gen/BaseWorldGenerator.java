package io.github.mc_umod.corelib.api.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.*;
import net.minecraftforge.fml.common.IWorldGenerator;

public abstract class BaseWorldGenerator implements IWorldGenerator {
	
	protected abstract void nether(Random random, int x, int z, World world);
	
	protected abstract void overworld(Random random, int x, int z, World world);
	
	protected abstract void end(Random random, int x, int z, World world);
	
	@Override
	public final void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		switch (world.provider.getDimension()) {
		case -1:
			nether(random, x, z, world);
			break;
		case 0:
			overworld(random, x, z, world);
			break;
		case 1:
			end(random, x, z, world);
			break;
		}
	}
}
