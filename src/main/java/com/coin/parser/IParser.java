package com.coin.parser;

import java.io.File;
import java.util.Optional;

import com.coin.data.json.Statistic;

/**
* AbstractParser
*/
public interface IParser {
	public Optional<Statistic> read(File file);
	public void process();
}
