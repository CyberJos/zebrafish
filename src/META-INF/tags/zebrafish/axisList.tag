<%@ tag import="org.zebrafish.feature.AxisList" %><%@ include file="inc_common.tagf" %><% 
	AxisList list = loadFeature(request, KEY_AXIS_LIST, AxisList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_AXIS_LIST);
%>