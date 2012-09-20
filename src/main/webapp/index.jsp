<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="nl.mineleni.cbsviewer.util.LabelsBundle" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<jsp:scriptlet>LabelsBundle RESOURCES = new LabelsBundle();</jsp:scriptlet>
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Language" content="nl-NL" />
<link rel="schema.DCTERMS" href="http://purl.org/dc/terms/" />
<meta name="DCTERMS.type" scheme="OVERHEID.Informatietype"
	content="webpagina" />
<meta name="DCTERMS.language" scheme="DCTERMS.RFC4646" content="nl-NL" />
<meta name="DCTERMS.spatial" scheme="OVERHEID.Koninkrijksdeel"
	content="Nederland" />
<meta name="DCTERMS.temporal" scheme="DCTERMS.Period"
	content="start=2008-03-12;" />
<meta name="DCTERMS.format" scheme="DCTERMS.IMT" content="text/html" />
<meta name="DCTERMS.audience" scheme="OVERHEIDsc.doelgroep"
	content="particulier" />
<meta name="DCTERMS.identifier" scheme="DCTERMS.URI"
	content="http://www.rijksoverheid.nl/" />
<meta name="DCTERMS.modified" content="2012-09-10" />
<meta name="DCTERMS.title"
	content="Documenten en publicaties - Rijksoverheid.nl" />
<meta name="DCTERMS.creator"
	scheme="OVERHEID.DienstAgentschapInstellingOfProject" content="CBS" />
<meta name="DCTERMS.description" content="CBS Kaart applicatie " />

<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/print.css" type="text/css"
	media="print" />
<!--[if lte IE 7]>
		<link rel="stylesheet" href="static/css/ie.css" type="text/css" media="all" />
<![endif]-->
<!--[if gte IE 8]>
		<link rel="stylesheet" href="static/css/ie-8.css" type="text/css" media="all" />
<![endif]-->

<script type="text/javascript">
	document.documentElement.className += ' js';
</script>

<title>Kaart</title>
</head>
<body>

	<jsp:expression>RESOURCES.getString("KEY_KAART_TITEL")</jsp:expression>

	<div id="viewer" class="start">

		<div id="coreContainer">
			<!-- hier komt de statische kaart -->
		</div>

		<div id="kaartContainer" class="hidden">
			<div id="cbsKaart" class="kaart">
				<!-- hier wordt de kaart ingehangen -->
			</div>
		</div>

		<div id="zoekenContainer" class="zoeken">
			<!-- adres zoeken -->
		</div>

		<div id="legendaContainer" class="legenda">
			<!-- plaats voor de legenda -->
		</div>

	</div>

	<!-- scripts als laatste laden -->
	<jsp:include page="WEB-INF/jsp/javascript.jsp" />
</body>
	</html>
</jsp:root>