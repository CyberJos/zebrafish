/*
 * $Id$
 *
 * @(#)ScatterChart.java 2008/5/24
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

/**
 * Scatter Plot.
 * 
 * Scatter plots use multiple data sets differently than other chart types. You
 * can only show one data set in a scatter plot. Though you use three data sets
 * to specify each point's x position, y position, and optionally size.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class ScatterPlot extends GoogleChart {
	/**
	 * Constructs a <code>ScatterPlot</code> with the specified width and 
	 * height.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @throws IllegalArgumentException if the given width or height is illegal
	 */
	public ScatterPlot(int width, int height) {
		super(width, height);
	}

	@Override
	protected String getChartType() {
		return "s";
	}
}
