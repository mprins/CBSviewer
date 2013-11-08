<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"
		language="java" />
		
	<fmt:setBundle basename="SiteMenu" />

	<div id="shortMenu" class="shortMenu">
		<a href="http://www.cbs.nl/nl-NL/menu/organisatie/contact/overzicht/default.htm">
			<fmt:message key="KEY_FOOTER_CONTACT" />
		</a>
		<a href="http://www.cbs.nl/nl-NL/menu/organisatie/website/disclaimer/default.htm">
			<fmt:message key="KEY_FOOTER_DISCLAIMER" />
		</a>
		<a href="http://www.cbs.nl/nl-NL/menu/home/default.htm">cbs.nl</a>
	</div>
</jsp:root>