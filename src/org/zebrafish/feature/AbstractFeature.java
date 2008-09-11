/*
 * $Id$
 *
 * @(#)AbstractFeature.java 2008/8/27
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

import org.zebrafish.util.Separator;

/**
 * An abstract implementation for {@link Feature}.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public abstract class AbstractFeature implements Feature {
	public StringBuffer createStringBuffer() {
		StringBuffer sb = new StringBuffer(32);
		return sb.append(Separator.AMPERSAND)
				.append(getParameterName())
				.append(Separator.EQUAL);
	}
}
