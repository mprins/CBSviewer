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

	<div class="dropDownMenu clearfix">
	<!--a id="skipNavigation"></a-->
	<ul class="siteNavigation">
		<li class="sectionDepartment">
			<a class="hasMenu" href="#">Selecteer een CBS kaartlaag</a>
			<div class="navDropDown"> 
				<ol class="navCategories">
					<li>
						<a href="#">Op thema<span>Naast de basisthema's is er ook de mogelijkheid om meer thema's te bekijken. Klik hiervoor onderin het menu op 'Meer thema's...'</span></a>
							<div class="contentasset">
								<div class="megaMenu megaThreeColumns">
										<div class="ac-container ac-menu">			
											<div>
												<input id="ac-3" name="accordion-1" type="radio" checked="checked" />
												<label for="ac-3">.. terug naar de basis thema's</label>
												<div class="ac-menuheight">
														<ul class="navleft">
																<li class="menuTitle">Bevolking</li>	
																<li><a href="#" name="vierkanten500m_oad2008">Inwoners totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>100m vierkant<br/><a href="#">2012</a> | <a href="#">2011</a> | <a href="#">2010</a><br/><a href="#">2009</a> | <a href="#">2008</a> | <a href="#">2007</a><br/><a href="#">2006</a> | <a href="#">2005</a> | <a href="#">2004</a><br/><a href="#">2003</a> | <a href="#">2002</a> | <a href="#">2001</a><br/><a href="#">2000</a></li>
																		<li>500m vierkant<br/><a href="#">2012</a> | <a href="#">2011</a> | <a href="#">2010</a><br/><a href="#">2009</a> | <a href="#">2008</a> | <a href="#">2007</a><br/><a href="#">2006</a> | <a href="#">2005</a> | <a href="#">2004</a><br/><a href="#">2003</a> | <a href="#">2002</a> | <a href="#">2001</a><br/><a href="#">2000</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a> | <a href="#">2006</a></li>
																	</ul>
																</li>
																<li><a href="#" name="wijkbuurt2010auto">Inwoners 0 tot 15 jaar<span>Dit is de langere tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																<li><a href="#" name="vierkanten500m_stedelijkheid2008">Inwoners 0 tot 20 jaar<span>Dit is de langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste tooltip</span></a>
																	<ul>
																		<li>100m vierkant<br/><a href="#">2011</a><span class="redcolor">*</span></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	
																<li><a href="#">Inwoners 15 tot 25 jaar<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																<li><a href="#">Inwoners 25 tot 45 jaar<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>100m vierkant<br/><a href="#">2011</a><span class="redcolor">*</span></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	
																<li><a href="#">Inwoners 45 tot 65 jaar<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>100m vierkant<br/><a href="#">2011</a></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	
																<li><a href="#">Inwoners 65 jaar en ouder<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>100m vierkant<br/><a href="#">2011</a></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	
																<li><a href="#">Bevolkingsdichtheid<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>100m vierkant<br/><a href="#">2011</a><span class="redcolor">*</span></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	
																<li><a href="#">Verandering inwonertal 2000-2010<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>100m vierkant<br/><a href="#">2011</a></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>

																<li class="menuTitle">Huishoudens</li>	
																<li><a href="#">Eenpersoonshuishoudens<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Huishoudens zonder kinderen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Huishoudens met kinderen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Herkomst</li>	
																<li><a href="#">Autochtonen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Niet-westerse allochtonen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Westerse allochtonen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
														</ul>
														<ul class="navleft">
																<li class="menuTitle">Inkomen</li>	
																<li><a href="#">Aantal inkomensontvangers<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Inkomen per ontvanger<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Inwoners met laag inkomen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Inwoners met hoog inkomen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Huishoudens met laag inkomen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>											
																<li><a href="#">Huishoudens met hoog inkomen (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>											
																<li><a href="#">Huishoudens rond of onder sociaal minimum (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Wonen</li>	
																<li><a href="#">Woningen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		
																<li><a href="#">Woning WOZ-waarde<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		

																<li class="menuTitle">Bedrijven</li>	
																<li><a href="#">Agrarische bedrijven<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		
																<li><a href="#">Industrie (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Commerciele dienstverlening (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>												
																<li><a href="#">Niet-commerciele dienstverlening (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																
															<!--/ul-->
														</ul>
														<ul class="navright">
															<!--ul class="navright"-->
																<li class="menuTitle"><i>Voorzieningen</i><br/>Kortste afstand</li>
																<li><a href="#">Huisartsenpraktijk<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Huisartsenpost<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Ziekenhuis, excl. buitenpolikliniek<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Kinderdagverblijf<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Buitenschoolse opvang<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Basisonderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">VMBO onderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">HAVO/VWO onderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Grote supermarkt<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																	<li><a href="#">Ov. dagelijkse levensmiddelen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Stedelijkheid</li>
																<li><a href="#">Omgevingsadressendichtheid<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
														</ul>													
												</div>
											</div>
											<div>
												<input id="ac-4" name="accordion-1" type="radio" />
												<label id="highlightmore" for="ac-4">Klik voor meer thema's ...</label>
												<div class="ac-menuheight">
														<ul class="navleft">
																<li class="menuTitle">Bevolking</li>	
																<li><a href="#">Inwoners 0 tot 20 jaar<span>Dit is de tooltip</span></a></li>
																<li><a href="#">Inwoners 20 tot 45 jaar<span>Dit is de langere tooltip</span></a></li>	
																<li><a href="#">Binnenlandse migratie<span>Dit is de langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste langste tooltip</span></a></li>	
																<li><a href="#">Mannen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																<li><a href="#">Vrouwen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>100m vierkant<br/><a href="#">2011</a><span class="redcolor">*</span></li>
																		<li>500m vierkant<br/><a href="#">2011</a></li>
																		<li>Bevolkingskern<br/><a href="#">2008</a></li>
																	</ul>
																</li>	

																<li class="menuTitle">Huishouden</li>	
																<li><a href="#">Aantal particuliere huishoudens<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a><span class="redcolor">*</span> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Ongehuwd (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Gehuwd (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Gescheiden (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Gemiddelde huishoudensgrootte (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Inkomen</li>	
																<li><a href="#">Inkomen per inwoner<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Niet actieven<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Sociale zekerheid</li>	
																<li><a href="#">Arbeids ongeschiktheid<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Uitkeringen werkloosheid<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
														</ul>
														<ul class="navleft">
																<li class="menuTitle">Wonen</li>	
																<li><a href="#">Huurwoning (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Koopwoning (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Bouwjaarklasse tot 2000 (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Bouwjaarklasse vanaf 2000 (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Wooneenheden<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>											
																<li><a href="#">Recreatiewoningen<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																
																<li class="menuTitle">Energie</li>	
																<li><a href="#">Gemiddeld gasverbruik totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		
																<li><a href="#">Stadsverwarming (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																<li><a href="#">Gemiddeld elektriciteitsverbruik totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>																		

																<li class="menuTitle">Motorvoertuigen</li>	
																<li><a href="#">Personenauto's totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		
																<li><a href="#">Personenauto's per huishoudens<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Bedrijfsmotorvoertuigen totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>												
																<li><a href="#">Motortweewielers totaal<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>	
																
																<li class="menuTitle">Oppervlakte</li>	
																<li><a href="#">Oppervlakte land in ha<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>		
																<li><a href="#">Oppervlakte water in ha<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
															<!--/ul-->
														</ul>
														<ul class="navright">
															<!--ul class="navright"-->
																<li class="menuTitle">Bedrijven</li>
																<li><a href="#">Gewassenbedrijven (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Veeteeltbedrijven (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Combinatiebedrijven (%)<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle"><i>Voorzieningen</i><br/>Kortste afstand</li>
																<li><a href="#">Restaurant<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Bibliotheek<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Zwembad<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Bioscoop<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Treinstation<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Aantal binnen 3 kilometer</li>
																<li><a href="#">Huisartsenpraktijk<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Kinderdagverblijf<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Basisonderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">Grote supermarkt<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																
																<li class="menuTitle">Aantal binnen 5 kilometer</li>
																<li><a href="#">VMBO onderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
																<li><a href="#">HAVO/VWO onderwijs<span>Dit is de tooltip</span></a>
																	<ul>
																		<li>Gemeente<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Wijk<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																		<li>Buurt<br/><a href="#">2011</a> | <a href="#">2010</a> | <a href="#">2009</a></li>
																	</ul>
																</li>
														</ul>
												</div>
											</div>
										</div>
								</div>
							</div>
					</li>			
					<li><a href="#">Op jaar<span>Selecteer een kaartlaag op jaar</span></a>
						 <div class="contentasset">
							<div class="megaMenu megaThreeColumns">
								<ul>
									<li class="menuTitle">2012</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2011</li>
									<li><a href="#">Gemeente / Wijk / Buurt<span>Dit is de tooltip</span></a></li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2010</li>
									<li><a href="#">Gemeente / Wijk / Buurt<span>Dit is de tooltip</span></a></li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2009</li>
									<li><a href="#">Gemeente / Wijk / Buurt<span>Dit is de tooltip</span></a></li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
								</ul>
								<ul>
									
									
									<li class="menuTitle">2008</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">Bevolkingskern<span>Dit is de tooltip</span></a></li>
									<li><a href="#">Bodemgebruik<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">2007</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2006</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">Bodemgebruik<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2005</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">2004</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
								</ul>
								<ul>
									<li class="menuTitle">2003</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">2002</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">2001</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">Bevolkingskern<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">2000</li>
									<li><a href="#">100m vierkant<span>Dit is de tooltip</span></a></li>
									<li><a href="#">500m vierkant<span>Dit is de tooltip</span></a></li>	
								</ul>
							</div>
						</div>
					</li>
					<li>
						<a href="#">Op kaartlaag<span>Selecteer een kaartlaag</span></a>
						<div class="contentasset">
							<div class="megaMenu megaFourColumns">
								<ul>										
									<li class="menuTitle"><p><img src="img/template/bodemgebruik.png" alt="Bodemgebruik"/></p>Bodemgebruik</li>
									<li><a href="#">2006<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2008<span>Dit is de tooltip</span></a></li>
								</ul>
								<ul>										
									<li class="menuTitle"><p><img src="img/template/bevolkingskernen.png" alt="Bevolkingskernen"/></p>Bevolkingskernen</li>
									<li><a href="#">2001<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2008<span>Dit is de tooltip</span></a></li>									
								</ul>
								<ul>									
									<li class="menuTitle"><p><img src="img/template/vierkanten.png" alt="Vierkanten"/></p>Vierkanten 100m</li>
									<li><a href="#">2000<span>Dit is de tooltip</span></a> | <a href="#">2007<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2001<span>Dit is de tooltip</span></a> | <a href="#">2008<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2002<span>Dit is de tooltip</span></a> | <a href="#">2009<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2003<span>Dit is de tooltip</span></a> | <a href="#">2010<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2004<span>Dit is de tooltip</span></a> | <a href="#">2011<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2005<span>Dit is de tooltip</span></a> | <a href="#">2012<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2006<span>Dit is de tooltip</span></a></li>
									
									<li class="menuTitle">Vierkanten 500m</li>
									<li><a href="#">2000<span>Dit is de tooltip</span></a> | <a href="#">2007<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2001<span>Dit is de tooltip</span></a> |  <a href="#">2008<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2002<span>Dit is de tooltip</span></a> | <a href="#">2009<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2003<span>Dit is de tooltip</span></a> | <a href="#">2010<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2004<span>Dit is de tooltip</span></a> | <a href="#">2011<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2005<span>Dit is de tooltip</span></a> | <a href="#">2012<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2006<span>Dit is de tooltip</span></a></li>
									
								</ul>
								<ul>									
									<li class="menuTitle"><p><img src="img/template/wijkenbuurten.png" alt="Wijken en buurten"/></p>Buurten</li>
									<li><a href="#">2009<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2010<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2011<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">Wijken</li>
									<li><a href="#">2009<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2010<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2011<span>Dit is de tooltip</span></a></li>

									<li class="menuTitle">Gemeenten</li>
									<li><a href="#">2009<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2010<span>Dit is de tooltip</span></a></li>
									<li><a href="#">2011<span>Dit is de tooltip</span></a></li>									
								</ul>
							</div>
						</div>
					</li>
					<li id="infobox"></li>  
				</ol>
			</div>
		</li>
	</ul>
</div>		

</jsp:root>