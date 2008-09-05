/*
 * $Id$
 *
 * @(#)GradientFill.java 2008/8/25
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

package org.zebrafish.fill;

import org.apache.commons.lang.StringUtils;
import org.zebrafish.field.Color;

/**
 * Gradient Fill Area.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class GradientFill extends AbstractFill {
	private Float offset;

	/**
	 * Constructs a <code>GradientFill</code> object.
	 * 
	 * @param color the color of fill
	 * @param offset the offset of fill
	 * @throws IllegalArgumentException if the specified color is null
	 */
	public GradientFill(Color color, Float offset) {
		super(color);
		setOffset(offset);
	}

	/**
	 * Returns what point the color is pure where: 0 specifies the right-most 
	 * chart position and 1 the left-most.
	 * 
	 * @return what point the color is pure
	 */
	public Float getOffset() {
		return offset;
	}

	/**
	 * Sets what point the color is pure where: 0 specifies the right-most 
	 * chart position and 1 the left-most.
	 * 
	 * @param offset what point the color is pure
	 */
	public void setOffset(Float offset) {
		this.offset = offset;
	}

	@Override
	public String toURLString() {
		return getColor() != null && getOffset() != null 
			? getColor().toURLString() + "," + getOffset()
			: StringUtils.EMPTY;
	}
}
