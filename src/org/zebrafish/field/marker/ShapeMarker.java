/*
 * $Id$
 *
 * @(#)ShapeMarker.java 2008/8/27
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

/**
 * An implementation of Marker.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class ShapeMarker extends AbstractMarker {
	public static final float DEFAULT_SIZE = 10.0f;

	public static final float DEFAULT_ARROW_SIZE = 6.0f;

	public static final float DEFAULT_LINE_SIZE = 1.0f;

	private Integer dataSetIndex;

	private Float dataPoint;

	private Float size;

	private Integer priority;

	private String text;

	/**
	 * Constructs a <code>ShapeMarker</code> object.
	 * 
	 * @param type the type of this marker
	 * @param color the color of this marker
	 * @param dataPoint the floating point value that specifies on which data 
	 * 		point the marker will be drawn or the horizontal line value between 
	 * 		to the top and the bottom to interpolate
	 * @throws IllegalArgumentException if the specified color is null
	 * @see #setDataPoint(Float)
	 */
	public ShapeMarker(String type, Color color, Float dataPoint) {
		super(type, color);
		this.dataPoint = dataPoint;
	}

	/**
	 * Returns the index of the line on which to draw the marker. This is 0 for 
	 * the first data set, 1 for the second and so on.
	 *  
	 * @return the index of the line on which to draw the marker
	 */
	public Integer getDataSetIndex() {
		return dataSetIndex;
	}

	/**
	 * Sets the index of the line on which to draw the marker. This is 0 for 
	 * the first data set, 1 for the second and so on.
	 *  
	 * @param dataIndex the index of the line on which to draw the marker
	 */
	public void setDataSetIndex(Integer dataIndex) {
		this.dataSetIndex = dataIndex;
	}

	/**
	 * Returns the floating point value that specifies on which data point the 
	 * marker will be drawn. This is for all markers except a horizontal line 
	 * and can be: 0 for the first data point, 1 for the second and so on or -1 
	 * to set for all data points. Specify a fraction to interpolate a marker 
	 * between two data points.
	 * 
	 * For a horizontal line, this type of marker do not specify a data point. 
	 * Instead use 0.0 to place the line at the bottom of the chart, 1.0 to 
	 * place the line at the top of the chart and a value between to the two to 
	 * interpolate.
	 * 
	 * @return the floating point value that specifies on which data point the 
	 * 		marker will be drawn or the horizontal line value between to the top
	 * 		and the bottom to interpolate
	 */
	public Float getDataPoint() {
		return dataPoint;
	}

	/**
	 * Sets the floating point value that specifies on which data point the 
	 * marker will be drawn. This is for all markers except a horizontal line 
	 * and can be: 0 for the first data point, 1 for the second and so on or -1 
	 * to set for all data points. Specify a fraction to interpolate a marker 
	 * between two data points.
	 * 
	 * For a horizontal line, this type of marker do not specify a data point. 
	 * Instead use 0.0 to place the line at the bottom of the chart, 1.0 to 
	 * place the line at the top of the chart and a value between to the two to 
	 * interpolate.
	 * 
	 * @param dataPoint the floating point value that specifies on which data 
	 * 		point the marker will be drawn or the horizontal line value between 
	 * 		to the top and the bottom to interpolate
	 */
	public void setDataPoint(Float dataPoint) {
		this.dataPoint = dataPoint;
	}

	/**
	 * Returns the size of the marker in pixels.
	 * 
	 * @return the size of the marker in pixels
	 */
	public Float getSize() {
		return size;
	}

	/**
	 * Sets the size of the marker in pixels.
	 * 
	 * @param size the size of the marker in pixels
	 */
	public void setSize(Float size) {
		this.size = size;
	}

	/**
	 * Returns the order in which bars, lines, markers, and fills are drawn:
	 * <ul>
	 * <li>-1 specifies the marker is drawn before all other parts of the chart. 
	 * This means the marker will be hidden if another chart element is drawn 
	 * in the same place.</li>
	 * <li>0 is the default and specifies the marker is drawn on top of bars or
	 * lines and beneath other markers.</li>
	 * <li>1 specifies the marker is drawn on top of all other parts of the
	 * chart. This means it will hide another chart element if it is drawn in
	 * the same place.</li>
	 * </ul>
	 * 
	 * @return the order in which bars, lines, markers, and fills are drawn
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the order in which bars, lines, markers, and fills are drawn:
	 * <ul>
	 * <li>-1 specifies the marker is drawn before all other parts of the chart. 
	 * This means the marker will be hidden if another chart element is drawn 
	 * in the same place.</li>
	 * <li>0 is the default and specifies the marker is drawn on top of bars or
	 * lines and beneath other markers.</li>
	 * <li>1 specifies the marker is drawn on top of all other parts of the
	 * chart. This means it will hide another chart element if it is drawn in
	 * the same place.</li>
	 * </ul>
	 * 
	 * @param priority the order in which bars, lines, markers, and fills are 
	 * 		drawn
	 */
	public void setPriority(Integer priority) {
		this.priority = priority <= -1 ? -1 : priority >= 1 ? 1 : 0;
	}

	/**
	 * Returns the text. It works when the type is 't'.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text == null ? "" : text.trim().replaceAll("\\s+", "+");
	}

	/**
	 * Sets the text. It works when the type is 't'.
	 * 
	 * @param size the text
	 */
	public void setText(String text) {
		this.text = text;
	}

	private Float getFixedSize() {
		if (size != null) {
			return size;
		}
		return getType().equalsIgnoreCase("a") 
				? DEFAULT_ARROW_SIZE 
				: getType().matches("[hvV]") ? DEFAULT_LINE_SIZE : DEFAULT_SIZE;
	}

	/**
	 * Appends 
	 * ",<em>dataSetIndex</em>,<em>dataPoint</em>,<em>size</em>,<em>priority</em>" 
	 * and returns.
	 * 
	 * @see AbstractMarker#toURLString(StringBuffer)
	 */
	@Override
	protected StringBuffer toURLString(StringBuffer sb) {
		if ("t".equals(getType())) {
			sb.insert(1, getText());
		}
		return sb.append(",").append(dataSetIndex == null ? 0 : dataSetIndex)
				.append(",").append(dataPoint).append(",")
				.append(getFixedSize()).append(",")
				.append(priority == null ? "0" : priority);
	}

	/**
	 * Returns a string "acdostvVhx" which:
	 * <ul>
	 * <li>a gives you an arrow.</li>
	 * <li>c gives you a cross.</li>
	 * <li>d gives you a diamond.</li>
	 * <li>o gives you a circle.</li>
	 * <li>s gives you a square.</li>
	 * <li>t gives you text.</li>
	 * <li>v gives you a vertical line from the x-axis to the data point.</li>
	 * <li>V gives you a vertical line to the top of the chart.</li>
	 * <li>h gives you a horizontal line across the chart.</li>
	 * <li>x gives you an x shape.</li>
	 * </ul>
	 * 
	 * @see org.zebrafish.field.marker.Marker#getTypes()
	 */
	public String getTypes() {
		return "acdostvVhx";
	}
}
