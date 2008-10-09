<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.fill.*" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="color" type="java.lang.String" required="true" description="color" %><%@ 
attribute name="offset" type="java.lang.Float" required="true" description="offset" %><%
	GradientFillList list = getAttribute(request, KEY_GRADIENT_FILL_LIST);
	if(list != null) {
		list.add(new GradientFill(new Color(color), offset));
	}
%>