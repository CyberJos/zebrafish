/*
 * $Id$
 *
 * @(#)LineStyle.java 2008/5/24
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

/**
 * Line style.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class LineStyle implements Field {
	private Integer thickness;

	private Integer lineSegment;

	private Integer blankSegment;

	/**
	 * Constructs a <code>LinesStyle</code> object with the specified values.
	 * 
	 * @param thickness the line thickness
	 * @param lineSegment the length of line segment
	 * @param blankSegment the length of blank segment
	 */
	public LineStyle(Integer thickness, Integer lineSegment, 
			Integer blankSegment) {
		this.thickness = thickness;
		this.lineSegment = lineSegment;
		this.blankSegment = blankSegment;
	}

	/**
	 * Returns the line thickness.
	 * 
	 * @return the line thickness
	 */
	public Integer getThickness() {
		return thickness;
	}

	/**
	 * Sets the line thickness.
	 * 
	 * @param thickness the line thickness
	 */
	public void setThickness(Integer thickness) {
		this.thickness = thickness;
	}

	/**
	 * Returns the length of line segment.
	 * 
	 * @return the length of line segment
	 */
	public Integer getLineSegment() {
		return lineSegment;
	}

	/**
	 * Sets the length of line segment.
	 * 
	 * @param lineSegment the length of line segment
	 */
	public void setLineSegment(Integer lineSegment) {
		this.lineSegment = lineSegment;
	}

	/**
	 * Returns the length of blank segment.
	 * 
	 * @return the length of blank segment
	 */
	public Integer getBlankSegment() {
		return blankSegment;
	}

	/**
	 * Sets the length of blank segment.
	 * 
	 * @param blankSegment the length of blank segment
	 */
	public void setBlankSegment(Integer blankSegment) {
		this.blankSegment = blankSegment;
	}

	public final String toURLString() {
		return getThickness() + "," + getLineSegment() + "," + getBlankSegment();
	}
}
