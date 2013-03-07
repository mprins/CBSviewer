<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="false" isErrorPage="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<fmt:setBundle basename="HelpLabelsBundle" />

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<title><fmt:message key="KEY_PAG_TITEL" /></title>
</head>
<body>

	<h1 class="titel">
		<fmt:message key="KEY_PAG_TITEL" />
	</h1>
	<p class="todo">Uitleg over de werking van de CBS viewer
		applicatie.</p>

	<!-- algemeen, gemeenschappelijke informatie -->
	<h2>Algemeen</h2>
	<p>In deze applicatie....</p>

	<h3>adres zoeken</h3>
	<p>Gebruik hiervoor het zoekveld bovenaan de pagina.</p>

	<h3>achtergrond kaartlaag wisselen</h3>
	<p>Met de knop "luchtfoto" of "topografie" kan de achtergrondkaart
		gewisseld worden</p>

	<h3>dataset downloaden</h3>
	<p>Mits beschikbaar, kan via de link op de pagina kan de
		thematische dataset worden gedownloaded. Niet van ieder thema is een
		download beschikbaar.</p>

	<!-- core specifiek -->
	<h2>Core client</h2>
	<p>Voor gebruikers met beperkte of geen css en javascript
		ondersteuning...</p>

	<h3>navigatie</h3>
	<p>gebruik de knoppen met de +/- en opijlen om de kaart in of uit
		te zoomen of de kaart te verschuiven.</p>


	<h3>informatie opvragen</h3>
	<p>De applicatie vraagt automatische informatie op over de
		zoeklocatie, weergegeven met een ikoontje.</p>


	<!-- ria specifiek -->
	<h2>Rich client</h2>

	<p>
		voor gebruikers met css en javascript ondersteuning, bediening kan met
		zowel een <a href="aanwijzer">aanwijzer</a> (muis of vinger op een
		aanraakscherm) als via het <a href="#toetsenbord">toetsenbord.</a>
	</p>

	<h3>afdrukken</h3>
	<p>Voor een goede afdruk dient de kaart van volledig scherm te
		worden verkleint naar een kleiner formaat. Dit zorgt ervoor dat de
		zoeklokatie op de juiste plek op de afdruk komt, zelfs bij een groot
		breedbeeldscherm. Het verkleinen van de kaart gebeurt met het knopje
		rechtsboven op de kaart.</p>

	<h3 id="toetsenbord">toetsenbord</h3>
	<p>De toetsenbord functies van de kaart worden met behulp van de
		tab toets geactiveerd. Als de kaart "actief" is heeft deze een
		uitgelichte rand.</p>

	<h4>navigatie</h4>
	<p>Met de pijltoetsen kan de kaart worden verschoven.</p>

	<h4>informatie opvragen</h4>
	<p>Door de i toets in te drukken verschijn een ikoontje op de kaart
		dat met de ppijltoetsen verschoven kan worden. Met de enter toets
		wordt informatie opgevraagd op de plaats van het ikoontje. Opnieuw de
		i toets indrukken deactiveert het informatie opvragen.</p>

	<h3 id="aanwijzer">aanwijzer</h3>
	<p>De aawijzer bediening is altijd actief.</p>

	<h4>navigatie</h4>
	<p>Door met de aanwijzer the slepen op de kaart kan de kaart worden
		verplaats. Door op de + en - knop te drukken kan er worden gezoomd.</p>

	<h4>informatie opvragen</h4>
	<p>Door met de aanwijzer op de kaart te klikken wordt informatie
		opgevraagd over het thema.</p>


	<!--jsp:include page="WEB-INF/jsp/footer_include.jsp" /-->

</body>
	</html>
</jsp:root>