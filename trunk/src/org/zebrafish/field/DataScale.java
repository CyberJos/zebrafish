/*
 * $Id$
 *
 * @(#)DataScale.java 2008/5/31
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

package org.zebrafish.field;

import org.zebrafish.util.Separator;

/**
 * DataScale.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class DataScale implements Field {
	private Integer min;

	private Integer max = new Integer(100); // default

	/**
	 * Constructs a <code>DataScale</code> object with the specified minimum
	 * value and the default maximum value 100.
	 *  
	 * @param min the minimum value
	 */
	public DataScale(Integer min) {
		setMin(min);
	}

	/**
	 * Constructs a <code>DataScale</code> object with the specified minimum
	 * and maximum values.
	 *  
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public DataScale(Integer min, Integer max) {
		setMin(min);
		setMax(max);
	}

	/**
	 * Returns the minimum value.
	 * 
	 * @return the minimum value
	 */
	public Integer getMin() {
		return min;
	}

	/**
	 * Sets the minimum value.
	 * 
	 * @param min the minimum value
	 */
	public void setMin(Integer min) {
		this.min = min;
	}

	/**
	 * Returns the maximum value.
	 * 
	 * @return the maximum value
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 * Sets the maximum value.
	 * 
	 * @param max the maximum value
	 */
	public void setMax(Integer max) {
		this.max = max;
	}

	public String toURLString() {
		return min + Separator.COMMA.toString() + max;
	}
}
