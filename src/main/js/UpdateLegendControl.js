/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
/**
 * Werkt de legenda bij als de kaart wordt ge-update met een WMS layer.
 * 
 * @author mprins
 * @class
 * @extends OpenLayers.Control
 * @requires OpenLayers/Control.js
 * @requires OpenLayers/Layer/WMS/js
 * @constructor
 */
UpdateLegendControl = OpenLayers.Class(OpenLayers.Control, {
	/**
	 * Activate the control when it is added to a map. Default is true.
	 * 
	 * @type{Boolean}
	 */
	autoActivate : true,

	/**
	 * Dom element waar de legenda in wordt gevoegd. Moet een container element
	 * zijn zoals P, DIV, SPAN, MAP, LI, ...
	 * 
	 * @type {DOMElement}
	 */
	element : null,

	/**
	 * destroy this control.
	 */
	destroy : function() {
		this.deactivate();
		OpenLayers.Control.prototype.destroy.apply(this, arguments);
	},

	/**
	 * activate this control.
	 */
	activate : function() {
		if (OpenLayers.Control.prototype.activate.apply(this, arguments)) {
			this.map.events.register('addlayer', this, this.redraw);
			this.redraw();
			return true;
		} else {
			return false;
		}
	},

	/**
	 * deactivate this control.
	 */
	deactivate : function() {
		if (OpenLayers.Control.prototype.deactivate.apply(this, arguments)) {
			this.map.events.unregister('addlayer', this, this.redraw);
			this.element.innerHTML = "";
			return true;
		} else {
			return false;
		}
	},

	/**
	 * draw this control.
	 * 
	 * @returns {DOMElement}
	 */
	draw : function() {
		OpenLayers.Control.prototype.draw.apply(this, arguments);
		if (!this.element) {
			this.div.left = "";
			this.div.top = "";
			this.element = this.div;
		}
		return this.div;
	},

	/**
	 * redraw this control.
	 * 
	 * @param {OpenLayers.Event}
	 *            evt De addlayer event
	 */
	redraw : function(evt) {
		// addlayer event - triggered after a layer has been added. The event
		// object will include a *layer* property that references the added
		// layer.
		if (evt == null) {
			this.reset();
			return;
		} else {
			// test if layer is WMS
			if (evt.layer.CLASS_NAME == "OpenLayers.Layer.WMS") {
				var lyr = evt.layer;
				var wmsLyrs = (lyr.params.LAYERS).split(',');
				var wmsLyrStyles = (lyr.params.STYLES).split(',');
				var newHtml = "";
				for (i = 0, l = wmsLyrs.length; i < l; i++) {
					var legendUrl = lyr.url + '?SERVICE=WMS&REQUEST=GetLegendGraphic' + '&FORMAT=image%2Fpng'
							+ '&WIDTH=36&HEIGHT=36' + '&LAYER=' + wmsLyrs[i] + '&STYLE=' + wmsLyrStyles[i]
							+ '&VERSION=1.1.1&EXCEPTIONS=' + lyr.params.EXCEPTIONS;
					newHtml += '<img src="' + legendUrl + '" alt="Legenda voor kaartlaag ' + lyr.name + ' ('
							+ wmsLyrs[i] + ')"/>';
				}

				if (newHtml != this.element.innerHTML) {
					this.element.innerHTML = newHtml;
				}
			}
		}
	},

	/**
	 * reset this control.
	 * 
	 * @param {OpenLayers.Event}
	 *            evt De addlayer event
	 */
	reset : function(evt) {
		if (this.emptyString !== null) {
			this.element.innerHTML = this.emptyString;
		}
	},
        
        CLASS_NAME : 'UpdateLegendControl'
});
