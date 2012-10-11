<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="nl.mineleni.cbsviewer.util.LabelsBundle, nl.mineleni.cbsviewer.util.StringConstants"
		trimDirectiveWhitespaces="true" language="java" isThreadSafe="false"
		isErrorPage="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<jsp:scriptlet>LabelsBundle RESOURCES = new LabelsBundle();</jsp:scriptlet>

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<script type="text/javascript">
	document.documentElement.className += ' js';
</script>

<title>Kaart</title>
</head>

<body>

	<div id="wrapper" class="wrapper">

		<div id="header" class="header">
			<jsp:expression>RESOURCES.getString("KEY_KAART_TITEL")</jsp:expression>
		</div>

		<div id="article" class="article">
			<div id="coreContainer" class="kaartContainer">
				<c:if test="${param.coreonly!=true}">
					<!-- deze alinea wordt verborgen tijdens laden van de pagina, 
				tenzij er geen css / javascript ondersteuning is -->
					<p>
						De browser ondersteund geen Javascript of Cascading Style Sheets
						(CSS), voor deze gevallen is er een <a href="?coreonly=true"
							title="Open de aangepaste versie">aangepaste versie van de
							applicatie beschikbaar</a>. U kunt <a href="#zoekFormulier"
							title="spring naar zoekformulier">hiernaast</a> een adres
						invullen om meteen naar een lokatie te gaan in de kaart.
					</p>
				</c:if>
				<!-- hier komt de statische kaart -->
				<c:if test="${param.coreonly==true}">
					<jsp:include page="kaart">
						<jsp:param name="forward" value="false" />
					</jsp:include>
					<c:if test="${not empty kaart}">
						<!-- StringConstants.MAP_CACHE_DIR -->
						<img src="${dir}/${kaart.name}"
							alt="kaart voor ${request.layername}" />
						<p class="todo">TODO: zoom/pan en vergroot knoppen</p>
					</c:if>
				</c:if>
			</div>

			<!-- deze container wordt zichtbaar gemaakt tijdens laden van de pagina, 
				tenzij er geen css / javascript ondersteuning is -->
			<div id="kaartContainer" class="kaartContainer hidden">
				<div id="cbsKaart" class="kaart">
					<!-- hier wordt de dynamische kaart ingehangen -->
				</div>
			</div>

			<c:if test="${not empty kaart}">
				<div id="copyright" class="copy">
					<jsp:expression>RESOURCES.getString("KEY_COPYRIGHT")</jsp:expression>
				</div>
			</c:if>
		</div>


		<div id="aside" class="aside">

			<div id="zoekenContainer" class="zoeken">
				
				<jsp:include page="WEB-INF/jsp/zoekformulier.jsp" />
			</div>

			<div id="legendaContainer" class="legenda">
				<jsp:expression>RESOURCES.getString("KEY_LEGENDA_TITEL")</jsp:expression>
				<div id="legenda">
					<!-- plaats voor de legenda, dynamisch en statisch -->
					<c:if test="${param.coreonly==true}">
						<c:if test="${not empty kaart}">
							<c:forEach items="${legendas}" varStatus="legenda">
								<img src="${dir}/${legendas[legenda.index].name}"
									alt="legenda item" />
							</c:forEach>
						</c:if>
					</c:if>
				</div>
			</div>

			<div id="infoContainer" class="featureinfo">
				<jsp:expression>RESOURCES.getString("KEY_INFO_TITEL")</jsp:expression>
				<div id="featureinfo">
					<!-- plaats voor de feature info, dynamisch en statisch-->
					<p class="todo">TODO: strip html</p>
					<c:if test="${param.coreonly==true}">
						<c:if test="${not empty kaart}">
							<!-- hiermee worden de html tags als entities edncoded, niet wat we willen
							 <c:out value="${featureinfo}" /> -->
							<jsp:expression>request.getAttribute("featureinfo")</jsp:expression>
						</c:if>
					</c:if>
				</div>
			</div>
		</div>

	</div>

	<c:if test="${param.coreonly!=true}">
		<!-- scripts als laatste laden -->
		<jsp:include page="WEB-INF/jsp/javascript_include.jsp" />
	</c:if>
	<c:if test="${param.coreonly==true}">
		<!-- scripts als laatste laden -->
		<jsp:include page="WEB-INF/jsp/javascript_coreonly_include.jsp" />
	</c:if>

</body>
	</html>
</jsp:root>