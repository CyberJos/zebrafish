/*
 * $Id$
 *
 * @(#)LineChart.java 2008/5/8
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
 * Line Chart.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class LineChart extends GoogleChart {
	private boolean pair;

	/**
	 * Constructor.
	 * 
	 * @param width the width
	 * @param height the height
	 */
	public LineChart(int width, int height) {
		super(width, height);
	}

	@Override
	protected String getChartType() {
		return isPair() ? "lxy" : "lc";
	}

	/**
	 * Returns true if this chart requires a pair of data sets for each line.
	 * 
	 * @return true if this chart requires a pair of data sets for each line.
	 */
	public boolean isPair() {
		return pair;
	}

	/**
	 * Sets if this chart requires a pair of data sets for each line or not.
	 * 
	 * @param pair true if this chart requires a pair of data sets for each line.
	 */
	public void setPair(boolean pair) {
		this.pair = pair;
	}
}
