/*
 * $Id$
 *
 * @(#)Feature.java 2008/5/7
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

/**
 * A feature which can be added into charts. Usually every feature presents
 * a parameter in URL query strings.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public interface Feature {
	/**
	 * Creates a <code>StringBuffer</code> object which has appended parameter
	 * information in the head of the string. For instance, it will return a 
	 * <code>StringBuffer</code> object which starts with "&chtt=" if the 
	 * parameter name of this feature is "chtt".
	 * 
	 * @return a <code>StringBuffer</code> object which has appended parameter
	 * 		information
	 */
	public StringBuffer createStringBuffer();

	/**
	 * Returns the parameter name of this feature.
	 * 
	 * @return the parameter name of this feature
	 */
	public String getParameterName();

	/**
	 * Returns the URL string of this feature.
	 * 
	 * @return the URL string of this feature
	 */
	public String toURLString();
}
