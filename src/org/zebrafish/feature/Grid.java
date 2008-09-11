/*
 * $Id$
 *
 * @(#)Grid.java 2008/8/27
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

/**
 * Grid.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Grid extends AbstractFeature {
	public static final int DEFAULT_LINE_LENGTH = 5;

	public static final int DEFAULT_BLANK_LENGTH = 5;

	private Integer stepX;

	private Integer stepY;

	private Integer lineSegment;

	private Integer blankSegment;

	/**
	 * Constructs a <code>Grid</code> object with the specified x and y.
	 * 
	 * @param stepX
	 * @param stepY
	 */
	public Grid(Integer stepX, Integer stepY) {
		setStepX(stepX);
		setStepY(stepY);
	}

	public Integer getStepX() {
		return stepX;
	}

	public void setStepX(Integer stepX) {
		this.stepX = stepX;
	}

	public Integer getStepY() {
		return stepY;
	}

	public void setStepY(Integer stepY) {
		this.stepY = stepY;
	}

	public Integer getLineSegment() {
		return lineSegment;
	}

	public void setLineSegment(Integer lineSegment) {
		this.lineSegment = lineSegment;
	}

	public Integer getBlankSegment() {
		return blankSegment;
	}

	public void setBlankSegment(Integer blankSegment) {
		this.blankSegment = blankSegment;
	}

	public final String toURLString() {
		StringBuffer sb = createStringBuffer();
		sb.append(stepX).append(",").append(stepY);

		if (lineSegment != null || blankSegment != null) {
			sb.append(",").append(lineSegment != null ? lineSegment : DEFAULT_LINE_LENGTH);
			sb.append(",").append(blankSegment != null ? blankSegment : DEFAULT_BLANK_LENGTH);
		}

		return sb.toString();
	}

	public String getParameterName() {
		return "chg";
	}
}
