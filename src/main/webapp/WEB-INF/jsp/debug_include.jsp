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

	<!-- 
		Indien in log4j.xml het logging level voor nl.mineleni.cbsviewer op debug of meer wordt 
		ingesteld worden onderstaande afbeelding gerenderd. 
		Voor lagere logging levels (info, warn, error,...) niet.
	-->
	<c:if test="${isDebugEnabled}">
		<div>
			<img class="debug" src="img/debug.png"
				alt="Deze applicatie draait in debug/ontwikkelaars modus" />
		</div>
	</c:if>
</jsp:root>
