/**
 * @fileoverview Dit is het globale javascript configuratie object voor de applicatie.
 */
/**
 * configuratie object voor het javascript deel van de applicatie.
 * 
 * @type {object}
 */
var config = {};
/** OpenLayers css/image pad. */
config.imgPath = "img/";

/** id van de div met de kaart. */
config.mapDiv = "cbsKaart";

/** id van de div voor de legenda. */
config.legendDiv = "legenda";

/** id van de div voor de featureinfo. */
config.featureInfoDiv = "featureinfo";

/** instellingen voor de kaart. Voorlopig alleen RD projectie. */
config.map = {
	projection : "EPSG:28992",
	theme : null,
	restrictedExtent : new OpenLayers.Bounds(0, 300000, 280000, 625000),
	resolutions : [ 3440.640, 1720.320, 860.160, 430.080, 215.040, 107.520, 53.760, 26.880, 13.440, 6.720, 3.360,
			1.680, 0.840, 0.420 ],
	initialZoom : 6,
	// initiele afmeting van de kaart
	height : 430,
	width : 410
};

/**
 * schakel de kaart naar pagina vullend tijdens opstarten.
 * 
 * @type {Boolean}
 */
config.fullSize = true;

/**
 * Of de resize knop op de kaart moet worden gezet.
 * 
 * @type {Boolean}
 */
config.toggleSize = false;

/**
 * OpenLayers proxy url override.
 * 
 * @override
 */
OpenLayers.ProxyHost = 'xhr?';

/**
 * Rijksdriehoek (RD) bekend maken aan OpenLayers.
 */
jQuery.extend(true, OpenLayers.Projection.defaults, {
	"EPSG:28992" : {
		units : "m",
		maxExtent : [ -285401.92, 22598.08, 595401.9199999999, 903401.9199999999 ]
	}
});