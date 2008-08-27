/*
 * $Id$
 *
 * @(#)PieChart.java 2008/5/30
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
 * Pie Chart.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class PieChart extends GoogleChart {
	private boolean threeD;

	/**
	 * Constructor.
	 * 
	 * @param width the width
	 * @param height the height
	 */
	public PieChart(int width, int height) {
		super(width, height);
	}

	@Override
	protected String getChartType() {
		return isThreeD() ? "p3" : "p";
	}

	/**
	 * Returns true if this object is a three dimensional pie chart.
	 * 
	 * @return true if this object is a three dimensional pie chart.
	 */
	public boolean isThreeD() {
		return threeD;
	}

	/**
	 * Sets if this chart is a three dimensional pie chart or not.
	 * 
	 * @param threeD true if this chart is a three dimensional pie chart.
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}
}
