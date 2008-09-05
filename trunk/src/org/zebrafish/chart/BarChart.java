/*
 * $Id$
 *
 * @(#)BarChart.java 2008/8/26
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

import org.zebrafish.feature.BarWidth;

/**
 * Bar Chart.
 *
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class BarChart extends GoogleChart {
	private boolean stacked;

	private boolean vertical;

	/**
	 * Constructs a <code>BarChart</code> with the specified width and 
	 * height.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 */
	public BarChart(int width, int height) {
		super(width, height);
	}

	@Override
	protected String getChartType() {
		return "b" + (isVertical() ? "v" : "h") + (isStacked() ? "s" : "g");
	}

	/**
	 * Removes the specified {@link BarWidth} from this chart.
	 *  
	 * @param barWidth the <code>BarWidth</code> object to be removed
	 * @see BarWidth
	 * @throws IllegalArgumentException if the given barWidth is null
	 */
	public void removeBarWidth(BarWidth barWidth) {
		removeFeature(barWidth);
	}

	/**
	 * Sets the given {@link BarWidth} into this chart.
	 *  
	 * @param barWidth the <code>BarWidth</code> object to be set
	 * @see BarWidth
	 * @throws IllegalArgumentException if the given barWidth is null
	 */
	public void setBarWidth(BarWidth barWidth) {
		addFeature(barWidth);
	}

	/**
	 * Returns true if multiple data sets are stacked.
	 * 
	 * @return true if multiple data sets are stacked
	 */
	public boolean isStacked() {
		return stacked;
	}

	/**
	 * Sets if multiple data sets are stacked or not.
	 * 
	 * @param stacked true if multiple data sets are stacked
	 */
	public void setStacked(boolean stacked) {
		this.stacked = stacked;
	}

	/**
	 * Returns true if this chart is vertical.
	 * 
	 * @return true if this chart is vertical
	 */
	public boolean isVertical() {
		return vertical;
	}

	/**
	 * Sets if this chart is vertical or not.
	 * 
	 * @param vertical true if this chart is vertical
	 */
	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	/**
	 * Returns true if this chart is horizontal.
	 * 
	 * @return true if this chart is horizontal
	 */
	public boolean isHorizontal() {
		return !vertical;
	}

	/**
	 * Sets if this chart is horizontal or not.
	 * 
	 * @param horizontal true if this chart is horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.vertical = !horizontal;
	}
}
