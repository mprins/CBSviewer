$(function() {
	function log(message) {

		$("<div>").text(message).prependTo("#log");
		$("#log").scrollTop(0);
	}

	$('#adres').autocomplete(
			{
				source : function(request, response) {
					$.ajax({
						url : 'adres',
						data : {
							adres : request.term,
							forward : false,
							format : 'json',
							coreonly : false
						},
						dataType : 'json'
					}).success(function(data) {
						var results = $.map(data, function(val, i) {
							return {
								label : val.addressString,
								x : val.xCoord,
								y : val.yCoord,
								r : val.radius
							};
						});
						response(results);
					});
				},

				minLength : 4,

				select : function(event, ui) {
					log(ui.item ? "Gekozen: " + ui.item.value + " (x,y,r) " + ui.item.x + "," + ui.item.y + ","
							+ ui.item.r : "Niets gekozen, de input was " + this.value);
				}

			});
});