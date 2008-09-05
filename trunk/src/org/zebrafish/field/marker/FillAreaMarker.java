/*
 * $Id$
 *
 * @(#)FillAreaMarker.java 2008/8/27
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

import org.zebrafish.feature.DataList;
import org.zebrafish.field.Color;

/**
 * An implementation of Marker.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class FillAreaMarker extends AbstractMarker {
	private Integer start;

	private Integer end;

	/**
	 * Constructs a <code>FillAreaMarker</code> object.
	 * 
	 * @param type the type of this marker
	 * @param color the color of this marker
	 * @param start the index of the line at which the fill starts
	 * @param end the index of the line at which the fill ends
	 * @throws IllegalArgumentException if the specified color is null
	 * @see #setStart(Integer)
	 * @see #setEnd(Integer)
	 */
	public FillAreaMarker(String type, Color color, Integer start, Integer end) {
		super(type, color);
		this.start = start;
		this.end = end;
	}

	/**
	 * Returns the index of the line at which the fill starts. This is 
	 * determined by the order in which data sets are specified with 
	 * {@link DataList}. The first data set specified has an index of zero(0), 
	 * the second 1, and so on.
	 * 
	 * @return the index of the line at which the fill starts
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * Sets the index of the line at which the fill starts. This is 
	 * determined by the order in which data sets are specified with 
	 * {@link DataList}. The first data set specified has an index of zero(0), 
	 * the second 1, and so on.
	 * 
	 * @param start the index of the line at which the fill starts
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * Returns the index of the line at which the fill ends. This is 
	 * determined by the order in which data sets are specified with 
	 * {@link DataList}. The first data set specified has an index of zero(0), 
	 * the second 1, and so on.
	 * 
	 * @return the index of the line at which the fill ends
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * Sets the index of the line at which the fill ends. This is 
	 * determined by the order in which data sets are specified with 
	 * {@link DataList}. The first data set specified has an index of zero(0), 
	 * the second 1, and so on.
	 * 
	 * @param end the index of the line at which the fill ends
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}

	/**
	 * Appends ",<em>start</em>,<em>end</em>,0" and returns.
	 * 
	 * @see AbstractMarker#toURLString(StringBuffer)
	 */
	@Override
	protected StringBuffer toURLString(StringBuffer sb) {
		return sb.append(",").append(start).append(",").append(end)
				.append(",0");
	}

	/**
	 * Returns a string "bB" which B is for a single data set or a 
	 * <code>RadarChart</code>, and b is for others.
	 * 
	 * @see org.zebrafish.field.marker.Marker#getTypes()
	 */
	public String getTypes() {
		return "bB";
	}
}
