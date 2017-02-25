package io.github.mc_umod.corelib.util;

import java.io.File;

public class FileUtil {
	
	public static File[] getFilesInDirectionary(File file) throws Exception {
		return file.listFiles();
	}
	
	public static String[] getFileNamesInDirectionary(File file, String toreplace, String replaced) throws Exception {
		if (file.exists()) {
			File[] files = getFilesInDirectionary(file);
			if (files != null) {
				String[] names = new String[files.length];
				for (int i = 0; i < files.length; i++) {
					names[i] = files[i].getName().replaceAll(toreplace, replaced);
				}
				return names;
			}
		}
		return new String[] {};
	}
	
}
