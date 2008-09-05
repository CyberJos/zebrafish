/*
 * $Id$
 *
 * @(#)AxisList.java 2008/9/4
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
import org.zebrafish.field.Axis;
import org.zebrafish.field.Color;

/**
 * Axes are specified by the index they have in this list. The first axis has
 * an index of 0, the second has an index of 1, and so on. You can specify 
 * multiple axes by including x, t, y, or r multiple times.
 *  
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @since 0.1
*/
public class AxisList extends AbstractFieldList<Axis> {
	@Override
	public final String toURLString() {
		StringBuffer sb = new StringBuffer(64);

		if (size() > 0) {
			StringBuffer typeSB = new StringBuffer(8);
			StringBuffer labelSB = new StringBuffer(16);
			StringBuffer positionSB = new StringBuffer(8);
			StringBuffer rangeSB = new StringBuffer(8);
			StringBuffer styleSB = new StringBuffer(32);

			int idx = 0;
			for (Axis axis : this) {
				// type
				typeSB.append(",").append(axis.getType());

				// labels
				String labels = axis.getLabels();
				if (StringUtils.isNotBlank(labels)) {
					labelSB.append(idx).append(":|");
					labelSB.append(labels.replaceAll(",", "|"));
					labelSB.append("|");
				}

				// positions
				String positions = axis.getPositions();
				if (StringUtils.isNotBlank(positions)) {
					positionSB.append(idx).append(",").append(positions)
							.append("|");
				}

				// range
				Integer start = axis.getStart();
				Integer end = axis.getEnd();
				if (start != null && end != null) {
					rangeSB.append(idx).append(",").append(start).append(",")
							.append(end).append("|");
				}

				// style
				Color color = axis.getColor();
				if (axis.getColor() != null) {
					styleSB.append(idx).append(",").append(color).append(",")
						.append(axis.getFontSize());

					Integer align = axis.getAlignment();
					if (align != null) {
						styleSB.append(",").append(align);
					}
					styleSB.append("|");
				}
				idx++;
			}

			if (typeSB.length() > 0) {
				sb.append("&chxt=").append(typeSB.deleteCharAt(0));
			}

			if (labelSB.length() > 0) {
				sb.append("&chxl=").append(labelSB.deleteCharAt(labelSB.length() - 1));
			}

			if (positionSB.length() > 0) {
				sb.append("&chxp=").append(positionSB.deleteCharAt(positionSB.length() - 1));
			}

			if (rangeSB.length() > 0) {
				sb.append("&chxr=").append(rangeSB.deleteCharAt(rangeSB.length() - 1));
			}

			if (styleSB.length() > 0) {
				sb.append("&chxs=").append(styleSB.deleteCharAt(styleSB.length() - 1));
			}
		}
		return sb.toString();
	}

	public String getParameterName() {
		return null;
	}
}
