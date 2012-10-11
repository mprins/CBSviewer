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

	CLASS_NAME : "WMSGetFeatureInfo"
});