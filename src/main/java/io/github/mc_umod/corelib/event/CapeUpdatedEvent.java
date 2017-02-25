package io.github.mc_umod.corelib.event;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

public class CapeUpdatedEvent extends Event {
	
	private final AbstractClientPlayer player;
	private ResourceLocation resourcelocation;
	
	public CapeUpdatedEvent(AbstractClientPlayer player) {
		this.player = player;
		this.resourcelocation = player.getLocationCape();
	}
	
	public AbstractClientPlayer getPlayer() {
		return player;
	}
	
	public ResourceLocation getResourceLocation() {
		return resourcelocation;
	}
	
	public void setResourceLocation(ResourceLocation resourcelocation) {
		this.resourcelocation = resourcelocation;
	}
	
}
