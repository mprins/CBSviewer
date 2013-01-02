/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
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
			beforeSubmit: this.handleBeforeSubmit,
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
	 * Controleren of het formulier juist is ingevuld.
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
	handleBeforeSubmit : function($form, options) {
		if (jQuery('#adres[title]').val() === jQuery('#adres').attr('title')){
			return false;
		}
		return true;
	},
	
	/**
	 * Actief maken van de geselecteerde zoekknop
	 * 
	 * @param {id}
	 *            button id
	 * 
	 * @private
	 */
	toggleSelectedButton : function(id) {
		jQuery('.adreslijst').find('li a').removeClass("selected");
		jQuery("#button" + id).addClass('selected');
	},
	
	/**
	 * Tonen van een placeholder in het zoek veld
	 * Dit kan vanaf html5 ook met het placeholder attribuut alleen deze komt niet door de W3C check
	 *
	 * @param props
	 *
	 * @private
	 */
	addPlaceholders: function(props) {
		//jQuery.extend($.support, {
		//	placeHolder: !!(jQuery('#adres', zoekFormulier)[0].placeholder !== undefined || jQuery('#adres', zoekFormulier)[0].placeHolder !== undefined)
		//});

		// create placeholders by using "value" attribute
		//if (!jQuery.support.placeHolder) {
	
			var placeholder = jQuery('#adres').attr('title');
			jQuery('#adres[title]').bind({
				'focus': function() {
					if (jQuery(this).val() === placeholder) {
						jQuery(this).val('');
						jQuery(this).removeClass('adresEmpty');
					}
					jQuery(this).attr('data-focused', 'yes');
				},

				'blur': function() {
					if (jQuery(this).val() === '') {
						jQuery(this).val(placeholder);
						jQuery(this).addClass('adresEmpty');
					}
					jQuery(this).removeAttr('data-focused');
				}
			});

			// only add placeholder on load when value is empty or placeholder or input is not focused (focus is preserved while reloading/XHR)
			if (((jQuery('#adres').val() === '') || (jQuery('#adres').val() === placeholder)) && (!jQuery('#adres').attr('data-focused'))) {
				jQuery('#adres').val(placeholder);
				jQuery('#adres').addClass('adresEmpty');
			}
		//}
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
			Viewer.featureInfo(data[0].xCoord, data[0].yCoord);
			break;
		default:
			// html += '<p style="clear:both">' + OpenLayers.i18n("KEY_ZOEKEN_MEER_ADRES") + '</p>';
			html += '<ul class="adreslijst">';

			for ( var i = 0; i < data.length; i++) {
				// lijst met list items aanmaken waarvan de eerste 'geselecteerd' is
				var selected = "";
				if (i === 0) {
					selected = " selected";
				}
				html += '<li><a id="button' + i + '" class="button' + selected
						+ '" href="#" onclick="ZoekFormulier.toggleSelectedButton(' + i + ');Viewer.zoomTo('
						+ data[i].xCoord + ',' + data[i].yCoord + ',' + data[i].radius + ');Viewer.featureInfo('
						+ data[i].xCoord + ',' + data[i].yCoord+');return false;" title="'
						+ OpenLayers.i18n("KEY_ZOEKEN_LINK_TTL", {
							'0' : '' + data[i].addressString
						}) + '">' + data[i].addressString + '</a></li>';
			}
			
			html += '</ul>';
			// inzoomen op het 'geselecteerde' (== eerste) adres
			Viewer.zoomTo(data[0].xCoord, data[0].yCoord, data[0].radius);
			Viewer.featureInfo(data[0].xCoord, data[0].yCoord);
		}
		paragraaf.empty().html(html);
	}
};