/*
 * $Id$
 *
 * @(#)ChartHelper.java 2008/5/7
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

import java.text.DecimalFormat;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.math.NumberUtils;
import org.zebrafish.chart.GoogleChart;
import org.zebrafish.feature.DataList;
import org.zebrafish.feature.EncodingType;
import org.zebrafish.field.Color;
import org.zebrafish.field.Data;

public class ChartHelper {
	private static final String SIMPLE_ENCODING = 
		"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private static final String EXTENDED_ENCODING = SIMPLE_ENCODING + "-.";

	private static final int SIMPLE_ENCODING_LENGTH = SIMPLE_ENCODING.length();

	private static final int EXTENDED_ENCODING_LENGTH = EXTENDED_ENCODING.length();

	private static final Pattern PATTERN_COLOR = 
		Pattern.compile("^[0-9A-Fa-f]{6}$|^[0-9A-Fa-f]{8}$");

	private static DecimalFormat TEXT_ENCODING_FOMART = new DecimalFormat("0.#");

	/**
	 * Checks if the given width and height are legal values. See 
	 * {@link GoogleChart} for more information. 
	 * 
	 * @param width the width
	 * @param height the height
	 * @return ture if the given width and height are legal
	 */
	public static boolean checkSize(int width, int height) {
		return width > 0 && width <= 1000 && height > 0 && height <= 1000
			&& width * height <= 300000;
	}

	/**
	 * Checks if the given width and height are legal values for Map Chart.
	 * 
	 * @param width the width
	 * @param height the height
	 * @return true if the given width and height are legal
	 */
	public static boolean checkMapSize(int width, int height) {
		return width > 0 && width <= 440 && height > 0 && height <= 220;
	}

	/**
	 * Checks if the given <i>RGB</i> is a legal color value or not. See 
	 * {@link Color} for more information.
	 * 
	 * @param rgb a 6-letter or 8-letter string of hexadecimal value
	 * @return true if the given <i>RGB</i> value is legal
	 */
	public static boolean isColor(String rgb) {
		return StringUtils.isNotBlank(rgb) && PATTERN_COLOR.matcher(rgb).matches();
	}

	/**
	 * Encodes data.
	 * 
	 * @param dataList the data list needed to be encoded
	 * @return an encoded string
	 */
	public static String encodeData(DataList dataList) {
		StringBuffer sb = new StringBuffer(128);
		StringBuffer sbTmp = new StringBuffer(32);
		EncodingType type = dataList.getType();

		for (Data data : dataList) {
			float[] content = data.getContent();
			if (content == null || content.length == 0) {
				sb.append(type.getMissingValue()).append(type.getSymbol());
				continue;
			}

			if (dataList.isAutoScale()) {
				content = autoDataScale(content, 0, type.getMax());
			}

			sbTmp.setLength(0);
			try {
				for (float f : content) {
					switch (type) {
						case TEXT:
							sbTmp.append(TEXT_ENCODING_FOMART.format(f)).append(",");
							break;
						case SIMPLE:
							sbTmp.append(SIMPLE_ENCODING.charAt(Math.round(f) % SIMPLE_ENCODING_LENGTH));
							break;
						case EXTENDED:
							int k = Math.round(f);
							sbTmp.append(EXTENDED_ENCODING.charAt(k / EXTENDED_ENCODING_LENGTH));
							sbTmp.append(EXTENDED_ENCODING.charAt(k % EXTENDED_ENCODING_LENGTH));
					}
				}

				if (type == EncodingType.TEXT) {
					sbTmp.deleteCharAt(sbTmp.length() - 1);
				}
				sb.append(sbTmp).append(type.getSymbol());
			} catch (Exception e) {
				sb.append(type.getMissingValue()).append(type.getSymbol());
			}
		}

		return sb.toString();
	}

	/**
	 * Scales the given array automatically.
	 * 
	 * @param array the array needed to be scaled
	 * @param start the start of the range
	 * @param end the end of the range
	 * @return an scaled array
	 */
	public static float[] autoDataScale(float[] array, int start, int end) {
		if (ArrayUtils.isEmpty(array)) {
			return array;
		}

		float max = NumberUtils.max(array);
		float min = NumberUtils.min(array);
		int offset = 0;
		if (max > end || min < start) {
			// Sets an offset
			if (min < start) {
				offset = Math.abs((int) Math.floor(min));
			}

			float scale = (float) ((end - start) / (Math.ceil(max) - (min >= start ? start : Math.floor(min))));
			float[] newArray = new float[array.length]; 
			for (int i = 0; i < array.length; i++) {
				newArray[i] = (array[i] + offset) * (scale >= 1 ? 1 : scale);
			}
			return newArray;
		}
		return array;
	}

	/**
	 * Converts the given comma-separated <code>content</code> to a float array.
	 * 
	 * @param content a comma-separated <code>String</code>  
	 * @return a float array
	 */
	public static float[] convertStringToFloatArray(String content) {
		String[] contents = content.split(",");
		if (!ArrayUtils.isEmpty(contents)) {
			// creates a float array with the same length, and tries to parse all elements
			float[] array = new float[contents.length];
			int legalValueNumber = 0;
			for (int i = 0; i < contents.length; i++) {
				try {
					array[legalValueNumber] = Float.parseFloat(contents[i]);
					legalValueNumber++;
				} catch (Exception e) {
				}
			}

			// if we can't parse all of them, then makes a new array with the correct size 
			if (legalValueNumber < array.length && legalValueNumber > 0) {
				float[] newArray = new float[legalValueNumber];
				System.arraycopy(array, 0, newArray, 0, legalValueNumber);
				return newArray;
			}
			return array;
		}
		return null;
	}

	/**
	 * Returns one legal letter specified in the given pattern. If the given 
	 * letter is not null, one character and contained in the given pattern then 
	 * it returns the letter. Otherwise it returns a empty string if allowEmpty
	 * is true or returns the first character of the given pattern instead if
	 * allowEmpty is false.
	 * 
	 * @param pattern the pattern of all legal values
	 * @param letter the letter which needs to be checked
	 * @param allowEmpty allows to return a empty string if true or return the
	 * 		first character of the given pattern if false when not found
	 * @return one legal letter specified in the given pattern
	 * @throws IllegalArgumentException if the given pattern is empty
	 */
	public static String getLegalSingleLetter(String pattern, String letter, 
			boolean allowEmpty) {
		Validate.notEmpty(pattern, "The given pattern must not be empty.");

		if (StringUtils.isEmpty(letter) || letter.length() != 1) {
			letter = " ";
		}

		return pattern.contains(letter) 
				? letter 
				: allowEmpty 
					? StringUtils.EMPTY 
					: StringUtils.EMPTY + pattern.charAt(0);
	}
}
