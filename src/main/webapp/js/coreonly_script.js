/**
 * @fileoverview event handlers en elementen voor de core pagina.
 */
var setupPage = {
	init : function() {
		// terug naar RIA link toevoegen aan de kaart
		// var url = '' + window.location;
		var url = 'index.jsp';
		// url = url.replace(/coreonly/g, 'corefalse');
		document.getElementById('kaartContainer').innerHTML = '<a href="' + url + '" id="coreexitlink">'
				+ RIA_LINK_TEXT + '</a>';
		document.getElementById('kaartContainer').className = 'kaartContainer nothidden';
	}
};

setupPage.init();