package io.github.mc_umod.corelib.renderapi;

import io.github.mc_umod.corelib.api.util.RGBA;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

/**
 * Just a Storage class
 * 
 * @author MrTroble
 *
 */

public class Material {
	
	public final String ID;
	private RGBA color;
	private double width = 0,height = 0;
	private int glTextureId = -1;
	private ResourceLocation texture;
	
	public Material(String name) {
		this.ID = name;
	}
	
	public RGBA getColor() {
		return color;
	}
	
	public void setColor(RGBA c) {
		this.color = c;
	}
	
	public void setMap(String modid, String st) {
		this.texture = new MapResource(modid,st);
	}
	
	public boolean hasTexture() {
		return texture != null;
	}
	
	public boolean hasColor() {
		return color != null;
	}
	
	public void bindTex() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
	}
	
	@Override
	public String toString() {
		return this.ID + " " + this.color.toColor().toString();
	}
	
}
