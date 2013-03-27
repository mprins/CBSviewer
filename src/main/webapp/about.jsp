<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="false" isErrorPage="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<fmt:setBundle basename="AboutLabelsBundle" />

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

		<p><fmt:message key="KEY_PAG_CONTENT" /></p>
	</div>
	<c:if test="${param.coreonly==true}">
		<jsp:include page="WEB-INF/jsp/footer_include.jsp" />
	</c:if>
</body>
	</html>
</jsp:root>