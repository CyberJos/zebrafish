<%@ 
tag import="org.zebrafish.field.DataScale,
			org.zebrafish.feature.DataScaleList" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="min" type="java.lang.Integer" required="true" description="minimum" %><%@ 
attribute name="max" type="java.lang.Integer" description="maximum" %><%
	DataScaleList list = getAttribute(request, KEY_DATA_SCALE_LIST);
	if(list != null) {
		DataScale dataScale = new DataScale(min);
		if(max != null) {
			dataScale.setMax(max);
		}
		list.add(dataScale);
	}
%>