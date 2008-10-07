/*
 * $Id$
 *
 * @(#)Axis.java 2008/9/4
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

import org.zebrafish.util.ChartHelper;

/**
 * An axis.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Axis implements Field {
	public static final int DEFAULT_SIZE = 11; 

	private static final String DEFAULT_TYPES = "xyrt";

	private Color color;

	private int fontSize;

	private Integer alignment;

	private String type;

	private String labels;

	private String positions;

	private Integer start;

	private Integer end;

	/**
	 * Constructs a <code>Axis</code> object with the specified type.
	 * 
	 * @param type the type, defaults to 'x'
	 * @see #setType(String)
	 */
	public Axis(String type) {
		setType(type);
	}

	/**
	 * Returns the type of this axis. Available axes are:
	 * <ul>
	 * <li>x = bottom x-axis</li>
	 * <li>t = top x-axis</li>
	 * <li>y = left y-axis</li>
	 * <li>r = right y-axis</li>
	 * </ul>
	 * 
 	 * @return the type of this axis
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of this axis. Available axes are:
	 * <ul>
	 * <li>x = bottom x-axis</li>
	 * <li>t = top x-axis</li>
	 * <li>y = left y-axis</li>
	 * <li>r = right y-axis</li>
	 * </ul>
	 *
	 * Defaults to 'x' if the given type is illegal.
	 * 
 	 * @param type the type of this axis
	 */
	public void setType(String type) {
		this.type = ChartHelper.getLegalSingleLetter(DEFAULT_TYPES, type, true);
	}

	/**
	 * Returns all labels separated by the comma(,).
	 *  
	 * @return all labels separated by the comma(,)
	 */
	public String getLabels() {
		return labels;
	}

	/**
	 * Sets labels which is separated by the comma(,). The first label is 
	 * placed at the start, the last at the end, others are uniformly spaced in
	 * between. 
	 *  
	 * @param labels all labels separated by the comma(,)
	 */
	public void setLabels(String labels) {
		this.labels = labels == null ? null : labels.replaceAll("\\s+", "+");
	}

	/**
	 * Returns all label positions separated by the comma(,). The label 
	 * positions use floating point numbers for position values.
	 * 
	 * @return all label positions separated by the comma(,)
	 */
	public String getPositions() {
		return positions;
	}

	/**
	 * Sets all label positions separated by the comma(,). The label 
	 * positions use floating point numbers for position values.
	 * 
	 * @param positions all label positions separated by the comma(,)
	 */
	public void setPositions(String positions) {
		this.positions = positions;
	}

	/**
	 * Returns the start of range.
	 * 
	 * @return the start of range
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * Sets the start of range.
	 * 
	 * @param start the start of range
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * Returns the end of range.
	 * 
	 * @return the end of range
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * Sets the end of range.
	 * 
	 * @param end the end of range
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}

	/**
	 * Returns the color of axis.
	 * 
	 * @return the color of axis
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of axis.
	 * 
	 * @param color the color of axis
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Returns the font size of axis.
	 * 
	 * @return the font size of axis
	 */
	public int getFontSize() {
		return fontSize <= 0 ? DEFAULT_SIZE : fontSize;
	}

	/**
	 * Sets the font size of axis.
	 * 
	 * @param fontSize the font size of axis
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * Returns the alignment of axis.
	 * 
	 * @return the alignment of axis
	 */
	public Integer getAlignment() {
		return alignment;
	}

	/**
	 * Sets the alignment of axis.
	 * 
	 * @param alignment the alignment of axis
	 */
	public void setAlignment(Integer alignment) {
		this.alignment = alignment;
	}

	public final String toURLString() {
		return null;
	}
}
