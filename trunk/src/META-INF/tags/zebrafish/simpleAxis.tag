<%@ 
tag import="org.zebrafish.field.SimpleAxis,
			org.zebrafish.field.Color,
			org.zebrafish.feature.AxisList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" required="true" description="type" %><%@
attribute name="start" type="java.lang.Integer" required="true" description="start" %><%@ 
attribute name="end" type="java.lang.Integer" required="true" description="end" %><%@
attribute name="step" type="java.lang.Integer" required="true" description="step" %><%@ 
attribute name="positions" type="java.lang.String" description="positions" %><%@
attribute name="color" type="java.lang.String" description="color" %><%@ 
attribute name="fontSize" type="java.lang.Integer" description="font size" %><%@ 
attribute name="alignment" type="java.lang.Integer" description="alignment" %><%
	AxisList list = getAttribute(request, KEY_AXIS_LIST);
	if(list != null) {
		SimpleAxis axis = new SimpleAxis(type, start, end);
		if(step != null) {
			axis.setStep(step);
		}

		if (positions != null) {
			axis.setPositions(positions);
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