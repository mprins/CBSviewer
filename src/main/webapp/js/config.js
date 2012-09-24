/**
 * globale configuratie object voor de applicatie.
 */
var config = {};

config.imgPath = "img/";

OpenLayers.ProxyHost = 'proxy.jsp?';

/**
 * uitbreiding en overrides van de language file.
 */
OpenLayers.Lang.nl = OpenLayers.Util.extend({
	'keyboardNavTtl' : 'Gebruik +,- en pijl toetsen. Met de i en Enter toets kan informatie opgevraagd worden....',
	'keyboardNav' : 'Activeer toetsenbord navigatie voor de kaart',
	'cssError' : 'Wordt deze kaart niet goed weergegeven? Klik dan hier.'
}, OpenLayers.Lang.nl);

/** id van de div met de kaart. */
config.mapDiv = "cbsKaart";

/** instellingen voor de kaart. */
config.map = {
	projection : "EPSG:28992",
	displayProjection : "EPSG:28992",
	units : "m",
	theme : null,
	maxExtent : new OpenLayers.Bounds(-285401.92, 22598.08, 595401.9199999999, 903401.9199999999),
	restrictedExtent : new OpenLayers.Bounds(0, 300000, 280000, 625000),
	resolutions : [ 3440.640, 1720.320, 860.160, 430.080, 215.040, 107.520, 53.760, 26.880, 13.440, 6.720, 3.360,
			1.680, 0.840, 0.420 ],
	initialZoom : 8
};
