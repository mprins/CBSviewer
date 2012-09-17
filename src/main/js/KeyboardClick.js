/* Copyright (c) 2006-2012 by OpenLayers Contributors (see authors.txt for 
 * full list of contributors). Published under the 2-clause BSD license.
 * See license.txt in the OpenLayers distribution or repository for the
 * full text of the license. 
 */

/**
 * A custom control that (a) adds a vector point that can be moved using the
 * arrow keys of the keyboard, and (b) displays a browser alert window when the
 * RETURN key is pressed. The control can be activated/deactivated using the "i"
 * key. When activated the control deactivates any KeyboardDefaults control in
 * the map so that the map is not moved when the arrow keys are pressed.
 * 
 * This control relies on the OpenLayers.Handler.KeyboardPoint custom handler.
 *
 * @class OpenLayers.Control.KeyboardClick
 * @requires OpenLayers/Control.js
 * @requires KeyboardPoint.js
 */
OpenLayers.Control.KeyboardClick = OpenLayers.Class(OpenLayers.Control, {
	/** @constructor */
	initialize : function(options) {
		OpenLayers.Control.prototype.initialize.apply(this, [ options ]);
		var observeElement = this.observeElement || document;
		this.handler = new OpenLayers.Handler.KeyboardPoint(this, {
			done : this.onClick,
			cancel : this.deactivate
		}, {
			observeElement : observeElement
		});
		OpenLayers.Event.observe(observeElement, "keydown", OpenLayers.Function.bindAsEventListener(function(evt) {
			if (evt.keyCode == 73) { // "i"
				if (this.active) {
					this.deactivate();
				} else {
					this.activate();
				}
			}
		}, this));
	},

	/**
	 * Event handler voor click event.
	 * 
	 * @param geometry
	 *            {Openlayers.Geometry}
	 */
	onClick : function(geometry) {
		// TODO
		alert("You clicked near " + geometry.x + " N, " + geometry.y + " E");
	},

	/**
	 * Activeert deze control en zet de default keybord handler uit (mits
	 * aanwezig).
	 * 
	 * @returns {Boolean}
	 */
	activate : function() {
		if (!OpenLayers.Control.prototype.activate.apply(this, arguments)) {
			return false;
		}
		// deactivate any KeyboardDefaults control
		var keyboardDefaults = this.map.getControlsByClass('OpenLayers.Control.KeyboardDefaults')[0];
		if (keyboardDefaults) {
			keyboardDefaults.deactivate();
		}
		return true;
	},

	/**
	 * Deactiveert deze control en zet de default keybord handler aan (mits
	 * aanwezig).
	 * 
	 * @returns {Boolean}
	 */
	deactivate : function() {
		if (!OpenLayers.Control.prototype.deactivate.apply(this, arguments)) {
			return false;
		}
		// reactivate any KeyboardDefaults control
		var keyboardDefaults = this.map.getControlsByClass('OpenLayers.Control.KeyboardDefaults')[0];
		if (keyboardDefaults) {
			keyboardDefaults.activate();
		}
		return true;
	}
});