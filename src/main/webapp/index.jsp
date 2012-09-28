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
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<script type="text/javascript">
	document.documentElement.className += ' js';
</script>

<title>Kaart</title>
</head>

<body>

	<div id="wrapper" class="wrapper">

		<div id="kop" class="kop">
			<jsp:expression>RESOURCES.getString("KEY_KAART_TITEL")</jsp:expression>
		</div>


		<div id="kaarten" class="kaarten">
			<div id="coreContainer" class="kaartContainer">
				<!-- hier komt evt de statische kaart -->
			</div>

			<div id="kaartContainer" class="kaartContainer hidden">
				<div id="cbsKaart" class="kaart">
					<!-- hier wordt de dynamische kaart ingehangen -->
				</div>
			</div>
		</div>


		<div id="sidebar" class="sidebar">

			<div id="zoekenContainer" class="zoeken">
				<jsp:expression>RESOURCES.getString("KEY_ADRESZOEKEN_TITEL")</jsp:expression>
				<!-- adres zoeken -->
			</div>

			<div id="legendaContainer" class="legenda">
				<jsp:expression>RESOURCES.getString("KEY_LEGENDA_TITEL")</jsp:expression>
				<div id="legenda">
					<!-- plaats voor de legenda -->
				</div>
			</div>

			<div id="infoContainer" class="featureinfo">
				<jsp:expression>RESOURCES.getString("KEY_INFO_TITEL")</jsp:expression>
				<div id="featureinfo">
					<!-- plaats voor de feature info -->
				</div>
			</div>
		</div>

	</div>

	<!-- scripts als laatste laden -->
	<jsp:include page="WEB-INF/jsp/javascript_include.jsp" />
</body>
	</html>
</jsp:root>