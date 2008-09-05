/*
 * $Id$
 *
 * @(#)Data.java 2008/5/24
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

import org.apache.commons.lang.Validate;
import org.zebrafish.util.ChartHelper;

/**
 * Data.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Data extends AbstractField {
	private float[] content;

	/**
	 * Constructs a <code>Data</code> object with the specified content. The
	 * given content is supposed to be a string which contains float numbers
	 * separated by comma, or a float array, otherwise it throws
	 * <code>IllegalArgumentException</code>.
	 * 
	 * @param content a string which contains float numbers separated by comma
	 * 		or a float array
	 * @throws IllegalArgumentException if the given content is null, or it is
	 * 		not a string nor a float array
	 */
	public Data(Object content) {
		setContent(content);
	}

	/**
	 * Returns the content.
	 * 
	 * @return the content
	 */
	public float[] getContent() {
		return this.content;
	}

	/**
	 * Sets the content. The given content is supposed to be a string which 
	 * contains float numbers separated by comma, or a float array, otherwise 
	 * it throws <code>IllegalArgumentException</code>.
	 * 
	 * @param content a string which contains float numbers separated by comma
	 * 		or a float array
	 * @throws IllegalArgumentException if the given content is null, or it is
	 * 		not a string nor a float array
	 */
	public void setContent(Object content) {
		Validate.notNull(content, "The given content must not be null.");
		if (content instanceof float[]) {
			this.content = (float[]) content;
		} else if (content instanceof String) {
			this.content = ChartHelper.convertStringToFloatArray(
					(String) content);
		} else {
			throw new IllegalArgumentException(
					"Illegal content. Should be a string or a float array.");
		}
	}
}
