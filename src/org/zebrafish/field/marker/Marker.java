/*
 * $Id$
 *
 * @(#)Marker.java 2008/5/21
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
import org.zebrafish.field.Field;
import org.zebrafish.util.ChartHelper;

/**
 * Marker.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public interface Marker extends Field {
	/**
	 * Returns the marker type.
	 * 
	 * Note: each implementation of <code>Marker</code> may have different kind
	 * of types.
	 * 
	 * @return the marker type
	 */
	public String getType();

	/**
	 * Sets the marker type. This method will invoke 
	 * {@link ChartHelper#getLegalSingleLetter(String, String, boolean)}
	 * to get a legal type specified in {@link #getTypes()}.
	 * 
	 * Note: each implementation of <code>Marker</code> may have different kind
	 * of types.
	 * 
	 * @param type the marker type
	 * @throws IllegalArgumentException if {@link #getTypes()} returns a empty
	 * 		string
	 * @see ChartHelper#getLegalSingleLetter(String, String, boolean)
	 */
	public void setType(String type);

	/**
	 * Returns the color of this marker.
	 * 
	 * @return the color of this marker
	 */
	public Color getColor();

	/**
	 * Sets the color of this marker.
	 * 
	 * @param color the color of this marker
	 * @throws IllegalArgumentException if the specified color is null
	 */
	public void setColor(Color color);

	/**
	 * Returns a string contains all types of this <code>Marker</code>.
	 *  
	 * @return a string contains all types of this <code>Marker</code>
	 */
	public String getTypes();
}
