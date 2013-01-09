/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
/**
 * Een control die een ikoontje tekent op de plaats waar geklikt is.
 * 
 * @author mprins
 * @class {ClickDrawControl}
 * @extends {OpenLayers.Control}
 */
ClickDrawControl = OpenLayers.Class(OpenLayers.Control, {
	/** @override */
	autoActivate : true,

	/** @override */
	defaultHandlerOptions : {
		'single' : true,
		'double' : false,
		'pixelTolerance' : 0,
		'stopSingle' : false,
		'stopDouble' : false
	},

	/** @constructor */
	initialize : function(options) {
		this.handlerOptions = OpenLayers.Util.extend({}, this.defaultHandlerOptions);
		OpenLayers.Control.prototype.initialize.apply(this, arguments);
		this.handler = new OpenLayers.Handler.Click(this, {
			'click' : this.trigger
		}, this.handlerOptions);
	},

	/**
	 * Klik event handler.
	 * 
	 * @param e
	 *            {OpenLayers.Event} een muisklik event
	 */
	trigger : function(e) {
		if (!this.layer) {
			this.makeLayer();
		}
		this.drawOrMove(e);
	},

	/**
	 * zorgt voor een vector layer om een marker in te tekenen.
	 * 
	 * @private
	 */
	makeLayer : function() {
		this.layer = new OpenLayers.Layer.Vector(this.CLASS_NAME, {
			styleMap : new OpenLayers.StyleMap({
				externalGraphic : 'img/info.png',
				graphicHeight : 37,
				graphicWidth : 32,
				graphicXOffset : -16,
				graphicYOffset : -37
			})
		});
		this.map.addLayer(this.layer);
	},

	/**
	 * teken een ikoontje.
	 * 
	 * @param e
	 *            {OpenLayers.Event}
	 * @private
	 */
	drawOrMove : function(e) {
		// verplaats naar bovenste
		this.map.setLayerIndex(this.layer, this.map.getNumLayers()-1);
		var lonlat = this.map.getLonLatFromPixel(e.xy);
		if (!this.point) {
			var geometry = new OpenLayers.Geometry.Point(lonlat.lon, lonlat.lat);
			this.point = new OpenLayers.Feature.Vector(geometry);
			this.point.geometry.clearBounds();
			this.layer.addFeatures([ this.point ], {
				silent : true
			});
		} else {
			this.point.geometry.x = lonlat.lon;
			this.point.geometry.y = lonlat.lat;
			this.point.geometry.clearBounds();
		}
		this.layer.drawFeature(this.point);
	},

	/**
	 * activate deze control.
	 * 
	 * @returns {Boolean}
	 * @override
	 */
	activate : function() {
		if (!OpenLayers.Control.prototype.activate.apply(this, arguments)) {
			return false;
		}
		return true;
	},

	/**
	 * deactivate deze control, zorgt oa. voor opruimen van resources.
	 * 
	 * @returns {Boolean}
	 * @override
	 */
	deactivate : function() {
		if (!OpenLayers.Control.prototype.deactivate.apply(this, arguments)) {
			return false;
		}
		if (this.layer) {
			this.map.removeLayer(this.layer);
			this.layer.destroyFeatures([ this.point ]);
			this.point = null;
			this.layer = null;
		}
		return true;
	},

	CLASS_NAME : 'ClickDrawControl'

});