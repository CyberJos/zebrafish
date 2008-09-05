/*
 * $Id$
 *
 * @(#)LegendPosition.java 2008/5/21
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
 * Legend's position.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class LegendPosition implements Field {
	private static final String DEFAULT_POSITION = "rlbt";

	private String position;

	/**
	 * Constructs a <code>LegendPosition</code> with the specified position.
	 * 
	 * @param position the legend's position
	 * @see #setPosition(String)
	 */
	public LegendPosition(String position) {
		setPosition(position);
	}

	/**
	 * Sets the legend's position. The legal value is:
	 * <ul>
	 * <li>b places the legend at the bottom</li>
	 * <li>t places the legend at the top</li>
	 * <li>r places the legend on the right</li>
	 * <li>l places the legend on the left</li>
	 * </ul>
	 * 
	 * If the given position is illegal then it will use the default position
	 * 'r'.
	 * 
	 * @param position the legend's position
	 */
	public void setPosition(String position) {
		this.position = ChartHelper.getLegalSingleLetter(
				DEFAULT_POSITION, position, true);
	}

	public final String toURLString() {
		return position;
	}
}
