var config = {};
config.imgPath = "img/";

OpenLayers.ImgPath = config.imgPath;
OpenLayers.IMAGE_RELOAD_ATTEMPTS = 2;
//OpenLayers.ProxyHost = 'proxy.jsp?';

OpenLayers.Lang.nl = OpenLayers.Util.extend({
	// uitbreiding en overrides van de language file.
	// 'key' : 'tekst',
}, OpenLayers.Lang.nl);


config.mapDiv = "kaart";

/** instellingen voor de kaart.*/
config.map = {
    projection: "EPSG:28992",
    displayProjection : "EPSG:28992",
    units: "m",
    theme: null,
    maxExtent: new OpenLayers.Bounds(-285401.92, 22598.08,595401.9199999999,903401.9199999999),
    restrictedExtent: new OpenLayers.Bounds(0, 300000, 280000, 625000),
    resolutions: [3440.640, 1720.320,860.160, 430.080, 215.040, 107.520, 53.760, 26.880, 13.440, 6.720, 3.360, 1.680, 0.840, 0.420]
};

