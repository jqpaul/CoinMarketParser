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

public class JsonParser implements IParser<Statistic> {
	private static final Logger log = 
		LoggerFactory.getLogger(JsonParser.class);
	
	private Gson gson;
	private List<File> file;

	/*
	* Create instances only from static factory
	*/
	private JsonParser(List<File> file) {
		this.file = file;
		setupGson();
	}

	public static JsonParser fromFile(File file) {
		return new JsonParser(Arrays.asList(file.listFiles()));
	}

	public static JsonParser fromArgs(String[] args) {
		return new JsonParser(Util.getFiles(args[0]));
	}

	private void setupGson() {
		gson = new GsonBuilder()
			.setDateFormat(DateUtils.JSONFORMAT)
			.create();
	}

	private Optional<Statistic> process(File file) {
		log.info("Processing file: " + file.getName());
		Statistic stats = null;
		try (FileReader fileReader = new FileReader(file);
				JsonReader reader = new JsonReader(fileReader)) {
			stats = gson.fromJson(reader, Statistic.class);
		} catch (IOException e1) {
			log.error("Error while parsing file "
					+ file.getName() + " to Json");
			e1.printStackTrace();
		}
		return Optional.ofNullable(stats);
	}

	@Override
	public List<Statistic> read() {
		List<Statistic> stats =
			this.file.stream()
				.map((a) -> process(a))
				.filter(Optional::isPresent)
				.filter(a -> a.get().getData().size() > 0)
				.map(Optional::get)
				.collect(Collectors.toList());
		return stats;
	}
}
