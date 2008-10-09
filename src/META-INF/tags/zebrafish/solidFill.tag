<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.fill.*" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="color" type="java.lang.String" required="true" description="color" %><%@ 
attribute name="type" type="java.lang.String" required="true" description="type" %><%
	SolidFillList list = getAttribute(request, KEY_SOLID_FILL_LIST);
	if(list != null) {
		list.add(new SolidFill(type, new Color(color)));
	}
%>