<%@ tag import="org.zebrafish.fill.SolidFillList" %><%@ include file="inc_common.tagf" %><%
	SolidFillList list = loadFeature(request, KEY_SOLID_FILL_LIST, SolidFillList.class);
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_SOLID_FILL_LIST);
%>