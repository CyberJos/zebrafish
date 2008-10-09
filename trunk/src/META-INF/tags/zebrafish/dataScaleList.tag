<%@ tag import="org.zebrafish.feature.DataScaleList" %><%@ include file="inc_common.tagf" %><% 
	DataScaleList list = loadFeature(request, KEY_DATA_SCALE_LIST, DataScaleList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_DATA_SCALE_LIST);
%>