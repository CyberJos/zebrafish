/*
 * $Id$
 *
 * @(#)StripeFillList.java Sep 2, 2008
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

import org.zebrafish.util.Separator;

/**
 * Stripe Fill List.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class StripeFillList extends AbstractFillList<StripeFill> {
	/**
	 * Constructs a <code>StripeFillList</code> object.
	 * 
	 * @param type the fill type
	 * @param angle the angle
	 */
	public StripeFillList(String type, Integer angle) {
		super(type, angle);
	}

	@Override
	public StringBuffer createStringBuffer() {
		StringBuffer sb = super.createStringBuffer();
		return sb.append(getType()).append(",ls,")
				.append(getAngle()).append(Separator.COMMA);
	}
}
