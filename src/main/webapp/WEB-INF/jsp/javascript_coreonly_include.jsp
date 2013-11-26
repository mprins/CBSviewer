<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" language="java"
		trimDirectiveWhitespaces="false" />
	<!-- 
	include bestand met de javascript tags voor core, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->
	<fmt:setBundle basename="LabelsBundle" />
	<fmt:message key="RIA_LINK_TEXT" var="text" />
	<jsp:text>
		<!-- let op de formatting/regeleinden hier! er zitten een truukje in, het moet 1 regel zijn -->
		<![CDATA[<script type="text/javascript" id="language">/* <![CDATA[ */var RIA_LINK_TEXT="${text}";/* ]]]><![CDATA[]> */</script>]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[<script type="text/javascript" charset="utf-8" src="js/coreonly_script.js"></script>]]>
	</jsp:text>
</jsp:root>