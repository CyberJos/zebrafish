/*
 * $Id$
 *
 * @(#)EncodingType.java 2008/9/3
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

package org.zebrafish.feature;

import org.apache.commons.lang.StringUtils;
import org.zebrafish.util.Separator;

/**
 * A encoding type enumeration.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public enum EncodingType {
	/** 
	 * Encoding: Text encoding uses a string of positive floating point numbers
	 * from zero to one hundred.
	 */
	TEXT("t", "-1", 100, Separator.BAR),

	/** 
	 * Encoding: Simple encoding uses the alphanumeric characters (A to Z, a to
	 * z, and 0 to 9) where A represents 0, B represents 1, and so on up to 9
	 * which represents 61, to provide a resolution of 62 different values.
	 */
	SIMPLE("s", "_", 61, Separator.COMMA),

	/** 
	 * Encoding: Extended encodinguses pairs of alphanumeric characters (plus 
	 * a few others that are discussed later) where AA represents 0, AB 
	 * represents 1, and so on up to two periods (..) which represent 4095 to 
	 * provide a resolution of 4,096 different values.
	 */
	EXTENDED("e", "__", 4095, Separator.COMMA);

	private String type;

	private String missingValue;

	private int max;

	private Separator separator;

	private EncodingType(String type, String mValue, int max, Separator sep) {
		this.type = type;
		this.missingValue = mValue;
		this.max = max;
		this.separator = sep;
	}

	/**
	 * Parses the specified type and returns the related 
	 * a <code>EncodingType</code> object. It returns <code>null</code> if not
	 * found.
	 * 
	 * The legal values are:
	 * <ul>
	 * <li>t and text are for text encoding.</li>
	 * <li>s and simple are for simple encoding.</li>
	 * <li>e and extended are for extended encoding.</li>
	 * </ul>
	 * 
	 * @param type the type to be parsed
	 * @return the related <code>EncodingType</code> or null if not found
	 */
	public static EncodingType parseType(String type) {
		if (StringUtils.isEmpty(type)) {
			return null;
		}

		if (type.length() == 1) {
			for (EncodingType encodingType : values()) {
				if (encodingType.getType().equalsIgnoreCase(type)) {
					return encodingType;
				}
			}
			return null;
		}

		try {
			return valueOf(type.toUpperCase());
		} catch (Exception ex) {
		}
		return null;
	}

	/**
	 * Returns the short name of this encoding type which:
	 * <ul>
	 * <li>t is for text encoding.</li>
	 * <li>s is for simple encoding.</li>
	 * <li>e is for extended encoding.</li>
	 * </ul>
	 * 
	 * @return the short name of this encoding type 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the missing value of this encoding type. {@link #SIMPLE} returns
	 * "_", {@link #EXTENDED} returns "__", and {@link #TEXT} returns "-1".
	 * 
	 * @return the missing value of this encoding type
	 */
	public String getMissingValue() {
		return missingValue;
	}

	/**
	 * Returns the maximum of how many different values can present. 
	 * {@link #SIMPLE} returns 61, {@link #TEXT} returns 100, and 
	 * {@link #EXTENDED} returns 4095. 
	 * .
	 * 
	 * @return the maximum of how many different values can present
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Returns the separator symbol of this encoding type. {@link #SIMPLE} and
	 * {@link #EXTENDED} return ",", and {@link #TEXT} returns "|".
	 * 
	 * @return the separator symbol of this encoding type
	 */
	public String getSymbol() {
		return separator.toString();
	}

	/**
	 * Returns the separator of this encoding type. {@link #SIMPLE} and
	 * {@link #EXTENDED} return {@link Separator#COMMA}, and {@link #TEXT} 
	 * returns {@link Separator#BAR}.
	 * 
	 * @return the separator symbol of this encoding type
	 */
	public Separator getSeparator() {
		return separator;
	}
}

