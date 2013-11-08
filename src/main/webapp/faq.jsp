<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="false" isErrorPage="false" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat"
		omit-xml-declaration="true" />

	<fmt:setBundle basename="FaqLabelsBundle" />

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<title><fmt:message key="KEY_PAG_TITEL" /></title>
</head>
<body>
	<div class="page smallpopup">
		<h1>
			<fmt:message key="KEY_PAG_TITEL" />		
		</h1>	

		<h3><fmt:message key="KEY_CONTENT_H3_1" /></h3>
		<p><fmt:message key="KEY_CONTENT_P1" /></p>
		
		<h3><fmt:message key="KEY_CONTENT_H3_2" /></h3>
		<p><fmt:message key="KEY_CONTENT_P2" /></p>

		<h3><fmt:message key="KEY_CONTENT_H3_3" /></h3>
		<p><fmt:message key="KEY_CONTENT_P3" /></p>

		<h3><fmt:message key="KEY_CONTENT_H3_4" /></h3>
		<p><fmt:message key="KEY_CONTENT_P4" /></p>

		<h3><fmt:message key="KEY_CONTENT_H3_5" /></h3>
		<p><fmt:message key="KEY_CONTENT_P5" /></p>

		<h3><fmt:message key="KEY_CONTENT_H3_6" /></h3>
		<p><fmt:message key="KEY_CONTENT_P6" /></p>

		<h3><fmt:message key="KEY_CONTENT_H3_7" /></h3>
		<p><fmt:message key="KEY_CONTENT_P7" /></p>
	</div>
	<c:if test="${param.coreonly==true}">
		<jsp:include page="WEB-INF/jsp/footer_include.jsp" />
	</c:if>
</body>
	</html>
</jsp:root>