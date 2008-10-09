<%@ tag import="org.zebrafish.feature.MarkerList" %><%@ include file="inc_common.tagf" %><% 
	MarkerList list = loadFeature(request, KEY_MARKER_LIST, MarkerList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_MARKER_LIST);
%>