<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="org.slf4j.Logger, org.slf4j.LoggerFactory"
		trimDirectiveWhitespaces="true" language="java" />

	<jsp:scriptlet>Logger logger = LoggerFactory.getLogger("nl.mineleni.cbsviewer");
			if (logger.isDebugEnabled()) {
				logger.debug("LET OP: de applicatie draait in debug modus");
			}
			pageContext.setAttribute("isDebugEnabled", logger.isDebugEnabled());</jsp:scriptlet>

	<c:if test="${isDebugEnabled}">
		<img class="debug" src="img/debug.png"
			alt="Deze applicatie draait in debug/ontwikkelaars modus" />
	</c:if>
</jsp:root>