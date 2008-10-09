<%@ 
tag import="org.zebrafish.feature.Title,
			org.zebrafish.field.Color" 
	body-content="empty" %><%@ 
include file="inc_common.tagf" %><%@ 
attribute name="text" type="java.lang.String" required="true" description="Title text" %><%@ 
attribute name="color" type="java.lang.String" description="Title color" %><%@ 
attribute name="size" type="java.lang.Integer" description="Title font size" %><%
	if(getAttribute(request, KEY_GOOGLE_CHART) != null) {
		Title title = new Title(text);
		if(color != null) {
			title.setColor(new Color(color));
		}

		if(size != null) {
			title.setFontSize(size);
		}

		addFeatureIntoChart(request, title, null);
	}
%>