/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
/**
 * ZoomControle met ingebouwde tooltips.
 * 
 * @author mprins
 * @class
 * @extends OpenLayers.Control.Zoom()
 * @requires OpenLayers/Control/Zoom.js
 * @constructor
 */
ZoomControl = OpenLayers.Class(OpenLayers.Control.Zoom, {
	/**
	 * Method: getOrCreateLinks
	 * 
	 * Parameters: el - {DOMElement}
	 * 
	 * Return: {Object} Object with zoomIn and zoomOut properties referencing
	 * links.
	 * @ovveride
	 */
	getOrCreateLinks : function(el) {
		var zoomIn = document.getElementById(this.zoomInId), zoomOut = document.getElementById(this.zoomOutId);
		if (!zoomIn) {
			zoomIn = document.createElement("button");
			zoomIn.href = "#zoomIn";
			var tooltip = document.createElement("span");
			tooltip.appendChild(document.createTextNode(OpenLayers.i18n('KEY_ZOOMIN_TOOLTIP')));
			zoomIn.appendChild(tooltip);
			zoomIn.appendChild(document.createTextNode(this.zoomInText));
			zoomIn.className = "olControlZoomIn";
			el.appendChild(zoomIn);
		}
		OpenLayers.Element.addClass(zoomIn, "olButton");
		OpenLayers.Element.addClass(zoomIn, "hasTooltip");
		if (!zoomOut) {
			zoomOut = document.createElement("button");
			zoomOut.href = "#zoomOut";
			var tooltip = document.createElement("span");
			tooltip.appendChild(document.createTextNode(OpenLayers.i18n('KEY_ZOOMOUT_TOOLTIP')));
			zoomOut.appendChild(tooltip);
			zoomOut.appendChild(document.createTextNode(this.zoomOutText));
			zoomOut.className = "olControlZoomOut";
			el.appendChild(zoomOut);
		}
		OpenLayers.Element.addClass(zoomOut, "olButton");
		OpenLayers.Element.addClass(zoomOut, "hasTooltip");
		return {
			zoomIn : zoomIn,
			zoomOut : zoomOut
		};
	},
	CLASS_NAME : "ZoomControl"
});
