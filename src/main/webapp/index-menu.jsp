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

<c:if test="${param.coreonly!=true}">
	<script type="text/javascript" charset="utf-8">
		document.documentElement.className += ' js';
	</script>
</c:if>

<title>Kaart <c:out value="${param.mapname}" /></title>
</head>

<body>

		<div class="ui-layout-north">
				<div class="pageheader">
					<div class="logo">
						<a href="#">
							<!--jsp:expression>RESOURCES.getString("KEY_KAART_TITEL")</jsp:expression-->
							<img src="./img/template/hdr_logo.gif" usemap="#cbsmap" alt="CBS in uw buurt: Centraal Bureau voor de Statistiek"/>
						</a>
					</div>
					<div class="utilBlock">
						<a href="#" class="active">Home</a>
						<a href="#">Over CBS in uw buurt</a>
						<a href="#">Hoe werkt dit?</a>
						<a href="#">Veel gestelde vragen</a>
						<a href="#">Contact</a>
					</div>
				</div>
         </div>		
		<div class="ui-layout-west">
			<div class="areaSelector">
				<div class="step1 smartStep">
					<label><span>1. Meer weten over uw omgeving?</span></label>
					<form action="javascript:locate()">								
						<input type="text" id="address" size="20" value="" style="font-size:15px"/>
						<input type='submit' onclick="locate()" value="Zoek" style="overflow:hidden;display:none" />
					</form>
					<!--expression>RESOURCES.getString("KEY_ADRESZOEKEN_TITEL")</jsp:expression-->
				</div>

				<div class="secondstep">
					<div id="legendaContainer">
						<p><jsp:expression>RESOURCES.getString("KEY_LEGENDA_TITEL")</jsp:expression></p>
						<div id="legenda" class="legenda">
							<!-- plaats voor de legenda, dynamisch en statisch -->
							<c:if test="${param.coreonly==true}">
								<c:if test="${not empty legendas}">
									<c:forEach items="${legendas}" varStatus="legenda">
										<img src="${dir}/${legendas[legenda.index].name}"
											alt="legenda item" />
									</c:forEach>
								</c:if>
							</c:if>
						</div>
					</div>
					<div id="infoContainer" class="featureinfo">
						<p><jsp:expression>RESOURCES.getString("KEY_INFO_TITEL")</jsp:expression></p>
						<div id="featureinfo">
							<!-- plaats voor de feature info, dynamisch en statisch-->
							<c:if test="${param.coreonly==true}">
								<c:if test="${not empty featureinfo}">
									<!-- hiermee worden de html tags als entities edncoded, niet wat we willen
									 <c:out value="${featureinfo}" /> -->
									<!--<jsp:expression>request.getAttribute("featureinfo")</jsp:expression>-->
									<c:out value="${featureinfo}" escapeXml="false" />
								</c:if>
							</c:if>
						</div>			
					</div>
				</div>				
			</div>
		</div>
		<div class="ui-layout-center" style="background-color:#EEEEEE">
			<!--div class="article"-->
				<div id="coreContainer" class="kaartContainer">
					<!-- hier komt de statische kaart -->
					<jsp:include page="kaart">
						<!-- TODO: mapname waarde moet uit de request komen bijv. ?mapname=cbs_inwoners_2000_per_hectare -->
						<!-- StringConstants.REQ_PARAM_MAPNAME -->
						<jsp:param name="mapname" value="cbs_inwoners_2000_per_hectare" />
					</jsp:include>

					<c:if test="${not empty kaart}">
						<!-- StringConstants.MAP_CACHE_DIR -->
						<img id="coreMapImage" src="${dir}/${kaart.name}"
							alt="kaart voor thema: ${param.mapname}" width="440px"
							height="440px" />
						<!-- navigatie knoppen zonder javascript -->
						<jsp:include page="WEB-INF/jsp/core_nav_buttons_include.jsp" />
					</c:if>
				</div>
				
				<div id="kaartContainer" class="kaartContainer">
					<div id="cbsKaart" class="kaart">
						<!-- hier wordt de dynamische kaart ingehangen -->
					</div>
				</div>	
			<!--/div-->
		</div>
		<div class="ui-layout-south">
			<div class="teaserPanel">
				<div class="teaserContent">
					<a id="_teasersControl__linkOpMaatHyperLink" class="opMaat" title="Uw Gemeente Op Maat" style="cursor: pointer; ">Uw Gemeente Op Maat<span>Publicaties &amp; Documenten</span></a>
					<a href="#" title="CBS In uw buurt nieuws" class="rss">CBS In uw buurt nieuws<span>De laatste ontwikkelingen</span></a>
					<a href="#" title="CBS Databank - Statline" class="databank">CBS Databank - Statline<span>Professionele data nodig?</span></a>
					<a href="#" title="Gebruikersreacties gezocht" class="gezocht"><strong>Gezocht:</strong> Gebruikersreacties<span>Heeft u tips of suggesties?</span></a>
				</div>
			</div>		
			<div class="footer">
				<div id="_footerPanel">
					<jsp:expression>RESOURCES.getString("KEY_COPYRIGHT")</jsp:expression>
					<a href="#">Doorsturen</a>
					<a href="#">Disclaimer</a>
					<a href="#">Privacyverklaring</a>
					<a href="#">Sitemap</a>
					<a href="#" class="last">RSS</a> 
				</div>
            </div>			
		</div>	

		<jsp:include page="WEB-INF/jsp/main_menu_include.jsp" />

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