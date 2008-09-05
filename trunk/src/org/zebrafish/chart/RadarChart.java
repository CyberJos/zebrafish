/*
 * $Id$
 *
 * @(#)RadarChart.java 2008/5/24
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
 * Radar Chart.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1 
 */
public class RadarChart extends GoogleChart {
	private boolean spline;

	/**
	 * Constructs a <code>RadarChart</code> with the specified width and 
	 * height.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @throws IllegalArgumentException if the given width or height is illegal
	 */
	public RadarChart(int width, int height) {
		super(width, height);
	}

	@Override
	protected String getChartType() {
		return isSpline() ? "rs" : "r";
	}

	/**
	 * Returns true if points are connected with splines to form a curved line.
	 * 
	 * @return true if points are connected with splines to form a curved line
	 */
	public boolean isSpline() {
		return spline;
	}

	/**
	 * Sets if points are connected with splines to form a curved line or not.
	 * 
	 * @param spline true if points are connected with splines to form a curved 
	 * 		line
	 */
	public void setSpline(boolean spline) {
		this.spline = spline;
	}
}
