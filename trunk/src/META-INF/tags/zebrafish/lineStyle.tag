<%@ 
tag import="org.zebrafish.field.LineStyle,
			org.zebrafish.feature.LineStyleList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="thickness" type="java.lang.Integer" required="true" description="thickness" %><%@ 
attribute name="lineSegment" type="java.lang.Integer" required="true" description="line segment" %><%@ 
attribute name="blankSegment" type="java.lang.Integer" required="true" description="blank segment" %><%
	LineStyleList list = getAttribute(request, KEY_LINE_STYLE_LIST);
	if(list != null) {
		list.add(new LineStyle(thickness, lineSegment, blankSegment));
	}
%>