package com.coin.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Help check validity of arguments passed to the java application
*/
public class CLIHelper {
	private static final Logger log = LoggerFactory.getLogger(CLIHelper.class);

	public static final String USAGE = 
		"CoinMarketParser: read the JSON coming from the CoinMarketCap API\n"
		+ "  Will take the current Path as the json directory\n"
		+ "  If called with argument, will take the given file\n\n"
		+ "Should be called with:\n"
		+ "$> java -jar CoinMarketParser.jar '/home/joe/body.json'";

	public static boolean checkArgumentsValid(String[] args) {
		// has no arguments (take current path)
		if (args.length == 0) {
			return true;
		}

		// has one argument, which is an existing file
		if (args.length == 1) {
			if (new File(args[0]).exists()) {
				return true;
			}
			log.error("The given file: '" + args[0] + "' does not exist");
		}

		System.out.println(USAGE);
		System.exit(1);
		return false;
	}
}
