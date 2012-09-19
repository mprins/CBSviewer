/**
 * Jasmine Unit tests voor Viewer.
 * 
 * @author prinsmc
 */
describe('Viewer', function() {
	it('Object type Viewer bestaat', function() {
		expect(Viewer).toBeDefined();
	});
	it('map object van Viewer is null', function() {
		expect(Viewer.getMap()).toBeNull();
	});
	/**
	 * Deze test falen in de maven runner, maar werken wel in de browser <code>
	 * mvn jasmine:bdd
	 * </code>
	 * 
	 * Voorlopig uitzetten met x (xdescribe ipv describe...) Dit is een probleem
	 * dat uit de onderliggende HtmlUnit van de maven plugin naar boven komt,
	 * mogelijk op te lossen door PhantomJs te gaan gebruiken. HtmlUnit heeft
	 * ook probemen met nieuwere versies van JQuery...
	 * 
	 */
	xdescribe(
	// TODO
	'Viewer initialized', function() {
		var _wms = {
			'name' : 'wms-layer',
			'url' : 'http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows',
			'layers' : 'cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare',
			'styles' : 'cbsvierkant100m_inwoners_2000'
		};
		var _wms2 = {
			'name' : 'cbs_inwoners_2010_per_hectare',
			'url' : 'http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows',
			'layers' : 'cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare',
			'styles' : 'cbsvierkant100m_inwoners_2000'
		};

		beforeEach(function() {
			mapDiv = document.createElement('div');
			mapDiv.id = config.mapDiv;
			mapDiv.style.width = '300px';
			mapDiv.style.height = '300px';
			document.body.appendChild(mapDiv);

			Viewer.init(config);
		});

		afterEach(function() {
			Viewer.destroy();
			document.body.removeChild(mapDiv);
		});

		it('De kaart moet een OpenLayers.Map instance zijn', function() {
			expect(Viewer.getMap()).toBeInstanceOf(OpenLayers.Map);
		});

		it('De projectie van de kaart is gelijk aan de configuratie.', function() {
			expect(Viewer.getMap().projection).toEqual(config.map.projection);
		});
		it('De kaart moet 2 lagen hebben na toevoegen van 1 WMS', function() {
			Viewer.addWMS(_wms);
			expect(Viewer.getMap().layers.length).toBe(2);
		});
		it('De kaart moet 1 laag hebben na toevoegen en verwijderen van 1 WMS', function() {
			Viewer.addWMS(_wms);
			Viewer.removeWMS(_wms.name);
			expect(Viewer.getMap().layers.length).toBe(1);
		});
		it('De kaart moet 1 laag van type WMTS hebben na toevoegen en verwijderen van WMSsen', function() {
			Viewer.addWMS(_wms);
			Viewer.addWMS(_wms2);
			Viewer.removeOverlays();
			var lyrs = Viewer.getMap().layers;
			expect(lyrs.length).toBe(1);
			expect(lyrs[0]).toBeInstanceOf(OpenLayers.Layer.WMTS);
		});
	});

});
