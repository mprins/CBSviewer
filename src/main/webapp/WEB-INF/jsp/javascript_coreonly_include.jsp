<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="nl.mineleni.cbsviewer.util.LabelsBundle" language="java"
		trimDirectiveWhitespaces="true" />

	<jsp:scriptlet>LabelsBundle RESOURCES = new LabelsBundle();</jsp:scriptlet>

	<!-- 
	include bestand met de javascript tags, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->

	<jsp:text>
		<![CDATA[<script type="text/javascript" id="language" charset="utf-8">var RIA_LINK_TEXT=']]>
	</jsp:text>
	<jsp:expression>RESOURCES.getString("RIA_LINK_TEXT")</jsp:expression>
	<jsp:text>
		<![CDATA[';</script>
		<script type="text/javascript" src="js/coreonly_script.js"></script>]]>
	</jsp:text>
</jsp:root>