<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="false" isErrorPage="false" />

	<fmt:setBundle basename="LabelsBundle" />
	
	<fmt:message key="KEY_ADRESZOEKEN_PLACEHOLDER" 
	var="key_adreszoeken_placeholder" />
	
	<fmt:message key="KEY_ADRESZOEKEN_SUBMIT" 
	var="key_adreszoeken_submit" />
	
	<div id="zoekContainer">

		<form method="get" action="adres" id="zoekFormulier" class="zoekinput">
			<div>
				<label for="adres"><fmt:message key="KEY_ADRESZOEKEN_TITEL" /></label>
				<input name="adres" id="adres" value="${param.adres}" 
					placeholder="${key_adreszoeken_placeholder}" type="text" />
				<input id="searchbutton" name="searchbutton" type="image" 
					src="img/new/btn_header_search.gif" alt="${key_adreszoeken_submit}"/>

				<c:if test="${request.straal != null}">
					<input type="hidden" name="straal" value="${straal}" />
				</c:if>
				<input type="hidden" name="coreonly" value="true" />
				<input type="hidden" name="forward" value="true" />
			</div>
		</form>

		<div id="zoekresultaten">
			<!-- REQ_PARAM_GEVONDEN.code -->
			<c:out value="${gevonden}" />
			<c:out value="${param.gevonden}" />
			<c:if test="${adreslijst!=null}">

			<div class="adreskeuze_wrapper">
				<div class="adreskeuze">

					<ul class="adreslijst">
						<li class="list">
							<a class="selector" href="#">
								<fmt:message key="KEY_ZOEKEN_CHOICE" />
							</a>

							<ul class="adressen">
								<c:forEach var="adres" items="${adreslijst}">
									<!-- for item in lijst maak hyperlinked list item -->
									<fmt:message var="ttl" key="KEY_ZOEKEN_LINK_TTL">
										<fmt:param value="${adres}" />
									</fmt:message>
								<li><c:url value="/index.jsp" var="adreslink">
										<c:param name="gevonden" value="${adres}" />
										<c:param name="xcoord" value="${adres.xCoord}" />
										<c:param name="ycoord" value="${adres.yCoord}" />
										<c:param name="straal" value="${adres.radius}" />
										<c:param name="coreonly" value="${param.coreonly}" />
									</c:url>
									<a href="${fn:escapeXml(adreslink)}">
										<span class="visually-hidden">${ttl}</span>${adres}
									</a>
								</li>
								</c:forEach>
							</ul>

						</li>
					</ul>

				</div>
			</div>
			</c:if>
		</div>

	</div>

</jsp:root>
