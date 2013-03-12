<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false" />

	<fmt:setBundle basename="LabelsBundle" />
	<!-- 
	include bestand met de header tags, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->
	<jsp:text>
		<div id="footerWrapper">	
			<span class="introduction"><fmt:message key="KEY_COPYRIGHT" /></span>
			<ul>
				<li><a href="http://www.cbs.nl">Contact</a></li>
				<li><a href="http://www.cbs.nl">Gebruikersvoorwaarden</a></li>
				<li><a href="http://www.cbs.nl">Sitemap</a></li>
				<li class="goTop"><a href="#top"><span>link naar boven</span></a></li>
			</ul>
		</div>
	</jsp:text>
</jsp:root>