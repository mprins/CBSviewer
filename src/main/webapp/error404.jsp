<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="true" isErrorPage="true" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat"
		omit-xml-declaration="true" />

	<fmt:setBundle basename="ErrorLabelsBundle" />

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<title><fmt:message key="KEY_ERROR_404_TITEL" /></title>
</head>
<body>
	<jsp:include page="WEB-INF/jsp/debug_include.jsp" />
	<header>
		<jsp:include page="WEB-INF/jsp/sitemenu_include.jsp" />
	</header>
	<section class="page smallpopup">
		<h1>
			<fmt:message key="KEY_ERROR_404_TITEL" />
		</h1>

		<p class="error">
			<fmt:message key="KEY_ERROR_404_MELDING" />
		</p>
		<ul>
			<li><fmt:message key="KEY_ERROR_404_OPLOSSING1" /></li>
			<li><fmt:message key="KEY_ERROR_404_OPLOSSING2" /></li>
			<li><fmt:message key="KEY_ERROR_404_OPLOSSING3" /></li>
		</ul>
	</section>
</body>
	</html>
</jsp:root>