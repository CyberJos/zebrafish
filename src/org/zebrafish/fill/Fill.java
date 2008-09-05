/*
 * $Id$
 *
 * @(#)Fill.java 2008/6/1
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

import org.zebrafish.field.Color;
import org.zebrafish.field.Field;

/**
 * Fill area.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public interface Fill extends Field {
	/**
	 * Returns the color of fill.
	 * 
	 * @return the color of fill
	 */
	public Color getColor();

	/**
	 * Sets the color of fill.
	 * 
	 * @param color the color of fill.
	 * @throws IllegalArgumentException if the specified color is null
	 */
	public void setColor(Color color);
}
