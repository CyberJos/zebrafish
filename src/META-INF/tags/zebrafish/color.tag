<%@ 
tag import="org.zebrafish.field.Color,
			org.zebrafish.feature.ColorList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="value" type="java.lang.String" required="true" description="Color value" %><%
	ColorList list = getAttribute(request, KEY_COLOR_LIST);
	if(list != null) {
		list.add(new Color(value));
	}
%>