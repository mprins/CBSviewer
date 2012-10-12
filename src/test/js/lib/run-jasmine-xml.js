/**
 * @fileoverview A Jasmine testrunner for headless testing with PhantomJS. Based
 *               on work by Ivan De Marino.
 * @see https://github.com/detro/phantomjs-jasminexml-example
 */
var htmlrunner, resultdir, page, fs;

// Namespace "utils.core"
var utils = utils || {};
utils.core = utils.core || {};

/**
 * Wait until the test condition is true or a timeout occurs. Useful for waiting
 * on a server response or for a ui change (fadeIn, etc.) to occur.
 * 
 * @param check
 *            javascript condition that evaluates to a boolean.
 * @param onTestPass
 *            what to do when 'check' condition is fulfilled.
 * @param onTimeout
 *            what to do when 'check' condition is not fulfilled and 'timeoutMs'
 *            has passed
 * @param timeoutMs
 *            the max amount of time to wait. Default value is 3 seconds
 * @param freqMs
 *            how frequently to repeat 'check'. Default value is 250
 *            milliseconds
 */
utils.core.waitfor = function(check, onTestPass, onTimeout, timeoutMs, freqMs) {
	var timeoutMs = timeoutMs || 3000, // < Default Timeout is 3s
	freqMs = freqMs || 250, // < Default Freq is 250ms
	start = Date.now(), condition = false, timer = setTimeout(function() {
		var elapsedMs = Date.now() - start;
		if ((elapsedMs < timeoutMs) && !condition) {
			// If not time-out yet and condition not yet fulfilled
			condition = check(elapsedMs);
			timer = setTimeout(arguments.callee, freqMs);
		} else {
			clearTimeout(timer); // < house keeping
			if (!condition) {
				// If condition still not fulfilled (timeout but condition is
				// 'false')
				onTimeout(elapsedMs);
			} else {
				// Condition fulfilled (timeout and/or condition is 'true')
				onTestPass(elapsedMs);
			}
		}
	}, freqMs);
};

if (phantom.args.length !== 2) {
	console.log("Usage: phantom_test_runner.js HTML_RUNNER RESULT_DIR");
	phantom.exit();
} else {
	htmlrunner = phantom.args[0];
	resultdir = phantom.args[1];
	page = require("webpage").create();
	fs = require("fs");

	// Echo the output of the tests to the Standard Output
	page.onConsoleMessage = function(msg, source, linenumber) {
		console.log(msg);
	};

	// set viewport
	page.viewportSize = {
		width : 1024,
		height : 787
	};

	page.open(htmlrunner, function(status) {
		if (status === "success") {
			utils.core.waitfor(function() { // wait for this to be true
				return page.evaluate(function() {
					return typeof (jasmine.phantomjsXMLReporterPassed) !== "undefined";
				});
			}, function() { // once done...
				// Retrieve the result of the tests
				var f = null, i, len;
				suitesResults = page.evaluate(function() {
					return jasmine.phantomjsXMLReporterResults;
				});

				// Save the result of the tests in files
				for (i = 0, len = suitesResults.length; i < len; ++i) {
					try {
						f = fs.open(resultdir + '/' + suitesResults[i]["xmlfilename"], "w");
						f.write(suitesResults[i]["xmlbody"]);
						f.close();
					} catch (e) {
						console.log(e);
						console.log("phantomjs> Unable to save result of Suite '" + suitesResults[i]["xmlfilename"]
								+ "'");
					}
				}

				// Return the correct exit status. '0' only if all the tests
				// passed
				phantom.exit(page.evaluate(function() {
					return jasmine.phantomjsXMLReporterPassed ? 0 : 1; // <
					// exit(0) is success, exit(1) is failure
				}));
			}, function() { // or, once it times out...
				phantom.exit(1);
			});
		} else {
			console.log("phantomjs> Could not load '" + htmlrunner + "'.");
			phantom.exit(1);
		}
	});
}
