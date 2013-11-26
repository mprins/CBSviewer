<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"
		language="java" />
		
	<fmt:setBundle basename="SiteMenu" />

	<fmt:message key="KEY_SITE_CONTACT_URL" 
		var="key_site_contact_url" />
	<fmt:message key="KEY_SITE_DISCLAIMER_URL" 
		var="key_site_disclaimer_url" />
	<fmt:message key="KEY_SITE_HOME_URL" 
		var="key_site_home_url" />


	<nav id="siteMenu" class="siteMenu">
		<a href="${key_site_contact_url}">
			<fmt:message key="KEY_SITE_CONTACT" />
		</a>
		<a href="${key_site_disclaimer_url}">
			<fmt:message key="KEY_SITE_DISCLAIMER" />
		</a>
		<a href="${key_site_home_url}">
			<fmt:message key="KEY_SITE_HOME" />
		</a>
	</nav>
</jsp:root>