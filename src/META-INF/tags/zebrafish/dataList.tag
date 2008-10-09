<%@ 
tag import="org.zebrafish.feature.DataList,
			org.zebrafish.feature.EncodingType" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" description="Encoding type, defaults to 't'" %><%@ 
attribute name="autoScale" type="java.lang.Boolean" description="Auto scaling, defaults to true" %><%
	DataList list = loadFeature(request, KEY_DATA_LIST, DataList.class);
	if(type != null) {
		list.setType(EncodingType.parseType(type));
	}

	if(autoScale != null) {
		list.setAutoScale(autoScale);
	}
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_DATA_LIST);
%>