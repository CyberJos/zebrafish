/*
 * $Id$
 *
 * @(#)SolidFill.java 2008/6/2
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

import static org.apache.commons.lang.StringUtils.EMPTY;

import org.zebrafish.field.Color;

/**
 * Solid Fill area.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class SolidFill extends AbstractFill {
	private String type;

	/**
	 * Constructs a <code>SolidFill</code> object.
	 * 
	 * @param type the fill type
	 * @param color the color of fill
	 * @throws IllegalArgumentException if the specified color is null
	 */
	public SolidFill(String type, Color color) {
		super(color);
		this.type = type;
	}

	/**
	 * Returns the fill type which 'bg' is for background fill, 'c' for chart 
	 * area fill or 'a' to apply transparency to the whole chart.
	 * 
	 * @return the fill type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the fill type which 'bg' is for background fill, 'c' for chart 
	 * area fill or 'a' to apply transparency to the whole chart.
	 * 
	 * @param type the fill type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public final String toURLString() {
		if (getColor() == null) {
			return EMPTY;
		}
		return getType() + ",s," + getColor().toURLString();
	}
}
