/*
 * $Id$
 *
 * @(#)SimpleAxis.java 2008/9/5
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
 * An simple axis.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class SimpleAxis extends Axis {
	/** Default step: 1. */
	public static final int DEFAULT_STEP = 1;

	private Integer step;

	/**
	 * Constructs a <code>SimpleAxis</code> object with the specified values.
	 * 
	 * @param type
	 * @param start
	 * @param end
	 */
	public SimpleAxis(String type, Integer start, Integer end) {
		super(type);
		setStart(start);
		setEnd(end);
	}

	/**
	 * Returns the step value.
	 * 
	 * @return the step value
	 */
	public Integer getStep() {
		return step;
	}

	/**
	 * Sets the step value.
	 * 
	 * @param step the step value
	 */
	public void setStep(Integer step) {
		this.step = step;
	}

	@Override
	public String getLabels() {
		int start = getStart();
		int end = getEnd();
		int realStep = step == null ? DEFAULT_STEP : step;

		StringBuffer sb = new StringBuffer(16);
		int plus = end - start > 0 ? 1 : -1;
		if (plus * realStep <= 0) {
			return sb.append(start).append(Separator.COMMA)
					.append(end).toString();
		}

		for (int i = start; i * plus <= end * plus; i = i + realStep) {
			sb.append(Separator.COMMA).append(i);
		}
		return sb.length() > 0 ? sb.deleteCharAt(0).toString() : "";
	}
}
