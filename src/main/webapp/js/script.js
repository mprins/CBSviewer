jQuery(
		document).ready(
		function() {
			// create map
			Viewer.init(config);

			Viewer.addWMS({
				'name' : 'cbs_inwoners_2010_per_hectare',
				'url' : 'http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows',
				'layers' : 'cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare',
				'styles' : 'cbsvierkant100m_inwoners_2000'
			});
		});

var setupPage =
		{
			init : function() {
				OpenLayers.Lang.setCode('nl');

				// a11y link toevoegen in de DOM
				var aLink =
						'<div class="accessContainer"><a class="accesskey" href="" accesskey="1" onclick="jQuery(\'#'
								+ config.mapDiv
								+ '\').attr(\'tabindex\',-1).focus(); return false;" title="'
								+ OpenLayers.i18n('keyboardNavTtl') + '">'
								+ OpenLayers.i18n('keyboardNav') + '</a></div>';
				jQuery(
						'#' + config.mapDiv).before(
						aLink);

				// core/css fout link toevoegen
				var aCore =
						'<a class="cssError" href="?coreonly=true">' + OpenLayers.i18n('cssError')
								+ '</a>';
				jQuery(
						'#' + config.mapDiv).prepend(
						aCore);
			}
		};

setupPage.init();
