<%@ 
tag import="org.zebrafish.field.Data,
			org.zebrafish.feature.DataList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="content" type="java.lang.String" required="true" description="Data" %><%
	DataList list = getAttribute(request, KEY_DATA_LIST);
	if(list != null) {
		list.add(new Data(content));
	}
%>