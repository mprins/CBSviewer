/**
 * @fileoverview event handlers en elementen voor de pagina.
 */
jQuery(document).ready(function() {
	// create map
	Viewer.init(config);

	Viewer.loadWMS({
		'name' : 'cbs_inwoners_2010_per_hectare',
		'url' : 'http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows',
		'layers' : 'cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare',
		'styles' : 'cbsvierkant100m_inwoners_2000'
	});

	// aanhaken van handler aan submit event van formulier
	jQuery('#zoekFormulier').on('submit', function(e) {
		// om normale browser submit en navigatie te voorkomen
		e.preventDefault();

		console.info('ajaxSubmit van zoek formulier.');
	});
});

/**
 * dynamische elementen aan de pagina toevoegen.
 */
var setupPage = {
	init : function() {
		OpenLayers.Lang.setCode('nl');

		jQuery('.kaartContainer').toggleClass('hidden');

		// toggle knop voor vergroten van de kaart
		var aToggle = '<a class="max" href="#" id="toggleSize" title="' + OpenLayers.i18n('KEY_TOGGLE_SIZE')
				+ '" onclick="Viewer.toggleFullSize();"></a>';
		jQuery('#' + config.mapDiv).prepend(aToggle);

		// a11y link toevoegen in de DOM boven de kaart
		var aLink = '<a class="accesskey" href="" accesskey="1" onclick="jQuery(\'#' + config.mapDiv
				+ '\').attr(\'tabindex\',-1).focus(); return false;" title="' + OpenLayers.i18n('KEY_KEYBOARDNAV_TTL')
				+ '">' + OpenLayers.i18n('KEY_KEYBOARDNAV') + '</a>';
		jQuery('#' + config.mapDiv).prepend(aLink);

		// core link toevoegen aan de kaart
		var aCore = '<a class="accesskey" href="?coreonly=true">' + OpenLayers.i18n('KEY_CSSERROR') + '</a>';
		jQuery('#' + config.mapDiv).prepend(aCore);

		// eventueel de font-size aanpassen zodat het altijd past:
		// http://jsfiddle.net/ad5pf/1/ en
		// http://stackoverflow.com/questions/4165836/javascript-scale-text-to-fit-in-fixed-div
	}
};

setupPage.init();
