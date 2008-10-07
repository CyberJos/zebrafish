/*
 * $Id$
 *
 * @(#)LineChartTest.java 2008/5/10
 *
 * Copyright (c) Joseph S. Kuo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */
package org.zebrafish.test.chart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.zebrafish.chart.LineChart;
import org.zebrafish.feature.ColorList;
import org.zebrafish.feature.DataList;
import org.zebrafish.feature.DataScaleList;
import org.zebrafish.feature.EncodingType;
import org.zebrafish.feature.Title;
import org.zebrafish.field.Color;
import org.zebrafish.field.Data;
import org.zebrafish.field.DataScale;


/**
 *
 *
 * @version $Revision$, $Date$
 * @author Joseph Kuo
 * @since 
 */
public class LineChartTest {
	private static Log logger = LogFactory.getLog(LineChartTest.class);

	@Test
	public void lineChart() {
		LineChart chart = new LineChart(400, 300);
		chart.addFeature(new Title("TEST"));

		ColorList cs = new ColorList();
		cs.add(new Color("FF0000"));
		cs.add(new Color("0000FF"));
		chart.addFeature(cs);

		DataList ds = new DataList();
		ds.add(new Data("60,40,80,30"));
		ds.add(new Data("30,90,45,20"));
		ds.setType(EncodingType.EXTENDED);
		chart.addFeature(ds);

		DataScaleList dsl = new DataScaleList();
		dsl.add(new DataScale(0, 100));
		dsl.add(new DataScale(0, 100));
		chart.addFeature(dsl);

		logger.info(chart.toURLString());
	}
}
