package com.coin.parser;

import java.util.List;


/**
* Used to parse Type T
*/
public interface IParser<T> {
	/**
	* Returns List of generic types T wrapped in a Optional.
	* 
	* @return List of parsed Ts
	*/
	public List<T> read();
}
