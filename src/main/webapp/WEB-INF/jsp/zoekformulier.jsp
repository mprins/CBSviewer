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
	<form id="zoekFormulier" action="#" method="get" title="Zoekformulier"
		name="zoekFormulier">
		<jsp:expression>RESOURCES.getString("KEY_ADRESZOEKEN_TITEL")</jsp:expression>
		<p class="todo">TODO: implementatie</p>
		<p>
			<!-- <jsp:expression>StringConstants.REQ_PARAM_ADRES</jsp:expression> -->
			<label for="adres">Postcode of plaatsnaam</label> <input type="text"
				id="adres" name="adres" value="${param.ingevuld}" />
		</p>

		<p class="button">
			<!-- <jsp:expression>StringConstants.REQ_PARAM_STRAAL</jsp:expression> -->
			<c:if test="${request.straal != null}">
				<input type="hidden" name="straal" value="${request.straal}" />
			</c:if>

			<!-- <jsp:expression>StringConstants.REQ_PARAM_COREONLY</jsp:expression> 
			${param.coreonly} -->
			<input type="hidden" name="coreonly" value="true" />


			<button type="submit">
				<span><jsp:expression>RESOURCES.getString("KEY_ZOEKEN_SUBMIT")</jsp:expression></span>
			</button>
		</p>

	</form>

</jsp:root>