/*
 * $Id$
 *
 * @(#)GoogleChart.java 2008/5/6
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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.zebrafish.feature.Feature;
import org.zebrafish.util.ChartHelper;
 
/**
 * The <code>GoogleChart</code> class is the superclass of all Google chart 
 * classes.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision: 13 $, $Date$
 * @since 0.1
 */
public abstract class GoogleChart {
	/** The URL of Google Chart API. */
	public static final String API_URL = "http://chart.apis.google.com/chart?cht=";

	private int width;

	private int height;

	private Map<String, Feature> featureMap;

	/**
	 * Constructs a chart with the specified width and height.
	 * 
	 * Notice: the chart size is limited. First, its <i>width</i> and 
	 * <i>height</i> should be greater then zero. Then the maximum height or 
	 * width is 1000 pixels, they should be less then or equals to 1000. 
	 * However the largest possible area for all charts except maps is 300,000 
	 * pixels, that is, examples of maximum sizes are 1000x300, 300x1000, 
	 * 600x500 and 500x600.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @throws IllegalArgumentException if the given width or height is illegal
	 */
	public GoogleChart(int width, int height) {
		Validate.isTrue(ChartHelper.checkSize(width, height), "Illegal size.");
		this.width = width;
		this.height = height;
	}

	/**
	 * Adds a feature into this Google Chart. Each kind of features can only be 
	 * added once, that is, if you add two {@link Title} objects then only the
	 * latest one will work and the previous one will be discarded.
	 *  
	 * @param feature the feature to be added
	 * @throws IllegalArgumentException if the given feature is null
	 */
	public void addFeature(Feature feature) {
		Validate.notNull(feature, "The given feature must not be null.");
		if (featureMap == null) {
			featureMap = new HashMap<String, Feature>();
		}
		featureMap.put(feature.getParameterName(), feature);
	}

	/**
	 * Removes a feature from the Google Chart.
	 *  
	 * @param feature the feature to be removed
	 * @throws IllegalArgumentException if the given feature is null
	 */
	public void removeFeature(Feature feature) {
		Validate.notNull(feature, "The given feature must not be null.");
		if (featureMap != null) {
			Feature oldFeature = featureMap.get(feature.getParameterName());
			if (feature.equals(oldFeature)) {
				featureMap.remove(feature.getParameterName());
			}
		}
	}

	/**
	 * Removes a feature by the specified parameter name from this Google Chart.
	 *  
	 * @param parameterName the parameter name to be removed
	 * @throws IllegalArgumentException if the given feature class is null
	 */
	public void removeFeature(String parameterName) {
		Validate.notNull(parameterName, "The given parameter name must not be null.");
		if (featureMap != null) {
			featureMap.remove(parameterName);
		}
	}

    /**
     * Returns a string representation of the object. The string contains a URL
     * indicated to Google Chart API.  
     *
	 * @return a URL string which presents this chart
     */
	public String toURLString() {
		StringBuffer sb = new StringBuffer(256);
		sb.append(API_URL).append(getChartType())
			.append("&chs=").append(width).append("x").append(height);

		if (featureMap != null && featureMap.size() != 0) {
			for (Feature feature : featureMap.values()) {
				sb.append(feature.toURLString());
			}
		}
		return sb.toString();
	}

	/**
	 * Returns the type of this chart. It is used in URL string.
	 * 
	 * @return the type of this chart
	 */
	protected abstract String getChartType();
}
