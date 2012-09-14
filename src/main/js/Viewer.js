/**
 * Viewer klasse.
 * 
 * @author mprins
 * @returns a Viewer object
 */
Viewer =
		function() {
			/**
			 * This objects Map object, initially null.
			 * 
			 * @private
			 * @type OpenLayers.Map
			 */
			var _map = null;

			return {
				/**
				 * Constructor.
				 * 
				 * @param config
				 *            Configratie object
				 * @constructor
				 */
				init : function(config) {
					this.config = config;
					// reset any controls
					jQuery.extend(
							true, this.config, {
								map : {
									controls : []
								}
							});
					jQuery(
							window).unload(
							function() {
								Viewer.destroy();
							});
					OpenLayers.Lang.setCode('nl');
					OpenLayers.Number.decimalSeparator = ",";

					this.createMap();
					this.addBaseMap();
					this.addControls();
				},

				/**
				 * Initialiseer de kaart.
				 */
				createMap : function() {
					_map = new OpenLayers.Map(
							this.config.mapDiv, this.config.map);
				},

				/**
				 * 
				 * @returns OpenLayers.Map object van deze Viewer of undefined
				 *          als het object niet is geinitialiseerd
				 * @deprecated probeer deze niet te gebruiken
				 */
				getMap : function() {
					return _map;
				},

				/**
				 * add the controls
				 */
				addControls : function() {
					_map.addControl(new OpenLayers.Control.KeyboardDefaults(
							{
								/* alleen actief als de kaart focus heeft */
								observeElement : this.config.mapDiv
							}));
					_map.addControl(new OpenLayers.Control.Zoom());
					_map.addControl(new OpenLayers.Control.Navigation(
							{
								zoomWheelEnabled : false
							}));
				},

				/**
				 * cleanup.
				 */
				destroy : function() {
					_map = null;
				},

				/**
				 * add the WMS to the map.
				 */
				addWMS : function(wmsConfig) {
					var layer = new OpenLayers.Layer.WMS(
							wmsConfig.name, wmsConfig.url, {
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
					_map.addLayer(layer);
				},

				/**
				 * removes the WMS from the map.
				 * 
				 * @param wmsID
				 *            ID van de WMS
				 */
				removeWMS : function(wmsID) {
					// TODO implementatie
				},

				/**
				 * set up basemap.
				 */
				addBaseMap : function() {
					var matrixIds = [
						13
					];
					for ( var i = 0; i < 13; ++i) {
						matrixIds[i] = "EPSG:28992:" + i;
					}
					var lyr =
							new OpenLayers.Layer.WMTS(
									{
										name : "achtergrond",
										url : "http://geodata.nationaalgeoregister.nl/tiles/service/wmts/brtachtergrondkaart/",
										layer : "brtachtergrondkaart",
										matrixSet : 'EPSG:28992',
										matrixIds : matrixIds,
										format : 'image/png8',
										style : '_null'
									});
					_map.addLayer(lyr);
					_map.zoomTo(6);
				}
			};
		}();
