<%@ 
tag import="org.zebrafish.feature.BarWidth,
			org.zebrafish.field.Color,
			org.zebrafish.chart.GoogleChart, 
			org.zebrafish.chart.BarChart" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="barWidth" type="java.lang.Integer" description="bar width" %><%@ 
attribute name="barSpace" type="java.lang.Integer" description="space between bars in a group" %><%@ 
attribute name="groupSpace" type="java.lang.Integer" description="space between groups" %><%
	GoogleChart chart = getAttribute(request, KEY_GOOGLE_CHART);
	if(chart != null && chart instanceof BarChart) {
		BarWidth bw = new BarWidth();
		if(barWidth != null) {
			bw.setBarWidth(barWidth);
		}

		if(barSpace != null) {
			bw.setBarSpace(barSpace);
		}

		if(groupSpace != null) {
			bw.setGroupSpace(groupSpace);
		}
		((BarChart) chart).setBarWidth(bw);
	}
%>