package io.github.mc_umod.corelib.core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.*;

public final class CommonForgeHooks extends ForgeHooks {

	public static void addGrassSeed(ItemStack seed, int weight) {
		MinecraftForge.addGrassSeed(seed, weight);
	}

}
