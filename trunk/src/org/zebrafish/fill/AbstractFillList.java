/*
 * $Id$
 *
 * @(#)AbstractFillList.java 2008/9/2
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

package org.zebrafish.fill;

import org.zebrafish.feature.AbstractFieldList;
import org.zebrafish.util.Separator;

/**
 * Abstract Fill List.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public abstract class AbstractFillList<T extends AbstractFill> extends AbstractFieldList<T> {
	private String type;

	private Integer angle;

	/**
	 * Constructs an abstract fill list.
	 * 
	 * @param type the type
	 * @param angle the angle
	 */
	public AbstractFillList(String type, Integer angle) {
		this.type = type;
		this.angle = angle;
	}

	/**
	 * Returns the angle of the gradient between 0 and 90.
	 * 
	 * @return the angle of the gradient between 0 and 90
	 */
	public Integer getAngle() {
		return angle;
	}

	/**
	 * Sets the angle of the gradient between 0 and 90.
	 * 
	 * @param angle the angle of the gradient between 0 and 90
	 */
	public void setAngle(Integer angle) {
		this.angle = angle <= 0 ? 0 : angle >= 90 ? 90 : angle;
	}

	/**
	 * Returns the fill type which 'bg' is for background fill or 'c' for chart 
	 * area fill.
	 * 
	 * @return the fill type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the fill type which 'bg' is for background fill or 'c' for chart 
	 * area fill.
	 * 
	 * @param type the fill type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Overrides the method in superclass to return {@link Separator#COMMA}.
	 * 
	 * @return {@link Separator#COMMA}
	 * @see org.zebrafish.feature.AbstractFieldList#getSeparator()
	 * @see Separator#COMMA
	 */
	@Override
	protected Separator getSeparator() {
		return Separator.COMMA;
	}

	@Override
	public String getParameterName() {
		return "chf";
	}
}
