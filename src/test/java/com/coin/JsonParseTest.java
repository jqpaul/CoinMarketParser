package com.coin;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import com.coin.data.json.Statistic;
import com.coin.parser.IParser;
import com.coin.parser.JsonParser;

import org.junit.Test;

public class JsonParseTest {

	private static final String jsonLocation = "src/test/resources/json/";

	@Test
	public void testJson() {
		File jsonPath = new File(jsonLocation);
		IParser<Statistic> parser = JsonParser.fromFile(jsonPath);
		List<Statistic> stats = parser.read();
		testParsedStatistics(stats);
	}

	private void testParsedStatistics(List<Statistic> stats) {
		assertTrue(stats.size() == 6);
		assertTrue(stats.get(0).getData().get(0).getName().equals("Bitcoin"));
	}
}
