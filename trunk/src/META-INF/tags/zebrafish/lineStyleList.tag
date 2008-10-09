<%@ tag import="org.zebrafish.feature.LineStyleList" %><%@ include file="inc_common.tagf" %><% 
	LineStyleList list = loadFeature(request, KEY_LINE_STYLE_LIST, LineStyleList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_LINE_STYLE_LIST);
%>