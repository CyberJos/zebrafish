/*
 * $Id$
 *
 * @(#)FieldList.java 2008/5/24
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

import org.zebrafish.field.Field;

/**
 * A field list that contains fields.
 * 
 * @author Joseph S. Kuo
 * @version $Revision$, $Date$
 * @param <T> 
 * @since 0.1
 */
public interface FieldList<T extends Field> extends Feature, Iterable<T> {
	/**
	 * Appends the specified field to the end of this list.
	 * 
	 * Lists will refuse to add null fields.
	 *  
	 * @param field field to be appended to this list 
	 */
	public void add(T field);

	/**
	 * Inserts the specified field at the specified position in this list and 
	 * shifts the field currently at that position if any.
	 *  
	 * @param index index at which the specified field is to be inserted
	 * @param field field to be appended to this list 
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void add(int index, T field);

	/**
	 * Removes all of the fields from this list. 
	 */
	public void clear();

	/**
	 * Returns true if this list contains the specified field.
	 *  
	 * @param field field whose presence in this list is to be tested 
	 * @return true if this list contains the specified field
	 */
	public boolean contains(T field);

	/**
	 * Returns the field at the specified position in this list.
	 * 
	 * @param index index of the element to return 
	 * @return the field at the specified position in this list.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public T get(int index);

	/**
	 * Returns the index of the first occurrence of the specified field in this 
	 * list, or -1 if this list does not contain the field. If the specified
	 * field is null, it will return -1.
	 *  
	 * @param field field to search for 
	 * @return the index of the first occurrence of the specified field in this 
	 * 		list, or -1 if this list does not contain the field 
	 */
	public int indexOf(T field);

	/**
	 * Returns true if this list contains no fields. 
	 * 
	 * @return true if this list contains no fields
	 */
	public boolean isEmpty();

	/**
	 * Removes the field at the specified position in this list and shifts any 
	 * subsequent fields to the left. Returns the field that was removed from 
	 * the list.
	 *  
	 * @param index the index of the field to be removed 
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public T remove(int index);

	/**
	 * Removes the first occurrence of the specified field from this list, if 
	 * it is present. If this list does not contain the field, it is unchanged. 
	 *  
	 * Lists will refuse to remove null fields.
	 * 
	 * @param field the field to be removed from this list, if present 
	 * @return true if this list contained the specified element 
	 */
	public boolean remove(T field);

	/**
	 * Replaces the filed at the specified position in this list with the 
	 * specified filed.
	 *  
	 * Lists will refuse to set null fields.
	 * 
	 * @param index index of the element to replace
	 * @param filed filed to be stored at the specified position 
	 * @return the filed previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public T set(int index, T filed);

	/**
	 * Returns the number of fields in this list. If this list contains more 
	 * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 *  
	 * @return the number of fields in this list
	 */
	public int size();
}
