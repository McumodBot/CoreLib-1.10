package net.hycrafthd.jsonconfiguration;

import java.io.*;

import com.google.gson.*;

import net.hycrafthd.validation.Validate;

public class BaseConfiguration implements Configuration {
	
	private final File file;
	private final Gson gson;
	private JsonObject json;
	
	public BaseConfiguration(File file) {
		this(file, new GsonBuilder().setPrettyPrinting().create());
	}
	
	public BaseConfiguration(File file, Gson gson) {
		this.file = Validate.notNullEx(file);
		this.gson = Validate.notNullEx(gson);
	}
	
	@Override
	public void save() {
		try {
			if (this.file.isDirectory()) {
				throw new IllegalArgumentException("Only files are allowed!");
			}
			this.createFileIfNotExist();
			
			FileWriter writer = new FileWriter(this.file);
			if (Validate.isNull(this.json)) {
				this.json = new JsonObject();
			}
			this.gson.toJson(this.json, writer);
			writer.flush();
			writer.close();
			
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
	@Override
	public void load() {
		try {
			if (this.file.isDirectory()) {
				throw new IllegalArgumentException("Only files are allowed!");
			}
			if (!this.file.exists()) {
				this.createFileIfNotExist();
			}
			if (!this.file.canRead()) {
				throw new IOException("No permission to read file!");
			}
			if (Validate.notNull(json)) {
				throw new UnsupportedOperationException("Can't load config, because it is already loaded. Use Configuration.reload(); instead!");
			}
			FileReader reader = new FileReader(file);
			this.json = this.gson.fromJson(reader, JsonObject.class);
			reader.close();
			
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
	@Override
	public void reload() {
		this.json = null;
		this.load();
	}
	
	@Override
	public final File getFile() {
		return this.file;
	}
	
	@Override
	public void clearConfig() {
		this.json = null;
		this.save();
	}
	
	@Override
	public void createFileIfNotExist() {
		try {
			if (!this.file.exists()) {
				if (this.file.getParent() != null) {
					File parent = new File(this.file.getParent());
					if (Validate.notNull(parent)) {
						parent.mkdirs();
					}
				}
				this.file.createNewFile();
			}
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
	@Override
	public void set(String key, Object obj) {
		if (Validate.isNull(this.json)) {
			this.json = new JsonObject();
		}
		if (Validate.isNull(obj)) {
			this.json.add(key, null);
		} else {
			this.json.add(key, this.gson.toJsonTree(obj));
		}
	}
	
	@Override
	public JsonElement getJsonElement(String key) {
		if (Validate.isNull(this.json)) {
			this.json = new JsonObject();
		}
		return json.get(key);
	}
	
	@Override
	public <T> T get(String key, Class<T> type) {
		JsonElement element = getJsonElement(key);
		if (Validate.isNull(element)) {
			return null;
		}
		return gson.fromJson(element, type);
	}
	
	@Override
	public String getString(String key) {
		JsonElement element = this.getJsonElement(key);
		if (Validate.isNull(element)) {
			return null;
		}
		return element.getAsString();
	}
	
	@Override
	public Number getNumber(String key) {
		JsonElement element = this.getJsonElement(key);
		if (Validate.isNull(element)) {
			return null;
		}
		return element.getAsNumber();
	}
	
	@Override
	public Boolean getBoolean(String key) {
		JsonElement element = this.getJsonElement(key);
		if (Validate.isNull(element)) {
			return null;
		}
		return element.getAsBoolean();
	}
	
	@Override
	public String toString() {
		return json.toString();
	}
	
}
