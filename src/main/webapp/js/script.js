jQuery(document).ready(function(){
	// create map
	Viewer.create(config);
});

var setupPage = {
		init: function(){
			OpenLayers.Lang.setCode('nl');
		}
}

setupPage.init();