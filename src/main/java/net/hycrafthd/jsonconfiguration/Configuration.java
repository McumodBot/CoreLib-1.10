package net.hycrafthd.jsonconfiguration;

import java.io.File;

import com.google.gson.JsonElement;

public abstract interface Configuration {
	
	public abstract void save();
	
	public abstract void load();
	
	public abstract void reload();
	
	public abstract File getFile();
	
	public abstract void clearConfig();
	
	public abstract void createFileIfNotExist();
	
	public abstract void set(String string, Object obj);
	
	public abstract JsonElement getJsonElement(String key);
	
	public abstract <T> T get(String key, Class<T> type);
	
	public abstract String getString(String key);
	
	public abstract Number getNumber(String key);
	
	public abstract Boolean getBoolean(String key);
	
	public static Configuration createConfiguration(File file) {
		return new BaseConfiguration(file);
	}
	
}
