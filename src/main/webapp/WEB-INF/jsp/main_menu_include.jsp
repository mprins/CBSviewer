<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		trimDirectiveWhitespaces="false" language="java" isThreadSafe="false"
		isErrorPage="false" />

	<fmt:setBundle basename="LabelsBundle" />

	<div class="dropDownMenu">
	<!--a id="skipNavigation"></a-->
	<ul class="siteNavigation">
		<li id="thememenu" class="sectionTheme">
			<a href="#thememenu" id="hasMenu">Selecteer een CBS kaartlaag</a>
			<div class="navDropDown"> 				
				<ol class="navCategories">					
					<li id="keymenu">
						<a href="#keymenu">Op thema<span>Naast de basisthema's is er ook de mogelijkheid om meer thema's te bekijken. Klik hiervoor onderin het menu op 'Meer thema's...'</span></a>
						<div class="contentasset">
							<div class="megaMenu megaThreeColumns">															
								<ul class="menuAccordion">			
									<li id="keytheme1">
										<a href="#keytheme1" class="accordionheader">...terug naar de basis thema's<span>Ga terug naar de meest geraadpleegde thema's</span></a>
										<div class="menuAccordionContent">
											<ul class="navleft">
													<li class="menuTitle">Bevolking</li>	
													<li>
													<a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_inwoners">Inwoners totaal<span>Aantal inwoners</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_inwoners">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_aantal_inwoners">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_aantal_inwoners">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_aantal_inwoners">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_aantal_inwoners">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_aantal_inwoners">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_aantal_inwoners">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_aantal_inwoners">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_aantal_inwoners">2009</a></li>
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_inwoners_2012">2012</a> | <a href="#" name="vierkanten100m_inwoners_2011">2011</a> | <a href="#" name="vierkanten100m_inwoners_2010">2010</a><br/><a href="#" name="vierkanten100m_inwoners_2009">2009</a> | <a href="#" name="vierkanten100m_inwoners_2008">2008</a> | <a href="#" name="vierkanten100m_inwoners_2007">2007</a><br/><a href="#" name="vierkanten100m_inwoners_2006">2006</a> | <a href="#" name="vierkanten100m_inwoners_2005">2005</a> | <a href="#" name="vierkanten100m_inwoners_2004">2004</a><br/><a href="#" name="vierkanten100m_inwoners_2003">2003</a> | <a href="#" name="vierkanten100m_inwoners_2002">2002</a> | <a href="#" name="vierkanten100m_inwoners_2001">2001</a><br/><a href="#" name="vierkanten100m_inwoners_2000">2000</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_inwoners_2012">2012</a> | <a href="#" name="vierkanten500m_inwoners_2011">2011</a> | <a href="#" name="vierkanten500m_inwoners_2010">2010</a><br/><a href="#" name="vierkanten500m_inwoners_2009">2009</a> | <a href="#" name="vierkanten500m_inwoners_2008">2008</a> | <a href="#" name="vierkanten500m_inwoners_2007">2007</a><br/><a href="#" name="vierkanten500m_inwoners_2006">2006</a> | <a href="#" name="vierkanten500m_inwoners_2005">2005</a> | <a href="#" name="vierkanten500m_inwoners_2004">2004</a><br/><a href="#" name="vierkanten500m_inwoners_2003">2003</a> | <a href="#" name="vierkanten500m_inwoners_2002">2002</a> | <a href="#" name="vierkanten500m_inwoners_2001">2001</a><br/><a href="#" name="vierkanten500m_inwoners_2000">2000</a></li>
														</ul>
													</li>
													<li><a class="disabled" href="#">Inwoners 0 tot 15 jaar<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Inwoners 0 tot 20 jaar<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Inwoners 15 tot 25 jaar<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Inwoners 25 tot 45 jaar<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Inwoners 45 tot 65 jaar<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Inwoners 65 jaar en ouder<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_bevolkingsdichtheid_inwoners_per_km2">Bevolkingsdichtheid<span>Bevolkingsdichtheid inwoners per km2</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_bevolkingsdichtheid_inwoners_per_km2">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_bevolkingsdichtheid_inwoners_per_km2">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_bevolkingsdichtheid_inwoners_per_km2">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_bevolkingsdichtheid_inwoners_per_km2">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_bevolkingsdichtheid_inwoners_per_km2">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_bevolkingsdichtheid_inwoners_per_km2">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_bevolkingsdichtheid_inwoners_per_km2">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_bevolkingsdichtheid_inwoners_per_km2">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_bevolkingsdichtheid_inwoners_per_km2">2009</a></li>
														</ul>
													</li>	
													<li><a href="#" name="vierkanten500m_toename_inwoners_2000_2010">Verandering inwonertal 2000-2010<span>Toename aantal inwoners 2000 - 2010</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_toename_inwoners_2000_2010">2010</a> | <a href="#" name="vierkanten100m_toename_inwoners_2000_2010">2000</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_toename_inwoners_2000_2010">2010</a> | <a href="#" name="vierkanten500m_toename_inwoners_2000_2010">2000</a></li>
														</ul>
													</li>

													<li class="menuTitle">Huishoudens</li>	
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_eenpersoonshuishoudens">Eenpersoonshuishoudens<span>Percentage eenpersoonshuishoudens</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_eenpersoonshuishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_eenpersoonshuishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_eenpersoonshuishoudens">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_eenpersoonshuishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_eenpersoonshuishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_eenpersoonshuishoudens">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_eenpersoonshuishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_eenpersoonshuishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_eenpersoonshuishoudens">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_huishoudens_zonder_kinderen">Huishoudens zonder kinderen<span>Percentage huishoudens zonder kinderen</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_huishoudens_zonder_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_huishoudens_zonder_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_huishoudens_zonder_kinderen">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_huishoudens_zonder_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_huishoudens_zonder_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_huishoudens_zonder_kinderen">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_huishoudens_zonder_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_huishoudens_zonder_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_huishoudens_zonder_kinderen">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_huishoudens_met_kinderen">Huishoudens met kinderen<span>Percentage huishoudens met kinderen</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_huishoudens_met_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_huishoudens_met_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_huishoudens_met_kinderen">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_huishoudens_met_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_huishoudens_met_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_huishoudens_met_kinderen">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_huishoudens_met_kinderen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_huishoudens_met_kinderen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_huishoudens_met_kinderen">2009</a></li>
														</ul>
													</li>
													
													<li class="menuTitle">Herkomst</li>	
													<li><a href="#" name="vierkanten500m_autochtonen_2011">Autochtonen (%)<span>Pecentage autochtonen</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_autochtonen_2011">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_autochtonen_2011">2011</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_niet_westerse_allochtonen">Niet-westerse allochtonen (%)<span>Percentage niet westerse allochtonen</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_niet_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_niet_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_niet_westerse_allochtonen">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_niet_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_niet_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_niet_westerse_allochtonen">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_niet_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_niet_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_niet_westerse_allochtonen">2009</a></li>
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_niet_westers_allochtonen_2011">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_niet_westers_allochtonen_2011">2011</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_westerse_allochtonen">Westerse allochtonen (%)<span>Percentage westerse allochtonen</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_westerse_allochtonen">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_westerse_allochtonen">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_westerse_allochtonen">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_westerse_allochtonen">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_westerse_allochtonen">2009</a></li>
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_allochtonen_2011">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_allochtonen_2011">2011</a></li>
														</ul>
													</li>
											</ul>
											<ul class="navleft">
													<li class="menuTitle">Inkomen</li>	
													<li><a class="disabled" href="#">Aantal inkomensontvangers<span class="redcolor">Dit thema is niet aanwezig.</span></a>	
													</li>
													<li><a class="disabled" href="#">Inkomen per ontvanger<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Inwoners met laag inkomen (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Inwoners met hoog inkomen (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Huishoudens met laag inkomen (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>											
													<li><a class="disabled" href="#">Huishoudens met hoog inkomen (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>											
													<li><a class="disabled" href="#">Huishoudens rond of onder sociaal minimum (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													
													<li class="menuTitle">Wonen</li>	
													<li><a href="#" name="vierkanten500m_woningen_2011">Woningen<span>Woningvoorraad</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_woningen_2011">2011</a> | <a href="#" name="vierkanten100m_woningen_2010">2010</a><br/><a href="#" name="vierkanten100m_woningen_2009">2009</a> | <a href="#" name="vierkanten100m_woningen_2008">2008</a> | <a href="#" name="vierkanten100m_woningen_2007">2007</a><br/><a href="#" name="vierkanten100m_woningen_2006">2006</a> | <a href="#" name="vierkanten100m_woningen_2005">2005</a> | <a href="#" name="vierkanten100m_woningen_2011">2004</a><br/><a href="#" name="vierkanten100m_woningen_2003">2003</a> | <a href="#" name="vierkanten100m_woningen_2002">2002</a> | <a href="#" name="vierkanten100m_woningen_2001">2001</a><br/><a href="#" name="vierkanten100m_woningen_2000">2000</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_woningen_2011">2011</a> | <a href="#" name="vierkanten500m_woningen_2010">2010</a><br/><a href="#" name="vierkanten500m_woningen_2009">2009</a> | <a href="#" name="vierkanten500m_woningen_2008">2008</a> | <a href="#" name="vierkanten500m_woningen_2007">2007</a><br/><a href="#" name="vierkanten500m_woningen_2006">2006</a> | <a href="#" name="vierkanten500m_woningen_2005">2005</a> | <a href="#" name="vierkanten500m_woningen_2011">2004</a><br/><a href="#" name="vierkanten500m_woningen_2003">2003</a> | <a href="#" name="vierkanten500m_woningen_2002">2002</a> | <a href="#" name="vierkanten500m_woningen_2001">2001</a><br/><a href="#" name="vierkanten500m_woningen_2000">2000</a></li>
														</ul>
													</li>		
													<li><a href="#" name="vierkanten500m_gem_woz_waarde_woningen_2011">Woning WOZ-waarde<span>Gemiddelde woningwaarde</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_wozwon2011">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_gem_woz_waarde_woningen_2011">2011</a></li>
														</ul>
													</li>		

													<li class="menuTitle">Bedrijven</li>	
													<li><a class="disabled" href="#">Agrarische bedrijven<span class="redcolor">Dit thema is niet aanwezig.</span></a>																</li>		
													<li><a class="disabled" href="#">Industrie (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Commerciele dienstverlening (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>												
													<li><a class="disabled" href="#">Niet-commerciele dienstverlening (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													
												<!--/ul-->
											</ul>
											<ul class="navright">
											<!--ul class="navright"-->
												<li class="menuTitle"><em>Voorzieningen</em><br/>Kortste afstand</li>
												<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_huisartsenpraktijk_gemiddelde_afstand_in_km">Huisartsenpraktijk<span>Huisartsenpraktijk gemiddelde afstand in km</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_huisartsenpraktijk_gemiddelde_afstand_in_km">2010</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_huisartsenpraktijk_gemiddelde_afstand_in_km">2010</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_huisartsenpraktijk_gemiddelde_afstand_in_km">2010</a></li>
													</ul>
												</li>
												<li><a class="disabled" href="#">Huisartsenpost<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">Ziekenhuis, excl. buitenpolikliniek<span>Ziekenhuis excl buitenpolikliniek gem afst in km</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2009</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2009</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_ziekenhuis_excl_buitenpolikliniek_gem_afst_in_km">2009</a></li>
													</ul>
												</li>
												<li><a class="disabled" href="#">Kinderdagverblijf<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Buitenschoolse opvang<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a href="#" name="wijkenbuurten2009_thema_gemeenten2009_basisonderwijs_gemiddelde_afstand_in_km">Basisonderwijs<span>Basisonderwijs gemiddelde afstand in km</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2009_thema_gemeenten2009_basisonderwijs_gemiddelde_afstand_in_km">2009</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2009_thema_wijken2009_basisonderwijs_gemiddelde_afstand_in_km">2009</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2009_thema_buurten2009_basisonderwijs_gemiddelde_afstand_in_km">2009</a></li>
													</ul>
												</li>
												<li><a class="disabled" href="#">VMBO onderwijs<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">HAVO/VWO onderwijs<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_grote_supermarkt_gemiddelde_afstand_in_km">Grote supermarkt<span>Grote supermarkt gemiddelde afstand in km</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_grote_supermarkt_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_grote_supermarkt_gemiddelde_afstand_in_km">2009</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_grote_supermarkt_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_grote_supermarkt_gemiddelde_afstand_in_km">2009</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_grote_supermarkt_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_grote_supermarkt_gemiddelde_afstand_in_km">2009</a></li>
													</ul>
												</li>
													<li><a class="disabled" href="#">Ov. dagelijkse levensmiddelen<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												
												<li class="menuTitle">Stedelijkheid</li>
												<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_omgevingsadressendichtheid">Omgevingsadressendichtheid<span>Omgevingsadressendichtheid</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_omgevingsadressendichtheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_omgevingsadressendichtheid">2009</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_omgevingsadressendichtheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_omgevingsadressendichtheid">2009</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_omgevingsadressendichtheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_omgevingsadressendichtheid">2009</a></li>
														<li>500m vierkant<br/><a href="#" name="vierkanten500m_oad2011">2011</a> | <a href="#" name="vierkanten500m_oad2010">2010</a><br/><a href="#" name="vierkanten500m_oad2009">2009</a> | <a href="#" name="vierkanten500m_oad2008">2008</a> | <a href="#" name="vierkanten500m_oad2007">2007</a><br/><a href="#" name="vierkanten500m_oad20006">2006</a> | <a href="#" name="vierkanten500m_oad2005">2005</a> | <a href="#" name="vierkanten500m_oad2004">2004</a><br/><a href="#" name="vierkanten500m_oad2003">2003</a> | <a href="#" name="vierkanten500m_oad2002">2002</a> | <a href="#" name="vierkanten500m_oad2001">2001</a><br/><a href="#" name="vierkanten500m_oad2000">2000</a></li>										
													</ul>
												</li>
										</ul>		
										</div>
									</li>			
									<li id="keytheme2">
										<a href="#keytheme2" class="accordionheader">Klik voor meer thema's<span>Wilt u meer thema's bekijken klik dan hier ...</span></a>
										<div class="menuAccordionContent">									
											<ul class="navleft">
													<li class="menuTitle">Bevolking</li>	
													<li><a href="#" name="vierkanten500m_i2011_019">Inwoners 0 tot 20 jaar<span>Aantal personen 0 tot 20 jaar</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_i2011_019">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_i2011_019">2011</a></li>
														</ul>
													</li>
													<li><a href="#" name="vierkanten500m_i2011_2044">Inwoners 20 tot 45 jaar<span>Aantal personen 20 tot 45 jaar</span></a>
														<ul class="submenu">
															<li>100m vierkant<br/><a href="#" name="vierkanten100m_i2011_2044">2011</a></li>
															<li>500m vierkant<br/><a href="#" name="vierkanten500m_i2011_2044">2011</a></li>
														</ul>
													</li>
													<li><a class="disabled" href="#">Binnenlandse migratie<span class="redcolor">Dit thema is niet aanwezig.</span></a></li>	
													<li><a class="disabled" href="#">Mannen<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Vrouwen<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	

													<li class="menuTitle">Huishouden</li>	
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_huishoudens">Aantal particuliere huishoudens<span>Aantal huishoudens</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_aantal_huishoudens">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_aantal_huishoudens">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_aantal_huishoudens">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_ongehuwd">Ongehuwd (%)<span>Percentage ongehuwd</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_ongehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_ongehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_ongehuwd">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_ongehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_ongehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_ongehuwd">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_ongehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_ongehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_ongehuwd">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_gehuwd">Gehuwd (%)<span>Percentage gehuwd</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_gehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_gehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_gehuwd">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_gehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_gehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_gehuwd">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_gehuwd">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_gehuwd">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_gehuwd">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_gescheid">Gescheiden (%)<span>Percentage gescheid</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_percentage_gescheid">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_percentage_gescheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_percentage_gescheid">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_percentage_gescheid">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_percentage_gescheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_percentage_gescheid">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_percentage_gescheid">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_percentage_gescheid">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_percentage_gescheid">2009</a></li>
														</ul>
													</li>
													<li><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_huishoudens">Gemiddelde huishoudensgrootte (%)<span>Gemiddelde huishoudensgrootte</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2011_thema_gemeenten2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_gemeenten2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_aantal_huishoudens">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2011_thema_wijken2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_wijken2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_aantal_huishoudens">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2011_thema_buurten2011_aantal_huishoudens">2011</a> | <a href="#" name="wijkenbuurten2010_thema_buurten2010_aantal_huishoudens">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_aantal_huishoudens">2009</a></li>
														</ul>
													</li>
													
													<li class="menuTitle">Inkomen</li>	
													<li><a class="disabled" href="#">Inkomen per inwoner<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Niet actieven<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													
													<li class="menuTitle">Sociale zekerheid</li>	
													<li><a class="disabled" href="#">Arbeids ongeschiktheid<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Uitkeringen werkloosheid<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
											</ul>
											<ul class="navleft">
													<li class="menuTitle">Wonen</li>	
													<li><a class="disabled" href="#">Huurwoning (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Koopwoning (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Bouwjaarklasse tot 2000 (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Bouwjaarklasse vanaf 2000 (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													<li><a class="disabled" href="#">Wooneenheden<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>											
													<li><a class="disabled" href="#">Recreatiewoningen<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													
													<li class="menuTitle">Energie</li>	
													<li><a class="disabled" href="#">Gemiddeld gasverbruik totaal<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>		
													<li><a class="disabled" href="#">Stadsverwarming (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													<li><a class="disabled" href="#">Gemiddeld elektriciteitsverbruik totaal<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>																		

													<li class="menuTitle">Motorvoertuigen</li>	
													<li><a class="disabled" href="#">Personenauto's totaal<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>		
													<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_personenautos_per_huishouden">Personenauto's per huishoudens<span>Personenauto s per huishouden</span></a>
														<ul class="submenu">
															<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_personenautos_per_huishouden">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_personenautos_per_huishouden">2009</a></li>
															<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_personenautos_per_huishouden">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_personenautos_per_huishouden">2009</a></li>
															<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_personenautos_per_huishouden">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_personenautos_per_huishouden">2009</a></li>
														</ul>
													</li>
													<li><a class="disabled" href="#">Bedrijfsmotorvoertuigen totaal<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>												
													<li><a class="disabled" href="#">Motortweewielers totaal<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>	
													
													<li class="menuTitle">Oppervlakte</li>	
													<li><a class="disabled" href="#">Oppervlakte land in ha<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>		
													<li><a class="disabled" href="#">Oppervlakte water in ha<span class="redcolor">Dit thema is niet aanwezig.</span></a>
													</li>
													
												<!--/ul-->
											</ul>
											<ul class="navright">
											<!--ul class="navright"-->
												<li class="menuTitle">Bedrijven</li>
												<li><a class="disabled" href="#">Gewassenbedrijven (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Veeteeltbedrijven (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Combinatiebedrijven (%)<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												
												<li class="menuTitle"><em>Voorzieningen</em><br/>Kortste afstand</li>
												<li><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_restaurant_gemiddelde_afstand_in_km">Restaurant<span>Restaurant gemiddelde afstand in km</span></a>
													<ul class="submenu">
														<li>Gemeente<br/><a href="#" name="wijkenbuurten2010_thema_gemeenten2010_restaurant_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_gemeenten2009_restaurant_gemiddelde_afstand_in_km">2009</a></li>
														<li>Wijk<br/><a href="#" name="wijkenbuurten2010_thema_wijken2010_restaurant_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_wijken2009_restaurant_gemiddelde_afstand_in_km">2009</a></li>
														<li>Buurt<br/><a href="#" name="wijkenbuurten2010_thema_buurten2010_restaurant_gemiddelde_afstand_in_km">2010</a> | <a href="#" name="wijkenbuurten2009_thema_buurten2009_restaurant_gemiddelde_afstand_in_km">2009</a></li>
													</ul>
												</li>
												<li><a class="disabled" href="#">Bibliotheek<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Zwembad<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Bioscoop<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Treinstation<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												
												<li class="menuTitle">Aantal binnen 3 kilometer</li>
												<li><a class="disabled" href="#">Huisartsenpraktijk<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Kinderdagverblijf<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Basisonderwijs<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">Grote supermarkt<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												
												<li class="menuTitle">Aantal binnen 5 kilometer</li>
												<li><a class="disabled" href="#">VMBO onderwijs<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
												<li><a class="disabled" href="#">HAVO/VWO onderwijs<span class="redcolor">Dit thema is niet aanwezig.</span></a>
												</li>
										</ul>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</li>			
					<li id="jaarmenu">
						<a href="#jaarmenu">Op jaar<span>Selecteer een kaartlaag op jaar</span></a>
						 <div class="contentasset">
							<div class="megaMenu megaThreeColumns">
								<!-- gebruik dezelfde markup als je wel of geen accordion hebt -->
								<ul><li> 
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
								</li></ul>		
							</div>
						</div>
					</li>
					<li id="kaartlaagmenu">
						<a href="#kaartlaagmenu">Op kaartlaag<span>Selecteer een kaartlaag</span></a>
						<div class="contentasset">
							<div class="megaMenu megaFourColumns">
								<ul><li>
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
								</li></ul>
							</div>
						</div>
					</li>
					<li id="infobox"></li>  
				</ol>
				<span href="#closemega" class="closeMega"></span>	
			</div>
		</li>
	</ul>
</div>		

</jsp:root>