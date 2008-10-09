<%@ 
tag import="org.zebrafish.field.LegendPosition,
			org.zebrafish.feature.LegendPositionList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="position" type="java.lang.String" required="true" description="position" %><%
	LegendPositionList list = getAttribute(request, KEY_LEGEND_POSITION_LIST);
	if(list != null) {
		list.add(new LegendPosition(position));
	}
%>