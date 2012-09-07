Viewer = function() {
	var _map;
	var config;

	return {
		/**
		 * maakt de kaart.
		 */
		init : function(config) {
			this.config = config;
			jQuery(window).unload(function() {
				Viewer.destroy();
			});
			OpenLayers.Lang.setCode('nl');
			OpenLayers.Number.decimalSeparator = ",";
			this.createMap();
			this.addBaseMap();
			this
					.addWMS({
						'name' : 'cbs_inwoners_2010_per_hectare',
						'url' : 'http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows',
						'layers' : 'cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare',
						'styles' : 'cbsvierkant100m_inwoners_2000'
					});
		},

		/**
		 * maakt de kaart aan.
		 */
		createMap : function() {
			this._map = new OpenLayers.Map(this.config.mapDiv, this.config.map);
			
			this._map.addControl(new OpenLayers.Control.KeyboardDefaults({
		        observeElement: this.config.mapDiv
		    }));
			this._map.addControl(new OpenLayers.Control.Zoom());
			
			// new OpenLayers.Control.Navigation({zoomWheelEnabled: false}),
						// new OpenLayers.Control.PinchZoom()
		},

		/**
		 * cleanup.
		 */
		destroy : function() {
			this._map = null;
		},

		/**
		 * add the WMS to the map.
		 */
		addWMS : function(wmsConfig) {
			var layer = new OpenLayers.Layer.WMS(wmsConfig.name, wmsConfig.url,
					{
						layers : wmsConfig.layers,
						styles : wmsConfig.styles,
						version : '1.1.1',
						format : 'image/png',
						transparent : true
					}, {
						isBaseLayer : false,
						visibility : true,
						singleTile : true
					});

			this._map.addLayer(layer);
			console.debug(this._map);
		},

		/**
		 * removes the WMS from the map.
		 * @param wmsID ID van de WMS
		 */
		removeWMS : function(wmsID) {

		},

		/**
		 * set up basemap.
		 */
		addBaseMap : function() {
			var matrixIds = new Array(13), lyr;

			for ( var i = 0; i < 13; ++i) {
				matrixIds[i] = "EPSG:28992:" + i;
			}
			lyr = new OpenLayers.Layer.WMTS(
					{
						name : "achtergrond",
						url : "http://geodata.nationaalgeoregister.nl/tiles/service/wmts/brtachtergrondkaart/",
						layer : "brtachtergrondkaart",
						matrixSet : 'EPSG:28992',
						matrixIds : matrixIds,
						format : 'image/png8',
						style : '_null'
					});
			this._map.addLayer(lyr);
			this._map.zoomTo(6);
		}
	};
}();