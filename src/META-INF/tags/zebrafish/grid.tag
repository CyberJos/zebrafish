<%@ 
tag import="org.zebrafish.feature.Grid" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="stepX" type="java.lang.Integer" required="true" description="x" %><%@ 
attribute name="stepY" type="java.lang.Integer" required="true" description="y" %><%@ 
attribute name="lineSegment" type="java.lang.Integer" description="line segment" %><%@ 
attribute name="blankSegment" type="java.lang.Integer" description="blank segment" %><%
	if(getAttribute(request, KEY_GOOGLE_CHART) != null) {
		Grid grid = new Grid(stepX, stepY);
		if(lineSegment != null) {
			grid.setLineSegment(lineSegment);
		}

		if(blankSegment != null) {
			grid.setBlankSegment(blankSegment);
		}

		addFeatureIntoChart(request, grid, null);
	}
%>