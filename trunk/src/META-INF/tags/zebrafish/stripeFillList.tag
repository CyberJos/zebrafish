<%@ 
tag import="org.zebrafish.fill.StripeFillList" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="type" type="java.lang.String" description="type" %><%@ 
attribute name="angle" type="java.lang.Integer" description="angle" %><%
	StripeFillList list = getAttribute(request, KEY_STRIPE_FILL_LIST);
	if (list == null) {
		list = new StripeFillList(type, angle);
		setAttribute(request, KEY_STRIPE_FILL_LIST, list);
	} else {
		if(type != null) {
			list.setType(type);
		}
	
		if(angle != null) {
			list.setAngle(angle);
		}
	}
%><jsp:doBody /><%
	addFeatureIntoChart(request, list, KEY_STRIPE_FILL_LIST);
%>