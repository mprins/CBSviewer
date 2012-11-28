<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="nl.mineleni.cbsviewer.util.LabelsBundle, nl.mineleni.cbsviewer.util.StringConstants"
		trimDirectiveWhitespaces="true" language="java" isThreadSafe="false"
		isErrorPage="false" />

	<jsp:scriptlet>LabelsBundle RESOURCES = new LabelsBundle();</jsp:scriptlet>
	
	<!-- zoek formulier voor de versie zonder javascript en/of css -->
	<!-- todo, geeft nog 4 fouten bij w3c check, nog oplossen later -->
	<div id="zoekContainer">
		<form title="Zoekformulier" method="get" action="adres" id="zoekFormulier">
			<p class="zoekinput">
				<input type="text" id="adres" accesskey="8" name="adres" value="${param.adres}"/>
				
				<c:if test="${request.straal != null}">
					<input type="hidden" name="straal" value="${straal}"/>
				</c:if>
				
				<input type="hidden" name="coreonly" value="true"/>
				<input type="hidden" name="forward" value="true"/>
				
				<button type="button" id="delete"><span id="x">X</span></button>

				<input value="" type="submit" accesskey="s" id="searchbutton"/>		
			</p>
		</form>
		<p id="zoekresultaten">
			<c:out value="${gevonden}" />
		</p>
		<c:if test="${adreslijst!=null }">
			<!-- for item in lijst maak url -->
			<ul class="adreslijst">
				<c:forEach var="adres" items="${adreslijst}">
					<li><a class="button"
						href="index.jsp?gevonden=${adres}&amp;xcoord=${adres.xCoord}&amp;ycoord=${adres.yCoord}&amp;straal=${adres.radius}&amp;coreonly=${param.coreonly}"
						title="zoom in op ${adres}">${adres}</a></li>
				</c:forEach>
			</ul>
		</c:if>		
	</div>
</jsp:root>