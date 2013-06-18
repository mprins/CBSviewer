/**
 * @fileoverview event handlers en elementen voor de ria pagina.
 */

// multiple versions of JQuery/JQuery UI can cause problems.
jQuery.noConflict();

/**
 * document onload event handling.
 */
jQuery(document)
		.ready(
				function() {
					// create map
					Viewer.init(config);

					var maps = jQuery.grep(_layers, function(n, i) {
						return n.id == config.defaultMapId;
					});

					Viewer.loadWMS(maps[0]);

					/* popup */
					jQuery('.fancybox').fancybox();
					/* slidedown effect */
					var settings_head = jQuery('.settingsPanel > li > a');
					settings_head.first().addClass('active').next().slideDown('normal');

					settings_head.on('click', function(event) {
						event.preventDefault();						
						jQuery(this).next().stop(true, true).slideToggle('normal');
						if (jQuery(this).attr('class') != 'active') {
							jQuery(this).addClass('active');
						} else {
							jQuery(this).removeClass('active');
						}
						if (jQuery(this) == '#keylegend')
							alert("true");
					});

					var menuAccordion_head = jQuery('.menuAccordion > li > .accordionheader'), menuAccordion_body = jQuery('.menuAccordion li > .menuAccordionContent');
					menuAccordion_head.first().addClass('active').next().slideDown('normal');
					menuAccordion_head.on('click', function(event) {
						event.preventDefault();

						if (jQuery(this).attr('class') != 'active') {
							menuAccordion_body.slideUp('normal');
							jQuery(this).next().stop(true, true).slideToggle('normal');
							menuAccordion_head.removeClass('active');
							jQuery(this).addClass('active');
						}
						jQuery('#legenda').css('max-height', 
								jQuery(window).height() - 
								jQuery('#footerWrapper').height() - 
								jQuery('.header').height() - 
								jQuery('#keyfeatureinfo').height() - 100
							);					
					});
					
					jQuery('#legenda').css('max-height', 
						jQuery(window).height() - 
						jQuery('#footerWrapper').height() - 
						jQuery('.header').height() - 
						jQuery('#keyfeatureinfo').height() - 100
					);									
				});
				
/**
 * Close megamenu on menu click
 * 
 * @returns false
 */ 
jQuery('#hasMenu').click(function() {
	if (parseInt(jQuery('.navDropDown').css('left')) < 0) {
		jQuery('.navDropDown').css('left', 'auto');
	} else {
		jQuery('.navDropDown').css('left', '-9999px');
	}
	return false;
});

/**
  * Close all sub menu's and open current
  */
jQuery('ul.navleft li, ul.navright li').click(function() {
	// hide all except the one clicked on
	jQuery('ul.submenu').not(jQuery(this).find('ul.submenu')).hide();
	jQuery('.menuAccordionContent').not(jQuery(this).find('a')).find('a').removeClass('submenuopened');
	
	if( !jQuery(this).find('ul.submenu').is(':visible') ) {
		jQuery(this).find('ul.submenu').show(70);
		jQuery(this).children('a').addClass('submenuopened');		
    }
	else {
		jQuery(this).find('ul.submenu').hide();
		jQuery(this).children('a').removeClass('submenuopened');
	}
});

/**
 * Hide sub menu on click
 */
jQuery(document).click(function() {

	//jQuery('ul.submenu:visible').hide();
});

/**
 * Hide main menu on click
 */
jQuery('.closeMega').click(function() {
	jQuery('.navDropDown').css('left', '-9999px');
});

/**
 * Change theme from menu
 * 
 * @param event
 *            DOM click event
 */
jQuery('.megaMenu a').click(
		function(event) {
			event.preventDefault();
			// only load new themes
			if (jQuery(this).attr('name') != config.defaultMapId 
				&& jQuery(this).attr('href') != '#'
				&& jQuery(this).attr('class') != 'accordionheader') {
				
				var _id = jQuery(this).attr('name');

				var maps = jQuery.grep(_layers, function(n, i) {
					return n.id == _id;
				});
				Viewer.loadWMS(maps[0]);
				// bijwerken pagina titel
				jQuery('title').html(OpenLayers.i18n('KEY_KAART_TITEL', {
					'0' : '' + maps[0].name
				}));
				jQuery('#pagSubTitle').html(OpenLayers.i18n('KEY_KAART_TITEL', {
					'0' : '' + maps[0].name
				}));

				// bijwerken download link
				if (maps[0].link) {
					jQuery('#downloadLink').html(
							'<a href="' + maps[0].link + '">Download de dataset voor'
									+ OpenLayers.i18n('KEY_KAART_TITEL', {
										'0' : '' + maps[0].name
									}) + '</a>');
				} else {
					jQuery('#downloadLink').html('');
				}

				// close menu
				jQuery('.navDropDown').css('left', '-9999px');
				
				config.defaultMapId = _id;
			}
		});

/**
 * dynamische elementen aan de pagina toevoegen.
 */
var setupPage = {
	init : function() {
		OpenLayers.Lang.setCode('nl');

		// verwijder core container, die hebben we niet nodig als er javascript
		// ondersteuning is.
		jQuery('#coreContainer').remove();

		// a11y link toevoegen in de DOM boven de kaart
		var aLink = '<a id="activeerKeys" class="accesskey" href="" accesskey="1" onclick="jQuery(\'#' + config.mapDiv
				+ '\').attr(\'tabindex\',-1).focus(); return false;">' + OpenLayers.i18n('KEY_KEYBOARDNAV')
				+ '<br/>'+ OpenLayers.i18n('KEY_KEYBOARDNAV_TTL') + OpenLayers.i18n('KEY_MENU_HELP')+'</a>';
		jQuery('#' + config.mapDiv).prepend(aLink);

		// core link toevoegen aan de kaart voor het geval de javascript kaart
		// niet "goed" is
		var aCore = '<a id="naarCoreLink" class="accesskey" href="?coreonly=true">' + OpenLayers.i18n('KEY_CSSERROR')
				+ '</a>';
		jQuery('#' + config.mapDiv).prepend(aCore);

		ZoekFormulier.init();

		// uitvouwen van de accordion na change event, klap de legenda in voor
		// meer duidelijkheid voor de gebruiker
		jQuery('#' + config.featureInfoDiv).change(function() {
			if (jQuery('#keyfeatureinfo a').attr('class') != 'active') {
				jQuery('#keyfeatureinfo a').next().stop(true, true).slideToggle('normal');
				jQuery('#keyfeatureinfo a').addClass('active');
			}
		});
	}
};

setupPage.init();
