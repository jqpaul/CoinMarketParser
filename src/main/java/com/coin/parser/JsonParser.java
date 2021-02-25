package com.coin.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.coin.data.json.Statistic;
import com.coin.util.DateUtils;
import com.coin.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* JsonParser
*/
public class JsonParser implements IParser {
	private static final Logger log = LoggerFactory.getLogger(JsonParser.class);
	
	private List<File> file;

	/*
	* Create instances only from static factory
	*/
	private JsonParser(List<File> file) {
		this.file = file;
	}

	public static JsonParser fromFile(File file) {
		return new JsonParser(Arrays.asList(file));
	}

	public static JsonParser fromArgs(String[] args) {
		return new JsonParser(Util.getFiles(args[0]));
	}

	@Override
	public Optional<Statistic> read(File file) {
		log.error("Processing file: " + file.getName());
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder()
			.setDateFormat(DateUtils.JSONFORMAT)
			.create();
		Statistic stats = null;
		try (FileReader fileReader = new FileReader(file);
				JsonReader reader = new JsonReader(fileReader)) {
			stats = gson.fromJson(reader, Statistic.class);
			log.info(String.valueOf(stats.getData().length));
		} catch (IOException e1) {
			log.error("Error while parsing file " + file.getName() + " to Json");
			e1.printStackTrace();
		}
		return Optional.ofNullable(stats);
	}

	@Override
	public void process() {
		List<Statistic> stats = 
			this.file.parallelStream()
			.map((a) -> read(a))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toList());
		log.info("Processed " + stats.size() + " JSON-files");
	}
}
