/*
 * $Id$
 *
 * @(#)AbstractFieldList.java 2008/5/24
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.zebrafish.field.Field;
import org.zebrafish.util.Separator;

/**
 * An abstract implementation for {@link FieldList}.
 * 
 * @author Max Chu
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @param <T> type extended from <code>Field</code>
 * @since 0.1
 */
public abstract class AbstractFieldList<T extends Field> 
		extends AbstractFeature implements FieldList<T> {
	private List<T> list;

	private void checkList() {
		if (list == null) {
			list = new ArrayList<T>();
		}
	}

	public void add(T field) {
		if (field == null) {
			return;
		}
		checkList();
		list.add(field);
	}

	public void add(int index, T field) {
		if (field == null) {
			return;
		}
		checkList();
		list.add(index, field);
	}

	public void clear() {
		if (list == null) {
			return;
		}
		list.clear();
	}

	public boolean contains(T field) {
		return indexOf(field) != -1;
	}

	public T get(int index) {
		return list == null ? null : list.get(index);
	}

	public int indexOf(T field) {
		return list == null || field == null ? -1 : list.indexOf(field);
	}

	public boolean isEmpty() {
		return list == null ? true : list.isEmpty();
	}

	public T remove(int index) {
		return list == null ? null : list.remove(index);
	}

	public boolean remove(T field) {
		return list == null || field == null ? false : list.remove(field);
	}

	public T set(int index, T field) {
		if (field == null) {
			return null;
		}
		checkList();
		return list.set(index, field);
	}

	public int size() {
		return list == null ? 0 : list.size();
	}

	/**
	 * Returns the separator used between each field.
	 * 
	 * @return the separator used between each field
	 */
	protected Separator getSeparator() {
		return Separator.BAR;
	}

	public Iterator<T> iterator() {
		checkList();
		return list.iterator();
	}

	public String toURLString() {
		if (isEmpty()) {
			return StringUtils.EMPTY;
		}

		StringBuffer sb = createStringBuffer();
		for (T t : this) {
			String fieldURLString = t.toURLString();
			if (StringUtils.isNotEmpty(fieldURLString)) {
				sb.append(fieldURLString);
				sb.append(getSeparator());
			}
		}

		return sb.charAt(sb.length() - 1) == Separator.EQUAL.getChar() 
				? StringUtils.EMPTY 
				: sb.deleteCharAt(sb.length() - 1).toString();
	}
}
