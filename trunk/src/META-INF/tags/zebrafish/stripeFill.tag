<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.fill.*" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="color" type="java.lang.String" required="true" description="color" %><%@ 
attribute name="width" type="java.lang.Float" required="true" description="width" %><%
	StripeFillList list = getAttribute(request, KEY_STRIPE_FILL_LIST);
	if(list != null) {
		list.add(new StripeFill(new Color(color), width));
	}
%>