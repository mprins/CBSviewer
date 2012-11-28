/**
 * Functies voor het zoekformulier zoals gedefinieerd in zoekformulier.jsp.
 * 
 * @fileoverview zorgt voor afhandeling van het adreszoek formulier.
 * @author mprins
 * @requires jQuery
 * @requires zoekformulier.jsp
 * @requires Viewer.js
 * @class
 */
var ZoekFormulier = {
	/**
	 * aanhaken van handler aan submit event van formulier.
	 * 
	 * @constructor
	 */
	init : function() {
		jQuery('#zoekFormulier').ajaxForm({
			beforeSerialize : this.handleBeforeSerialize,
			success : this.handleSuccess,
			dataType : 'json',
			data : {
				format : 'json'
			}
		});
	},
	/**
	 * Bijwerken van verborgen velden in het formulier.
	 * 
	 * @param {String}
	 *            $form html snippet
	 * @param {Object}
	 *            options een jQuery.ajax options object
	 * @returns {Boolean} true to continue the request
	 * 
	 * @see http://docs.jquery.com/Ajax/jQuery.ajax#options
	 * @private
	 */
	handleBeforeSerialize : function($form, options) {
		$form.find('input[name="coreonly"]').val('false');
		$form.find('input[name="forward"]').val('false');
		return true;
	},
	/**
	 * Bijwerken van de pagina en eventueel de kaart inzoomen.
	 * 
	 * @param {Array}
	 *            data json array met adreslijst
	 * @param {String}
	 *            statusText response status tekst
	 * @param xhr
	 *            jQuery XHR
	 * @param {String}
	 *            $form html snippet
	 * 
	 * @private
	 */
	handleSuccess : function(data, statusText, xhr, $form) {
		var html = "";
		var paragraaf = jQuery('#zoekresultaten');

		// in het geval dat een eerdere actie niets opleverde
		paragraaf.removeClass('error');

		switch (data.length) {
		case 0:
			paragraaf.addClass('error');
			html += OpenLayers.i18n("KEY_ZOEKEN_GEEN_ADRES");
			break;
		case 1:
			html += OpenLayers.i18n("KEY_ZOEKEN_EEN_ADRES");
			html += '<ul class="adreslijst"><li>' + data[0].addressString + '</li></ul>';
			Viewer.zoomTo(data[0].xCoord, data[0].yCoord, data[0].radius);
			break;
		default:
			html += '<p style="clear:both">' + OpenLayers.i18n("KEY_ZOEKEN_MEER_ADRES") + '</p>';
			html += '<ul class="adreslijst">';

			for ( var i = 0; i < data.length; i++) {
				html += '<li><a class="button" href="#" onclick="Viewer.zoomTo(' + data[i].xCoord + ','
						+ data[i].yCoord + ',' + data[i].radius + ');return false;" title="'
						+ OpenLayers.i18n("KEY_ZOEKEN_LINK_TTL", {
							'0' : '' + data[i].addressString
						}) + '">' + data[i].addressString + '</a></li>';
			}
			html += '</ul>';
			Viewer.zoomTo(data[data.length - 1].xCoord, data[data.length - 1].yCoord, data[data.length - 1].radius);
		}
		paragraaf.empty().html(html);
	},
};
