/*
 * $Id$
 *
 * @(#)Seperator.java 2008/6/9
 *  
 * Copyright (c) 2008 Joseph S. Kuo, Max Chu
 * All Rights Reserved.
 *
 * --LICENSE NOTICE--
 * This file is part of Zebrafish, which is a Java wrapper for Google
 * Chart API.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see 
 * <http://www.gnu.org/licenses/>.
 * --LICENSE NOTICE--
 */

package org.zebrafish.util;

/**
 * A separator enumeration.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public enum Separator {
	/** Separator: ',' */
	COMMA(","),

	/** Separator: '|' */
	BAR("|"),

	/** Separator: '.' */
	DOT("."),

	/** Separator: ':' */
	COLON(":"),

	/** Separator: ';' */
	SEMICOLON(";"),

	/** Separator: '&' */
	AMPERSAND("&"),

	/** Separator: '=' */
	EQUAL("="),

	/** Separator: '$' */
	DOLLAR("$");

	private String symbol;

	private Separator(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Returns a string which contains the symbol.
	 * 
	 * @return a string which contains the symbol
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return symbol;
	}

	/**
	 * Returns the symbol character.
	 * 
	 * @return the symbol character
	 */
	public char getSymbol() {
		return symbol.charAt(0);
	}
}
