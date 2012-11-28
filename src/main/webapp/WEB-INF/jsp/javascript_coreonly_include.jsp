<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" language="java"
		trimDirectiveWhitespaces="true" />

	<!-- 
	include bestand met de javascript tags, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->

	<fmt:setBundle basename="LabelsBundle" />

	<!-- let op de formatting/regeleinden hier! er zitten een paar truukjes in -->
	<jsp:text>
		<![CDATA[<script type="text/javascript" id="language" charset="utf-8"><!--//--><![CDATA[//><!--
		var RIA_LINK_TEXT=']]></jsp:text>
		<fmt:message key="RIA_LINK_TEXT" /><jsp:text><![CDATA[';
			//--><!]]]></jsp:text>
	<jsp:text><![CDATA[]></script>]]></jsp:text>
	
	<jsp:text>
		<![CDATA[<script type="text/javascript" src="js/coreonly_script.js"></script>]]>
	</jsp:text>

</jsp:root>