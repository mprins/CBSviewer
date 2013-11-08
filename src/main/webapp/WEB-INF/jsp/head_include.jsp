<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false" />

	<!-- 
	include bestand met de header tags, 
	let op dat dit bestand vanuit de root van de webapplicatie wordt ingevoegd  
	 -->
	<jsp:text>
		<meta charset='utf-8' />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="dns-prefetch" href="http://geodata.nationaalgeoregister.nl/" />
		<link rel="dns-prefetch" href="http://geodata1.nationaalgeoregister.nl/" />
		<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<meta name="DCTERMS.type" scheme="OVERHEID.Informatietype" content="webpagina" />
		<meta name="DCTERMS.language" title="XSD.language" content="nl-NL"/>
		<meta name="DCTERMS.spatial" scheme="OVERHEID.Koninkrijksdeel" content="Nederland" />
		<meta name="DCTERMS.temporal" scheme="DCTERMS.Period" content="start=2008-03-12;" />
		<meta name="DCTERMS.format" scheme="DCTERMS.IMT" content="text/html" />
		<meta name="DCTERMS.audience" scheme="OVERHEIDsc.doelgroep" content="particulier" />
		<meta name="DCTERMS.identifier" scheme="DCTERMS.URI" content="http://www.cbs.nl/" />
		<meta name="DCTERMS.creator" scheme="OVERHEID.DienstAgentschapInstellingOfProject" content="CBS" />
		<meta name="DCTERMS.modified" title="XSD.dateTime" content="2012-09-10" />
		<meta name="DCTERMS.title" content="Documenten en publicaties - CBS.nl" />
		<meta name="OVERHEID.accessibility" scheme="OVERHEID.toegankelijkheid" content="WCAG 2.0 Conformance Level A" />
		<meta name="DCTERMS.description" content="Kaart applicatie" />
		<meta name="description" content="Kaart applicatie" />

		<link rel="schema.DC" href="http://purl.org/dc/elements/1.1/" />
		<meta name="DC.format"    scheme="DCTERMS.IMT"     content="text/html" />
		<meta name="DC.language"  scheme="DCTERMS.RFC3066" content="nl-NL" />
		<meta name="DC.creator"   scheme="OVERHEID.dienstAgentschapInstellingOfProject" content="CBS" />
		<meta name="DC.publisher" scheme="OVERHEID.dienstAgentschapInstellingOfProject" content="CBS" />

		<link rel="stylesheet" href="http://fonts.cbs.nl/cbs_vooruwbedrijf.css" type="text/css" media="all" />
		<link rel="stylesheet" href="css/no-theme/jquery-ui-1.10.3.custom.min.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/no-theme/jquery.fancybox.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/compiled.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
		<link rel="stylesheet" href="css/menu.css" type="text/css" media="all" />

		<![CDATA[
		<!--[if lte IE 7]><link rel="stylesheet" href="css/ie-lte7.css" type="text/css" media="screen" /><![endif]-->
		<!--[if IE 8]>    <link rel="stylesheet" href="css/ie-8.css" type="text/css" media="screen" />   <![endif]-->
		<!--[if lt IE 9]> <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>          <![endif]-->
		]]>

		<link rel="stylesheet" href="css/print.css" type="text/css" media="print" />
	</jsp:text>
</jsp:root>
