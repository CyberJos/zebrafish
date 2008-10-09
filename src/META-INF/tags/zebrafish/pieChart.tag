<%@ 
tag import="org.zebrafish.chart.PieChart" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="width" type="java.lang.Integer" required="true" description="The width" %><%@ 
attribute name="height" type="java.lang.Integer" required="true" description="The height" %><%@ 
attribute name="alt" type="java.lang.String" description="alt" %><%@
attribute name="title" type="java.lang.String" description="title" %><%@
attribute name="id" type="java.lang.String" description="id" %><%@
attribute name="className" type="java.lang.String" description="class name" %><%@
attribute name="style" type="java.lang.String" description="style" %><%@
attribute name="threeD" type="java.lang.Boolean" description="Three dimensional" %><% 
		try {
			removeAllAttributes(request);
			PieChart chart = new PieChart(width, height);
			if(threeD != null) {
				chart.setThreeD(threeD);
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