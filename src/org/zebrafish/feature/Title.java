/*
 * $Id$
 *
 * @(#)Title.java 2008/5/8
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

import org.apache.commons.lang.StringUtils;
import org.zebrafish.field.Color;
import org.zebrafish.util.Separator;

/**
 * Title used in charts.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
 */
public class Title extends AbstractFeature {
	/** Default title color: 000000. */
	public static final String DEFAULT_TITLE_COLOR = "000000";

	/** Default title font size: 14. */
	public static final int DEFAULT_TITLE_FONT_SIZE = 14;

	private String text;

	private int fontSize;

	private Color color;

	/**
	 * Constructs a <code>Title</code> object with the specified text.
	 * 
	 * @param text the content of title
	 */
	public Title(String text) {
		setText(text);
	}

	/**
	 * Returns the content of this title.
	 * 
	 * @return the content of this title
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the content of this title
	 * 
	 * @param text the content of this title
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns the font size of this title.
	 * 
	 * @return the font size of this title
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the font size of this title. If the given font size is less then
	 * zero then it will be set to use default size
	 * {@link #DEFAULT_TITLE_FONT_SIZE}.
	 * 
	 * @param fontSize the font size of this title
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize > 0 ? fontSize : DEFAULT_TITLE_FONT_SIZE;
	}

	/**
	 * Returns the color of this title.
	 * 
	 * @return the color of this title
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of this title.
	 *  
	 * @param the color of this title
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	public final String toURLString() {
		if (text == null) {
			return StringUtils.EMPTY;
		}

		StringBuffer sb = createStringBuffer();
		sb.append(formatTitle());
		if (color != null || fontSize > 0) {
			sb.append("&chts=")
				.append(color != null ? color.toURLString() : DEFAULT_TITLE_COLOR)
				.append(Separator.COMMA)
				.append(fontSize);
		}
		return sb.toString();
	}

	private final String formatTitle() {
		return text.replaceAll("\n", "|").replaceAll("\\\\n", "|").replaceAll("\\s+", "+");
	}

	public String getParameterName() {
		return "chtt";
	}
}
