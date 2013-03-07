<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false" />

	<!-- 
	include bestand met de header tags, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->
	<jsp:text>
		<div id="footer">
			<a href="/">Home</a> 
			<a href="#">Over CBS in uw buurt</a> 
			<a class="fancybox fancybox.ajax" href="help.jsp">Hoe werkt dit?</a> 
			<a href="http://www.cbs.nl/nl-NL/menu/organisatie/website/disclaimer/default.htm">Disclaimer</a> 
			<a href="http://www.cbs.nl/nl-NL/menu/organisatie/website/privacy/default.htm">Privacyverklaring</a>
			<a href="download.jsp">Download</a> 
			<a href="http://www.cbs.nl/nl-NL/menu/organisatie/contact/overzicht/default.htm" class="last">Contact</a>
		</div>
	</jsp:text>
</jsp:root>