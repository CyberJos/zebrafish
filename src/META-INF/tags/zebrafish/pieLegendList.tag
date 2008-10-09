<%@ tag import="org.zebrafish.feature.PieLegendList" %><%@ include file="inc_common.tagf" %><% 
	PieLegendList list = loadFeature(request, KEY_LEGEND_LIST, PieLegendList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_LEGEND_LIST);
%>