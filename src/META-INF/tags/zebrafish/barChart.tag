<%@ 
tag import="org.zebrafish.chart.BarChart" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="width" type="java.lang.Integer" required="true" description="The width" %><%@ 
attribute name="height" type="java.lang.Integer" required="true" description="The height" %><%@ 
attribute name="alt" type="java.lang.String" description="alt" %><%@
attribute name="title" type="java.lang.String" description="title" %><%@
attribute name="id" type="java.lang.String" description="id" %><%@
attribute name="className" type="java.lang.String" description="class name" %><%@
attribute name="style" type="java.lang.String" description="style" %><%@
attribute name="vertical" type="java.lang.Boolean" description="vertical" %><%@ 
attribute name="stacked" type="java.lang.Boolean" description="stacked" %><% 
		try {
			removeAllAttributes(request);
			BarChart chart = new BarChart(width, height);
			if(stacked != null) {
				chart.setStacked(stacked);
			}
	
			if(vertical != null) {
				chart.setVertical(vertical);
			}
			setAttribute(request, KEY_GOOGLE_CHART, chart);
%><jsp:doBody /><%
			out.print(getImageTag(chart.toURLString(), width, height, alt, title, id, className, style));
		} catch (Exception e) {
			out.print(getErrorTag(e.getMessage()));
		} finally {
			removeAllAttributes(request);
		}
%>