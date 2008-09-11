/*
 * $Id$
 *
 * @(#)DataList.java 2008/8/27
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

import org.zebrafish.field.Data;
import org.zebrafish.util.ChartHelper;
import org.zebrafish.util.Separator;

/**
 * A <code>Data</code> list.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class DataList extends AbstractFieldList<Data> {
	/** Default encoding type: {@link EncodingType#TEXT}. */
	public static final EncodingType DEFAULT_ENCODING_TYPE = EncodingType.TEXT;

	private EncodingType type = DEFAULT_ENCODING_TYPE;

	private boolean autoScale = true; // default auto scale

	/**
	 * Returns the encoding type. See {@link EncodingType} for more 
	 * informations.
	 * 
	 * @return the encoding type
	 */
	public EncodingType getType() {
		return type;
	}

	/**
	 * Sets the encoding type. 
	 * 
	 * @param type the encoding type
	 */
	public void setType(EncodingType type) {
		this.type = type == null ? EncodingType.TEXT : type;
	}

	/**
	 * Returns if this list will scale the data range automatically or not.
	 * 
	 * @return if this list will scale the data range automatically or not
	 */
	public boolean isAutoScale() {
		return autoScale;
	}

	/**
	 * Sets true if this list will scale the data range automatically.
	 * 
	 * @param autoScale true if this list will scale the data range 
	 * 		automatically
	 */
	public void setAutoScale(boolean autoScale) {
		this.autoScale = autoScale;
	}

	@Override
	public String toURLString() {
		StringBuffer sb = createStringBuffer();

		if (isEmpty()) {
			return sb.toString();
		}

		sb.append(ChartHelper.encodeData(this));
		if (sb.charAt(sb.length() - 1) == type.getSeparator().getSymbol()) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * Creates a <code>StringBuffer</code> object which has appended parameter
	 * information in the head of the string and others. It will return a 
	 * <code>StringBuffer</code> object which starts with 
	 * "&<em>chart_type</em>=<em>encoding_type</em>:".
	 * 
	 * @return a <code>StringBuffer</code> object which has appended parameter
	 * 		information
	 */
	@Override
	public StringBuffer createStringBuffer() {
		return super.createStringBuffer().append(type.getType())
				.append(Separator.COLON);
	}

	@Override
	public final String getParameterName() {
		return "chd";
	}
}
