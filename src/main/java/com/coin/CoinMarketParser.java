package com.coin;

import com.coin.parser.JsonParser;
import com.coin.parser.IParser;
import com.coin.util.CLIHelper;

/*
* One line to give the program's name and a brief description.
* Copyright © 2021
* 
* This program  is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Affero General Public License for more details.
* 
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

public class CoinMarketParser {

    public static void main(String[] args) {
		CLIHelper.checkArgumentsValid(args);
		IParser parser = JsonParser.fromArgs(args);
		parser.process();

		// Hibernate does not want to quit the session on its own.
		// System.exit(0);
    }
}
