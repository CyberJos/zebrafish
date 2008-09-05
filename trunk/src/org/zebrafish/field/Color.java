/*
 * $Id$
 *
 * @(#)Color.java 2008/5/7
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

package org.zebrafish.field;

import org.apache.commons.lang.Validate;
import org.zebrafish.util.ChartHelper;

/**
 * The <code>Color</code> class represents the value of a single color field. 
 * The color value should be at least a 6-letter string of hexadecimal values 
 * in the format RRGGBB. For example: <code>FF0000</code>, <code>00FF00</code>.
 * 
 * You can optionally specify transparency by appending a hexadecimal value 
 * between 00 and FF where 00 is completely transparent and FF completely 
 * opaque, like <code>00FF00FF</code> or <code>00FF0000</code>.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Color implements Field {
	private String value;

	/**
	 * Constructs a <code>Color</code> object with the specified color value.
	 * 
	 * @param text a 6-letter or 8-letter string of hexadecimal value
	 * @throws IllegalArgumentException if the given value is illegal
	 */
	public Color(String value) {
		setValue(value);
	}

	/**
	 * Returns the color value.
	 * 
	 * @return the color value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the color value.
	 *  
	 * @param value a 6-letter or 8-letter string of hexadecimal value
	 * @throws IllegalArgumentException if the given value is illegal 
	 */
	public void setValue(String value) {
		Validate.isTrue(ChartHelper.isColor(value), 
				"The given color value is illegal.");
		this.value = value;
	}

	/**
	 * Returns the URL string of this color. The result is the same as 
	 * {@link #getValue()}.
	 * 
	 * @return the URL string
	 * @see #getValue()
	 */
	public String toURLString() {
		return value;
	}
}
