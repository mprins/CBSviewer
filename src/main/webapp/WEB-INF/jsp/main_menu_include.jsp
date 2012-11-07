<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		import="nl.mineleni.cbsviewer.util.LabelsBundle, nl.mineleni.cbsviewer.util.StringConstants"
		trimDirectiveWhitespaces="true" language="java" isThreadSafe="false"
		isErrorPage="false" />

	<jsp:scriptlet>LabelsBundle RESOURCES = new LabelsBundle();</jsp:scriptlet>

	<!-- menu dat alleen css gebruikt, de onderdelen die via javascript werken nog een coreonly voor plaatsen, tevels Excel module afronden en localiseren -->
	<div class="dropDownMenu clearfix">
	<a id="skipNavigation"></a>
	<ul class="siteNavigation">
		<li class="sectionDepartment">
			<a class="hasMenu" href="#">Selecteer een CBS kaartlaag</a>
			<div class="navDropDown"> 
				<ol class="navCategories">
					<li>
						<a href="#">Op thema</a>
							<div class="contentasset">
								<div class="megaMenu megaFourColumns">
									<ul>
										<ul id="navleft">
											<li class="menuTitle">Bevolking</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('De bevolking van Nederland op 1 januari.')">Aantal inwoners</a>
												<ul>
													<li></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2012</a> | <a href="#">2011</a> | <a href="#">2010</a><br/><a href="#">2009</a> | <a href="#">2008</a> | <a href="#">2007</a><br/><a href="#">2006</a> | <a href="#">2005</a> | <a href="#">2004</a><br/><a href="#">2003</a> | <a href="#">2002</a> | <a href="#">2001</a><br/><a href="#">2000</a></li>
													<li>500m vierkant<br/><a href="#">2012</a> | <a href="#">2011</a> | <a href="#">2010</a><br/><a href="#">2009</a> | <a href="#">2008</a> | <a href="#">2007</a><br/><a href="#">2006</a> | <a href="#">2005</a> | <a href="#">2004</a><br/><a href="#">2003</a> | <a href="#">2002</a> | <a href="#">2001</a><br/><a href="#">2000</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a> | <a href="#">2006</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 0 tot 15 jaar.')">Personen van 0 tot 15 jaar</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 0 tot 20 jaar.')">Personen van 0 tot 20 jaar</a>
												<ul>
													<li>100m vierkant<br/><a href="#">2011</a><font color="red">*</font></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 15 tot 25 jaar.')">Personen van 15 tot 25 jaar</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 20 tot 45 jaar.')">Personen van 20 tot 45 jaar</a>
												<ul>
													<li>100m vierkant<br/><a href="#">2011</a><font color="red">*</font></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 25 tot 45 jaar.')">Personen van 25 tot 45 jaar</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2011</a></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 45 tot 65 jaar.')">Personen van 45 tot 65 jaar</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2011</a></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Het percentage personen van 65 jaar en ouder.')">Personen van 65 jaar en ouder</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2011</a><font color="red">*</font></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Bevolkingsdichtheid uitleg')">Bevolkingsdichtheid</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2011</a></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Verandering inwonertal uitleg.')">Verandering inwonertal 2000-2010</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>100m vierkant<br/><a href="#">2011</a></li>
													<li>500m vierkant<br/><a href="#">2011</a></li>
													<li>Bevolkingskern<br/><a href="#">2008</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Geboorte.')">Geboorte</a>
												<ul>
													<li>?<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Sterfte.')">Sterfte</a>
												<ul>
													<li>?<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>

											<li class="menuTitle">Huishoudens</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Aantal particuliere huishoudens uitleg.')">Aantal particuliere huishoudens</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Eenpersoonshuishoudens uitleg.')">Eenpersoonshuishoudens</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huishoudens zonder kinderen uitleg.')">Huishoudens zonder kinderen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huishoudens met kinderen uitleg.')">Huishoudens met kinderen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
										</ul>
									</ul>
									<ul id="toplevel">
										<ul id="navleft">
											<li class="menuTitle">Wonen</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Woningen uitleg.')">Woningen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Woning WOZ-waarde uitleg.')">Woning WOZ-waarde</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huurwoning uitleg.')">Huurwoning</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Koopwoning uitleg.')">Koopwoning</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											
											<li class="menuTitle">Inkomens</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Aantal inkomensontvangers uitleg.')">Aantal inkomensontvangers</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Inkomen per ontvanger uitleg.')">Inkomen per ontvanger</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Inkomen per inwoners uitleg.')">Inkomen per inwoners</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Personen met laag inkomen uitleg.')">Personen met laag inkomen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Personen met hoog inkomen uitleg.')">Personen met hoog inkomen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Niet actieven uitleg.')">Niet actieven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huishoudens met laag inkomen uitleg.')">Huishoudens met laag inkomen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huishoudens met hoog inkomen uitleg.')">Huishoudens met hoog inkomen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huishoudens rond of onder sociaal minimum uitleg.')">Huishoudens rond of onder sociaal minimum</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('AOW uitleg.')">AOW</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('WW uitleg.')">WW</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>	

											<li class="menuTitle">Arbeid</li>	
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('?? uitleg.')">??</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('?? uitleg.')">??</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>		
										</ul>
									</ul>
									<ul>
										<ul id="navright">
											<li class="menuTitle">Bedrijven</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Agrarische bedrijven uitleg.')">Agrarische bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Gewassenbedrijven uitleg.')">Gewassenbedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Veeteeltbedrijven uitleg.')">Veeteeltbedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Industrie uitleg.')">Industrie</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Commerciele dienstverlening uitleg.')">Commerciele dienstverlening</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Niet-commerciele dienstverlening uitleg.')">Niet-commerciele dienstverlening</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											
											<li class="menuTitle">Stedelijkheid</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Omgevingsadressendichtheid uitleg.')">Omgevingsadressendichtheid bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>	

											<li class="menuTitle"><i>Nabijheid</i></li>
											<li class="menuTitle">Kortste afstand</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huisartsenpraktijk uitleg.')">Huisartsenpraktijk bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huisartsenpost uitleg.')">Huisartsenpost bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Ziekenhuis, excl. buitenpolikliniek uitleg.')">Ziekenhuis, excl. buitenpolikliniek bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Kinderdagverblijf uitleg.')">Kinderdagverblijf bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Buitenschoolse opvang uitleg.')">Buitenschoolse opvang bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Basisonderwijs uitleg.')">Basisonderwijs bedrijven</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>			
										</ul>
									</ul>
									<ul>
										<ul id="navright">
											<li class="menuTitle"></li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('VMBO onderwijs uitleg.')">VMBO onderwijs</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('HAVO/VWO onderwijs uitleg.')">HAVO/VWO onderwijs</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Grote supermarkt uitleg.')">Grote supermarkt</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Ov. dagelijkse levensmiddelen uitleg.')">Ov. dagelijkse levensmiddelen</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Restaurant uitleg.')">Restaurant</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Bibliotheek uitleg.')">Bibliotheek</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Zwembad uitleg.')">Zwembad</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Bioscoop uitleg.')">Bioscoop</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Treinstation uitleg.')">Treinstation</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>

											<li class="menuTitle">Aantal binnen 3 kilometer</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Huisartsenpraktijk uitleg.')">Huisartsenpraktijk</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Kinderdagverblijf uitleg.')">Kinderdagverblijf</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Basisonderwijs uitleg.')">Basisonderwijs</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Grote supermarkt uitleg.')">Grote supermarkt</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											
											<li class="menuTitle">Aantal binnen 5 kilometer</li>			
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('VMBO onderwijs uitleg.')">VMBO onderwijs</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
											<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('HAVO/VWO onderwijs uitleg.')">HAVO/VWO onderwijs</a>
												<ul>
													<li>Gemeente<br/><a href="#">2011</a><font color="red">*</font> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
													<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
												</ul>
											</li>
										</ul>
									</ul>
								</div>
							</div>
					</li>			
					<li><a href="#">Op jaar</a>
						 <div class="contentasset">
							<div class="megaMenu megaFourColumns">
								<ul>
									<li class="menuTitle">2012</li>
									<li><a href="#" class="tooltip" onmouseOut="wijzigTerug()" onmouseOver="wijzig('- Aantal inwoners: Ja')">100m vierkant</a></li>
									<li><a href="#" class="tooltip" onmouseOut="wijzigTerug()" onmouseOver="wijzig('- Aantal inwoners: Ja')">500m vierkant</a></li>
									
									<li class="menuTitle">2011</li>
									<li><a href="#" class="tooltip" onmouseOut="wijzigTerug()" onmouseOver="wijzig('Even kijken hoe dit op te lossen')">Gemeente</a></li>
									<li><a href="#">Wijk</a></li>
									<li><a href="#">Buurt</a></li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
									
									<li class="menuTitle">2010</li>
									<li><a href="#">Gemeente</a></li>
									<li><a href="#">Wijk</a></li>
									<li><a href="#">Buurt</a></li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
								</ul>
								<ul>
									<li class="menuTitle">2009</li>
									<li><a href="#">Gemeente</a></li>
									<li><a href="#">Wijk</a></li>
									<li><a href="#">Buurt</a></li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
									
									<li class="menuTitle">2008</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
									<li><a href="#">Bevolkingskern</a></li>
									<li><a href="#">Bodemgebruik</a></li>

									<li class="menuTitle">2007</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
								</ul>
								<ul>
									<li class="menuTitle">2006</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
									<li><a href="#">bodemgebruik</a></li>
									
									<li class="menuTitle">2005</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>

									<li class="menuTitle">2004</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>

									<li class="menuTitle">2003</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
								</ul>
								<ul>
									<li class="menuTitle">2002</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>

									<li class="menuTitle">2001</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>
									<li><a href="#">Bevolkingskern</a></li>
									
									<li class="menuTitle">2000</li>
									<li><a href="#">100m vierkant</a></li>
									<li><a href="#">500m vierkant</a></li>	
								</ul>
							</div>
						</div>
					</li>
					<li>
						<a href="#">Op kaartlaag</a>
						<div class="contentasset">
							<div class="megaMenu megaFourColumns">
								<ul>	
									<img src="img/template/bodemgebruik.png"/>
									<li class="menuTitle">Bodemgebruik</li>
									<li><a href="#">2006</a></li>
									<li><a href="#">2008</a></li>
								</ul>
								<ul>	
									<img src="img/template/bevolkingskernen.png"/>
									<li class="menuTitle">Bevolkingskernen</li>
									<li><a href="#">2001</a></li>
									<li><a href="#">2008</a></li>
									
								</ul>
								<ul>
									<img src="img/template/vierkanten.png"/>
									<li class="menuTitle">Vierkanten 100m</li>
									<li><a href="#">2000</a> | <a href="#">2007</a></li>
									<li><a href="#">2001</a> | <a href="#">2008</a></li>
									<li><a href="#">2002</a> | <a href="#">2009</a></li>
									<li><a href="#">2003</a> | <a href="#">2010</a></li>
									<li><a href="#">2004</a> | <a href="#">2011</a></li>
									<li><a href="#">2005</a> | <a href="#">2012</a></li>
									<li><a href="#">2006</a></li>
									
									<li class="menuTitle">Vierkanten 500m</li>
									<li><a href="#">2000</a> | <a href="#">2007</a></li>
									<li><a href="#">2001</a> |  <a href="#">2008</a></li>
									<li><a href="#">2002</a> | <a href="#">2009</a></li>
									<li><a href="#">2003</a> | <a href="#">2010</a></li>
									<li><a href="#">2004</a> | <a href="#">2011</a></li>
									<li><a href="#">2005</a> | <a href="#">2012</a></li>
									<li><a href="#">2006</a></li>
									
								</ul>
								<ul>
									<img src="img/template/wijkenbuurten.png"/>
									<li class="menuTitle">Buurten</li>
									<li><a href="#">2009</a></li>
									<li><a href="#">2010</a></li>
									
									<ul id="navright">
										<li class="menuTitle">Buurten</li>
										<li><a href="#">2009</a></li>
										<li><a href="#" onmouseOut="wijzigTerug()" onmouseOver="wijzig('2010 uitleg.')">2010</a>
											<ul>
												<li><a href="#">Omgevingsadressendichtheid</a></li>
												<li><a href="#">Personen 0 tot 15 jaar (%)</a></li>
												<li><a href="#">Personen 15 tot 25 jaar (%)</a></li>
												<li><a href="#">Personen 25 tot 45 jaar (%)</a></li>
												<li><a href="#">Personen 45 tot 65 jaar (%)</a></li>
												<li><a href="#">Personen 65 jaar en ouder (%)</a></li>
												<li><a href="#">Bevolkingsdichtheid inwoners per km2</a></li>
												<li><a href="#">Aantal huishoudens</a></li>
												<li><a href="#">Eenpersoonshuishoudens (%)</a></li>
												<li><a href="#">Huishoudens zonder kinderen (%)</a></li>
												<li><a href="#">Huishoudens met kinderen (%)</a></li>
												<li><a href="#">Westerse allochtonen (%)</a></li>
												<li><a href="#">Niet westerse allochtonen (%)</a></li>
												<li><a href="#">Woningvoorraad</a></li>
												<li><a href="#">Gemiddelde woningwaarde</a></li>
												<li><a href="#">Koopwoningen (%)</a></li>
												<li><a href="#">Huurwoningen (%)</a></li>
												<li><a href="#">Aantal agrarische bedrijven</a></li>
												<li><a href="#">Gewassenbedrijven (%)</a></li>
												<li><a href="#">Veeteeltbedrijven (%)</a></li>
												<li><a href="#">Combinatiebedrijven (%)</a></li>
												<li><a href="#">Huisartsenpraktijk gemiddelde afstand in km</a></li>
												<li><a href="#">Huisartsenpraktijk aantal binnen 3 km</a></li>
												<li><a href="#">Ziekenhuis excl buitenpolikliniek gem afst in km</a></li>
												<li><a href="#">Kinderdagverblijf gemiddelde afstand in km</a></li>
												<li><a href="#">Kinderdagverblijf aantal binnen 3 km</a></li>
												<li><a href="#">Havo vwo gemiddelde afstand in km</a></li>
												<li><a href="#">Havo vwo aantal binnen 5 km</a></li>
												<li><a href="#">Vmbo gemiddelde afstand in km</a></li>
												<li><a href="#">Vmbo aantal binnen 5 km</a></li>
												<li><a href="#">Grote supermarkt gemiddelde afstand in km</a></li>
												<li><a href="#">Grote supermarkt aantal binnen 3 km</a></li>
												<li><a href="#">Restaurant gemiddelde afstand in km</a></li>
												<li><a href="#">Restaurant aantal binnen 3 km</a></li>
												<li><a href="#">Zwembad gemiddelde afstand in km</a></li>
												<li><a href="#">Bioscoop gemiddelde afstand in km</a></li>
												<li><a href="#">Treinstation gemiddelde afstand in km</a></li>
											</ul>
										</li>
										<li><a href="#">2011</a></li>

										<li class="menuTitle">Wijken</li>
										<li><a href="#">2009</a></li>
										<li><a href="#">2010</a></li>
										<li><a href="#">2011</a></li>

										<li class="menuTitle">Gemeenten</li>
										<li><a href="#">2009</a></li>
										<li><a href="#">2010</a></li>
										<li><a href="#">2011</a></li>										
									</ul>
								</ul>
							</div>
						</div>
					</li>
					<div id="infobox" class="info">Beweeg met de muis over een item voor meer informatie. <br/><br/>Klik op de hoofdgroep om de standaardlaag te laden. Deze is aangegeven met een sterretje (<font color="red">*</font>)</div>  
				</ol>
			</div>
		</li>
	</ul>
</div>		

</jsp:root>