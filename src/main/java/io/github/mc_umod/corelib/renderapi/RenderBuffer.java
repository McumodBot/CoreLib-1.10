package io.github.mc_umod.corelib.renderapi;

import java.util.ArrayList;

import io.github.mc_umod.corelib.api.util.RGBA;
import net.minecraft.util.math.Vec3d;

/**
 * Vertex buffer and editor 
 * 
 * @author MrTroble
 *
 */

public class RenderBuffer{
	
	public final ArrayList<Vertex> vec = new ArrayList<Vertex>();
	
	public int addVertex(Vec3d vec,RGBA rgb){
		int i = addVertex(vec);
		addColor(rgb, i);
		return i;
	}
	
	public int addVertex(Vec3d vec,double u,double v){
		int i = addVertex(vec);
		addUV(u, v, i);
		return i;
	}
		
	public int addVertex(Vec3d vec){
		int i = this.vec.size();
		this.vec.add(new Vertex(vec));
		return i;
	}
	
	public void addColor(RGBA rgb,int pos){
		this.vec.get(pos).setCollor(rgb);
	}
	
	public void addNormal(Vec3d vec,int pos){
		this.vec.get(pos).setNormal(vec);
	}
	
	public void addUV(double u,double v,int pos){
		this.vec.get(pos).setUV(u, v);
	}
	
	public void draw(){
		for(Vertex v : this.vec){
			v.draw();
		}
	}
	
	public void clear(){
		this.vec.clear();
	}
}
