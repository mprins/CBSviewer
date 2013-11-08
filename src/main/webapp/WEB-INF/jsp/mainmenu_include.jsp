<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" 
	xmlns:c="http://java.sun.com/jsp/jstl/core" 
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"
		language="java" />

	<fmt:setBundle basename="LabelsBundle" />

	<div id="mainMenu" class="mainMenu">
		<ul>
			<li>
				<c:url value="/index.jsp" var="indexLink">
					<c:param name="coreonly" value="${param.coreonly}" />
				</c:url>
				<a href="${fn:escapeXml(indexLink)}" id="mainMenu_Home">
					<fmt:message key="KEY_MENU_HOME" />
				</a>
			</li>
			<li>
				<c:url value="/about.jsp" var="aboutLink">
					<c:param name="coreonly" value="${param.coreonly}" />
				</c:url>
				<a class="fancybox fancybox.ajax" href="${fn:escapeXml(aboutLink)}">
					<fmt:message key="KEY_MENU_ABOUT" />
				</a>
			</li>
			<li>
				<c:url value="/faq.jsp" var="faqLink">
					<c:param name="coreonly" value="${param.coreonly}" />
				</c:url> 
				<a class="fancybox fancybox.ajax" href="${fn:escapeXml(faqLink)}">
					<fmt:message key="KEY_MENU_HELP" />
				</a>
			</li>
			<li>
				<c:url value="/download.jsp" var="downloadLink">
					<c:param name="coreonly" value="${param.coreonly}" />
				</c:url>
				<a class="fancybox fancybox.ajax" href="${fn:escapeXml(downloadLink)}">
					<fmt:message key="KEY_MENU_DOWNLOAD" />
				</a>
			</li>
			
			<!-- div id downloadlink contains image -->
			<!--c:if test="${not empty downloadLink}">
					<fmt:message var="linkText" key="KEY_LINK_DOWNLOAD">
					<fmt:param value="${mapname}" /></fmt:message>
					<li><a href="${fn:escapeXml(downloadLink)}">
					<c:out value="${linkText}" /></a></li>
			</c:if-->
		</ul>
	</div>

</jsp:root>