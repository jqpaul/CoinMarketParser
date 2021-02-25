package com.coin.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	private static final Logger log = LoggerFactory.getLogger(Util.class);

	public static List<File> getFiles(String filePath) {
		log.trace("Retreving latest JSON file...");
		File path = new File(filePath);
		if (path.exists() && path.isDirectory() && path.listFiles().length > 0) {
			return Arrays.asList(path.listFiles());
		} else {
			log.error("Could not read File from command line");
			return null;
		}
	}

}
