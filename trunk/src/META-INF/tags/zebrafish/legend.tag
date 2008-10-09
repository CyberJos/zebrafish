<%@ 
tag import="org.zebrafish.field.Legend,
			org.zebrafish.feature.LegendList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="text" type="java.lang.String" required="true" description="Data" %><%
	LegendList list = getAttribute(request, KEY_LEGEND_LIST);
	if(list != null) {
		list.add(new Legend(text));
	}
%>