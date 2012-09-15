describe(
		'Viewer', function() {
			it(
					'Object type bestaat', function() {
						expect(
								Viewer).toBeDefined();
						expect(
								Viewer.getMap()).toBeNull();
					});

			describe(
					'Viewer initialized', function() {

						beforeEach(function() {
							mapDiv = document.createElement('div');
							mapDiv.id = config.mapDiv;
							mapDiv.style.width = '600px';
							mapDiv.style.height = '300px';
							document.body.appendChild(mapDiv);

							Viewer.init(config);
						});

						afterEach(function() {
							Viewer.destroy();
							document.body.removeChild(mapDiv);
						});

						it(
								'initialisatie test met configuratie', function() {
									Viewer.init(config);
									expect(
											Viewer.getMap().projection).toEqual(
											config.map.projection);
								});
						it(
								'de kaart moet een OpenLayers.Map instance zijn', function() {
									Viewer.init(config);
									expect(
											Viewer.getMap()).toBeInstanceOf(
											OpenLayers.Map);
								});
					});

		});
