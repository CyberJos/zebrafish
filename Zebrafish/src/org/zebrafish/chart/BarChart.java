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

/**
 * Bar Chart.
 *
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class BarChart extends GoogleChart {
	private static final int DEFAULT_BAR_WIDTH = 24;

	private boolean stacked;

	private boolean vertical;

	private int barWidth;

	private int barSpace;

	private int groupSpace;

	/**
	 * Constructor.
	 * 
	 * @param width the width
	 * @param height the height
	 */
	public BarChart(int width, int height) {
		super(width, height);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());

		if (barWidth > 0 || barSpace > 0 || groupSpace > 0) {
			sb.append("&chbh=");
			sb.append(barWidth > 0 ? barWidth : DEFAULT_BAR_WIDTH);

			if (barSpace > 0 || groupSpace > 0) {
				sb.append(",");
				sb.append(barSpace > 0 ? barSpace : groupSpace / 2);

				if (groupSpace > 0) {
					sb.append(",");
					sb.append(groupSpace);
				}
			}
		}

		return sb.toString();
	}

	@Override
	protected String getChartType() {
		return "b" + (isVertical() ? "v" : "h") + (isStacked() ? "s" : "g");
	}

	/**
	 * Returns true if multiple data sets are stacked.
	 * 
	 * @return true if multiple data sets are stacked.
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
	 * @return true if this chart is vertical.
	 */
	public boolean isVertical() {
		return vertical;
	}

	/**
	 * Sets if this chart is vertical or not.
	 * 
	 * @param vertical true if this chart is vertical.
	 */
	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	/**
	 * Returns true if this chart is horizontal.
	 * 
	 * @return true if this chart is horizontal.
	 */
	public boolean isHorizontal() {
		return !vertical;
	}

	/**
	 * Sets if this chart is horizontal or not.
	 * 
	 * @param horizontal true if this chart is horizontal.
	 */
	public void setHorizontal(boolean horizontal) {
		this.vertical = !horizontal;
	}

	/**
	 * Returns the bar width.
	 * 
	 * @return the bar width.
	 */
	public int getBarWidth() {
		return barWidth;
	}

	/**
	 * Sets the bar width. You can set 0 to use the default value which is 24.
	 * 
	 * @param barWidth the bar width.
	 */
	public void setBarWidth(int barWidth) {
		this.barWidth = barWidth;
	}

	/**
	 * Returns the space between bars in a group
	 * 
	 * @return the space between bars in a group
	 */
	public int getBarSpace() {
		return barSpace;
	}

	/**
	 * Sets the space between bars in a group. You can set 0 to use the default 
	 * value which is 4 or half the value of space between groups if the space 
	 * between groups is greater then 0.
	 * 
	 * @param barSpace the space between bars in a group.
	 */
	public void setBarSpace(int barSpace) {
		this.barSpace = barSpace;
	}

	/**
	 * Returns the space between groups.
	 * 
	 * @return the space between groups.
	 */
	public int getGroupSpace() {
		return groupSpace;
	}

	/**
	 * Sets the space between groups. You can set 0 to use the default value 
	 * which is 8.
	 * 
	 * @param groupSpace the space between groups.
	 */
	public void setGroupSpace(int groupSpace) {
		this.groupSpace = groupSpace;
	}
}
