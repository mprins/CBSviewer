beforeEach(function() {
	this.addMatchers({
		/**
		 * A matcher that tests for instanceof.
		 * 
		 * @param type
		 * @returns {Boolean} true when actual is an instance of expected
		 */
		toBeInstanceOf : function(type) {
			var actual = this.actual;
			var notText = this.isNot ? "not" : "";

			this.message = function() {
				return "Expected " + actual + " to " + notText + " be instance of " + expected;
			};

			return this.actual instanceof type;
		}
	});
});
