<%@ tag import="org.zebrafish.feature.ColorList" %><%@ include file="inc_common.tagf" %><% 
	ColorList list = loadFeature(request, KEY_COLOR_LIST, ColorList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_COLOR_LIST);
%>