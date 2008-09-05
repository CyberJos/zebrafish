/*
 * $Id$
 *
 * @(#)BarWidth.java 2008/8/27
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

package org.zebrafish.feature;

import org.apache.commons.lang.StringUtils;
import org.zebrafish.chart.BarChart;
import org.zebrafish.util.Separator;

/**
 * Feature about bar width, space between bars in a group and space between
 * groups. This feature is just for {@link BarChart}.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class BarWidth extends AbstractFeature {
	private static final int DEFAULT_BAR_WIDTH = 24;

	private int barWidth;

	private int barSpace;

	private int groupSpace;

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

	public final String toURLString() {
		if (barWidth <= 0 && barSpace <= 0 && groupSpace <= 0) {
			return StringUtils.EMPTY;
		}

		StringBuffer sb = createStringBuffer();
		sb.append(barWidth > 0 ? barWidth : DEFAULT_BAR_WIDTH);
		if (barSpace > 0 || groupSpace > 0) {
			sb.append(Separator.COMMA);
			sb.append(barSpace > 0 ? barSpace : groupSpace / 2);

			if (groupSpace > 0) {
				sb.append(Separator.COMMA);
				sb.append(groupSpace);
			}
		}
		return sb.toString();
	}

	public String getParameterName() {
		return "chbh";
	}
}
