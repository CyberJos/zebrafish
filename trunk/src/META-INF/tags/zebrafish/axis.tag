<%@ 
tag import="org.zebrafish.field.Axis,
			org.zebrafish.field.Color,
			org.zebrafish.feature.AxisList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" required="true" description="type" %><%@
attribute name="labels" type="java.lang.String" description="labels" %><%@
attribute name="positions" type="java.lang.String" description="positions" %><%@
attribute name="start" type="java.lang.Integer" description="start" %><%@ 
attribute name="end" type="java.lang.Integer" description="end" %><%@
attribute name="color" type="java.lang.String" description="color" %><%@ 
attribute name="fontSize" type="java.lang.Integer" description="font size" %><%@ 
attribute name="alignment" type="java.lang.Integer" description="alignment" %><%
	AxisList list = getAttribute(request, KEY_AXIS_LIST);
	if(list != null) {
		Axis axis = new Axis(type);
		if(labels != null) {
			axis.setLabels(labels);
		}

		if (positions != null) {
			axis.setPositions(positions);
		}

		if (start != null) {
			axis.setStart(start);
		}

		if (end != null) {
			axis.setEnd(end);
		}

		if (color != null) {
			axis.setColor(new Color(color));
		}

		if (fontSize != null) {
			axis.setFontSize(fontSize);
		}

		if (alignment != null) {
			axis.setAlignment(alignment);
		}
		list.add(axis);
	}
%>
