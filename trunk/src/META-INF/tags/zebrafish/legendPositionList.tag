<%@ tag import="org.zebrafish.feature.LegendPositionList" %><%@ include file="inc_common.tagf" %><% 
	LegendPositionList list = loadFeature(request, KEY_LEGEND_POSITION_LIST, LegendPositionList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_LEGEND_POSITION_LIST);
%>