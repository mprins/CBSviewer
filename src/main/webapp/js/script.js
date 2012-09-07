jQuery(document).ready(function() {
	// create map
	Viewer.init(config);
});

var setupPage = {
	init : function() {
		OpenLayers.Lang.setCode('nl');
	}
};

setupPage.init();