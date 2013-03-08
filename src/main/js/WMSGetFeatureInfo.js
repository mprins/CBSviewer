/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
/**
 * Custom WMSGetFeatureInfo control.
 * 
 * @author mprins
 * @class {WMSGetFeatureInfo}
 * @extends {OpenLayers.Control.WMSGetFeatureInfo}
 */
WMSGetFeatureInfo = OpenLayers.Class(OpenLayers.Control.WMSGetFeatureInfo, {

	/** @override */
	queryVisible : true,
	/** @override */
	maxFeatures : 20,
	/** @override */
	infoFormat : 'text/html',
	/** @override */
	autoActivate : true,

	/** @constructor */
	initialize : function(options) {
		options = options || {};
		options.handlerOptions = options.handlerOptions || {};
		OpenLayers.Control.WMSGetFeatureInfo.prototype.initialize.apply(this, [ options ]);
	},

	CLASS_NAME : 'WMSGetFeatureInfo'
});