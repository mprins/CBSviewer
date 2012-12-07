<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" 
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		trimDirectiveWhitespaces="false" language="java" isThreadSafe="false"
		isErrorPage="false" />

	<fmt:setBundle basename="LabelsBundle" />
	
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
					<fmt:message var="ttl" key="KEY_ZOEKEN_LINK_TTL"><fmt:param value="${adres}" /></fmt:message>
					<li><a class="button"
						href="index.jsp?gevonden=${adres}&amp;xcoord=${adres.xCoord}&amp;ycoord=${adres.yCoord}&amp;straal=${adres.radius}&amp;coreonly=${param.coreonly}"
						title="${ttl}">${adres}</a></li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
</jsp:root>