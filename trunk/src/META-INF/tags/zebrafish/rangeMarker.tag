<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.field.marker.RangeMarker,
			org.zebrafish.feature.MarkerList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" required="true" description="type" %><%@ 
attribute name="color" type="java.lang.String" required="true" description="color" %><%@ 
attribute name="start" type="java.lang.Float" required="true" description="start" %><%@ 
attribute name="end" type="java.lang.Float" required="true" description="end" %><%
	MarkerList list = getAttribute(request, KEY_MARKER_LIST);
	if(list != null) {
		list.add(new RangeMarker(type, new Color(color), start, end));
	}
%>