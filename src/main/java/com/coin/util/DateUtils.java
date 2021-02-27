package com.coin.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

	public static final String JSONFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String FILEFORMAT = "yyyy-MM-dd_HH-mm";

	private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

	/*
	* Parser for converting fileName
	* '2021-02-20_19-00.json' to the LocalDateTime API
	*/
	private static final DateTimeFormatter fileNameFormatter = 
		DateTimeFormatter.ofPattern(FILEFORMAT);
	private static final SimpleDateFormat fileNameFormatterToDate =
		new SimpleDateFormat(FILEFORMAT);

	/*
	* Parses the timestamps occuring in the JSON output
	* from CoinMarketCap
	* '2021-02-23T08:00:10.156Z'
	*/
	private static final DateTimeFormatter jsonTimeFormatter = 
		DateTimeFormatter.ofPattern(JSONFORMAT);
	private static final SimpleDateFormat jsonTimeFormatterToDate =
		new SimpleDateFormat(JSONFORMAT);

	private static LocalDateTime parse(String string, DateTimeFormatter formatter) {
		return LocalDateTime.parse(string, formatter);
	}

	private static Date parseDate(String string, SimpleDateFormat formatter) {
		Date date = null;
		try {
			date = formatter.parse(string);
		} catch (ParseException e1) {
			log.warn("Could not parse Date: " + string);
			e1.printStackTrace();
		}
		return date;
	}

	public static LocalDateTime parseDateFromFile(File jsonFile) {
		String fileName = Util.sanitizeDateFromFile(jsonFile);
		return parse(fileName, fileNameFormatter);
	}

	public static Date parseDateFromFileToDate(File jsonFile) {
		String fileName = Util.sanitizeDateFromFile(jsonFile);
		return parseDate(fileName, fileNameFormatterToDate);
	}

	public static LocalDateTime parseJsonDateFormat(String timeStamp) {
		return parse(timeStamp, jsonTimeFormatter);
	}

	public static Date parseJsonDateFormatToDate(String timeStamp) {
		return parseDate(timeStamp, jsonTimeFormatterToDate);
	}
}
