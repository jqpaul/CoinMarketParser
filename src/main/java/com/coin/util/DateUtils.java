package com.coin.util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

	public static final String JSONFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

	/*
	* Parser for converting fileName
	* '2021-02-20_19-00.json' to the LocalDateTime API
	*/
	private static final DateTimeFormatter fileNameFormatter = 
		DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");

	/*
	* Parses the timestamps occuring in the JSON output
	* from CoinMarketCap
	* '2021-02-23T08:00:10.156Z'
	*/
	private static final DateTimeFormatter jsonTimeFormatter = 
		DateTimeFormatter.ofPattern(JSONFORMAT);

	private static LocalDateTime parse(String string, DateTimeFormatter formatter) {
		return LocalDateTime.parse(string, formatter);
	}

	public static LocalDateTime parseDateFromFile(File jsonFile) {
		String fileName = jsonFile.getName().split(".")[0];
		return parse(fileName, fileNameFormatter);
	}

	public static LocalDateTime parseJsonDateFormat(String timeStamp) {
		return parse(timeStamp, jsonTimeFormatter);
	}
}
