/*
 * $Id$
 *
 * @(#)RangeMarker.java 2008/8/27
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

import org.zebrafish.field.Color;

/**
 * An implementation of Marker.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class RangeMarker extends AbstractMarker {
	private Float start;

	private Float end;

	/**
	 * Constructs a <code>RangeMarker</code> object.
	 * 
	 * @param type the type of this marker
	 * @param color the color of this marker
	 * @param start the position on the axis at which the range starts
	 * @param end the position on the axis at which the range ends
	 * @throws IllegalArgumentException if the specified color is null
	 * @see #setStart(Float)
	 * @see #setEnd(Float)
	 */
	public RangeMarker(String type, Color color, Float start, Float end) {
		super(type, color);
		this.start = start;
		this.end = end;
	}

	/**
	 * Returns the position on the axis at which the range starts. If this
	 * marker is horizontal then it returns the position on the y-axis where 
	 * 0.00 is the bottom and 1.00 is the top. Otherwise, if this marker is 
	 * vertical then it returns the position on the x-axis where 0.00 is the 
	 * left and 1.00 is the right.
	 * 
	 * @return the position on the axis at which the range starts
	 */
	public Float getStart() {
		return start;
	}

	/**
	 * Sets the position on the axis at which the range starts. If this
	 * marker is horizontal then it sets the position on the y-axis where 
	 * 0.00 is the bottom and 1.00 is the top. Otherwise, if this marker is 
	 * vertical then it sets the position on the x-axis where 0.00 is the 
	 * left and 1.00 is the right.
	 * 
	 * @param start the position on the axis at which the range starts
	 */
	public void setStart(Float start) {
		this.start = start;
	}

	/**
	 * Returns the position on the axis at which the range ends. If this
	 * marker is horizontal then it returns the position on the y-axis where 
	 * 0.00 is the bottom and 1.00 is the top. Otherwise, if this marker is 
	 * vertical then it returns the position on the x-axis where 0.00 is the 
	 * left and 1.00 is the right.
	 * 
	 * @return the position on the axis at which the range ends
	 */
	public Float getEnd() {
		return end;
	}

	/**
	 * Sets the position on the axis at which the range ends. If this
	 * marker is horizontal then it sets the position on the y-axis where 
	 * 0.00 is the bottom and 1.00 is the top. Otherwise, if this marker is 
	 * vertical then it sets the position on the x-axis where 0.00 is the 
	 * left and 1.00 is the right.
	 * 
	 * @param end the position on the axis at which the range ends
	 */
	public void setEnd(Float end) {
		this.end = end;
	}

	/**
	 * Returns a string "rR" which r is for a horizontal range and R for a 
	 * vertical range.
	 *  
	 * @see org.zebrafish.field.marker.Marker#getTypes()
	 */
	public String getTypes() {
		return "rR";
	}

	/**
	 * Appends ",0,<em>start</em>,<em>end</em>" and returns.
	 * 
	 * @see AbstractMarker#toURLString(StringBuffer)
	 */
	@Override
	protected StringBuffer toURLString(StringBuffer sb) {
		return sb.append(",0,").append(start).append(",").append(end);
	}
}
