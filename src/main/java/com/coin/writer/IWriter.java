package com.coin.writer;

import java.util.List;

/**
* Writer interface to complement the parser.
* Serialize to Database or file.
*/
public interface IWriter<T> {
	/**
	* abstract writing of information
	*/
	public void write(List<T> t);
}
