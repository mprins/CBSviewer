/**
 * @fileoverview globale configuratie object voor de applicatie.
 */
/**
 * configuratie object voor de applicatie.
 * 
 * @type {object}
 */
var config = {};

config.imgPath = "img/";
/**
 * proxy url.
 */
OpenLayers.ProxyHost = 'xhr?';

/** id van de div met de kaart. */
config.mapDiv = "cbsKaart";

/** id van de div voor de legenda. */
config.legendDiv = "legenda";

/** id van de div voor de featureinfo. */
config.featureInfoDiv = "featureinfo";

/** instellingen voor de kaart. */
config.map = {
	projection : "EPSG:28992",
	/* displayProjection : "EPSG:28992", */
	/* units : "m", */
	theme : null,
	/*
	 * maxExtent : new OpenLayers.Bounds(-285401.92, 22598.08,
	 * 595401.9199999999, 903401.9199999999),
	 */
	restrictedExtent : new OpenLayers.Bounds(0, 300000, 280000, 625000),
	resolutions : [ 3440.640, 1720.320, 860.160, 430.080, 215.040, 107.520, 53.760, 26.880, 13.440, 6.720, 3.360,
			1.680, 0.840, 0.420 ],
	initialZoom : 8,
	// initiele afmeting van de kaart
	height : 430,
	width : 410
};

/**
 * Rijksdriehoek bekend maken aan OpenLayers.
 */
jQuery.extend(true, OpenLayers.Projection.defaults, {
	"EPSG:28992" : {
		units : "m",
		maxExtent : [ -285401.92, 22598.08, 595401.9199999999, 903401.9199999999 ]
	}
});
