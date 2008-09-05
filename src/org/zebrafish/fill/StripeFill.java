/*
 * $Id$
 *
 * @(#)StripeFill.java 2008/8/25
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
 * Stripe Fill Area.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class StripeFill extends AbstractFill {
	private Float width;

	/**
	 * Constructs a <code>StripeFill</code> object.
	 * 
	 * @param color the color of fill
	 * @param width the width of fill
	 * @throws IllegalArgumentException if the specified color is null
	 */
	public StripeFill(Color color, Float width) {
		super(color);
		this.width = width;
	}

	/**
	 * Returns width between 0 and 1 where 1 is the full width of the chart. 
	 * Stripes are repeated until the chart is filled.
	 * 
	 * @return the width
	 */
	public Float getWidth() {
		return width;
	}

	/**
	 * Sets width between 0 and 1 where 1 is the full width of the chart. 
	 * Stripes are repeated until the chart is filled.
	 * 
	 * @param width the width
	 */
	public void setWidth(Float width) {
		this.width = width;
	}

	@Override
	public String toURLString() {
		return getColor() != null && getWidth() != null 
			? getColor().toURLString() + "," + getWidth()
			: StringUtils.EMPTY;
	}
}
