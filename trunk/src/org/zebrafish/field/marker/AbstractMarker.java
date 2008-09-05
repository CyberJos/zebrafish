/*
 * $Id$
 *
 * @(#)AbstractMarker.java 2008/8/27
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

package org.zebrafish.field.marker;

import static org.apache.commons.lang.StringUtils.*;

import org.apache.commons.lang.Validate;
import org.zebrafish.field.Color;
import org.zebrafish.util.ChartHelper;

/**
 * An implementation of Marker.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public abstract class AbstractMarker implements Marker {
	private String type;

	private Color color;

	/**
	 * Constructs a <code>Maker</code> implementation with the specified type
	 * and color.
	 * 
	 * @param type the type of this marker
	 * @param color the color of this marker
	 * @throws IllegalArgumentException if the specified color is null
	 * @see #setType(String)
	 */
	public AbstractMarker(String type, Color color) {
		setType(type);
		setColor(color);
	}

	/**
	 * Uses the specified <code>StringBuffer</code> to append the others
	 * values into it. The specified <code>StringBuffer</code> should contains
	 * "<em>type</em>,<em>color_value</em>" string.
	 * 
	 * It is supposed to be implemented but invoked by other methods.
	 * 
	 * @param sb <code>StringBuffer</code> object which contains 
	 * 		"<em>type</em>,<em>color_value</em>" string
	 * @return the <code>StringBuffer</code> object which contains the URL
	 * 		string of this field
	 * @see #toURLString()
	 */
	protected abstract StringBuffer toURLString(StringBuffer sb);

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = ChartHelper.getLegalSingleLetter(getTypes(), type, false);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		Validate.notNull(color, "The specified must not be null.");
		this.color = color;
	}

	/**
	 * Returns the URL string of this field. If color is null, it will return
	 * an empty string. Or it will create a new <code>StringBuffer</code>
	 * object which contains {@link #getType()}, "," and 
	 * {@link #getColor()#toURLString()}, then invoke 
	 * {@link #toURLString(StringBuffer)} and return 
	 * <code>StringBuffer.toString()</code>.
	 * 
	 * <pre>
	 * StringBuffer sb = new StringBuffer(16);
	 * sb.append(getType()).append(",").append(getColor().toURLString());
	 * return toURLString(sb).toString();
	 * </pre>  
	 * 
	 * @return the URL string of this field
	 * @see org.zebrafish.field.Field#toURLString()
	 */
	public final String toURLString() {
		if (color == null) {
			return EMPTY;
		}

		StringBuffer sb = new StringBuffer(16);
		sb.append(getType()).append(",").append(getColor().toURLString());
		return toURLString(sb).toString();
	}
}
