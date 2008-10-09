<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.field.marker.ShapeMarker,
			org.zebrafish.feature.MarkerList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" required="true" description="type" %><%@ 
attribute name="color" type="java.lang.String" required="true" description="color" %><%@ 
attribute name="dataPoint" type="java.lang.Float" required="true" description="data point" %><%@ 
attribute name="dataSetIndex" type="java.lang.Integer" description="data set index" %><%@ 
attribute name="size" type="java.lang.Float" description="size" %><%@ 
attribute name="text" type="java.lang.String" description="text" %><%@ 
attribute name="priority" type="java.lang.Integer" description="priority" %><%
	MarkerList list = getAttribute(request, KEY_MARKER_LIST);
	if(list != null) {
		ShapeMarker marker = new ShapeMarker(type, new Color(color), dataPoint);
		list.add(marker);

		if(dataSetIndex != null) {
			marker.setDataSetIndex(dataSetIndex);
		}

		if(size != null) {
			marker.setSize(size);
		}

		if(priority != null) {
			marker.setPriority(priority);
		}

		if(text != null) {
			marker.setText(text);
		}
	}
%>