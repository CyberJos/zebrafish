/*
 * $Id$
 *
 * @(#)Map.java 2008/10/3
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

package org.zebrafish.chart;

import org.apache.commons.lang.Validate;
import org.zebrafish.util.ChartHelper;

/**
 * Map.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Map extends GoogleChart {
	/**
	 * Constructs a <code>VennDiagram</code> with the specified width and 
	 * height.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @throws IllegalArgumentException if the given width or height is illegal
	 */
	public Map(int width, int height) {
		super(width, height);
		Validate.isTrue(ChartHelper.checkMapSize(width, height), "Illegal map size.");
	}

	@Override
	protected String getChartType() {
		return "t";
	}
}
