<%@ tag import="org.zebrafish.feature.LegendList" %><%@ include file="inc_common.tagf" %><% 
	LegendList list = loadFeature(request, KEY_LEGEND_LIST, LegendList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_LEGEND_LIST);
%>