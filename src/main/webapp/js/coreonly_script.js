/**
 * dynamische elementen aan de pagina toevoegen.
 */
var setupPage = {
	init : function() {
		// terug naar RIA link toevoegen aan de kaart
		var url = '' + window.location;
		url = url.replace(/coreonly/g, 'corefalse');
		document.getElementById('kaartContainer').innerHTML = '<a href="' + url
				+ '" id="coreexitlink">Ga naar de interactieve kaartversie.</a>';
		document.getElementById('kaartContainer').className = 'kaartContainer nothidden';
	}
};

setupPage.init();