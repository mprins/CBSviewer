/* Copyright (c) 2006-2012 by OpenLayers Contributors (see authors.txt for 
 * full list of contributors). Published under the 2-clause BSD license.
 * See license.txt in the OpenLayers distribution or repository for the
 * full text of the license. 
 */

/**
 * @requires OpenLayers/Control.js
 * @requires KeyboardPoint.js
 */

/**
 * Class: OpenLayers.Control.KeyboardClick
 * 
 * A custom control that (a) adds a vector point that can be moved using the
 * arrow keys of the keyboard, and (b) displays a browser alert window when the
 * RETURN key is pressed. The control can be activated/deactivated using the "i"
 * key. When activated the control deactivates any KeyboardDefaults control in
 * the map so that the map is not moved when the arrow keys are pressed.
 * 
 * This control relies on the OpenLayers.Handler.KeyboardPoint custom handler.
 */
OpenLayers.Control.KeyboardClick = OpenLayers.Class(OpenLayers.Control, {
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

	onClick : function(geometry) {
		alert("You clicked near " + geometry.x + " N, " + geometry.y + " E");
	},

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