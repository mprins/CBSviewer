/**
 * Jasmine Unit tests voor CookieUtil.
 * 
 * @author mprins
 */
describe('CookieUtil', function() {
	var _svalue = 'Cookie.MapID_testwaarde';

	describe('COOKIE keys test', function() {
		it('Opgeslagen cookie bestaat en heeft de juiste waarde', function() {
			setCookie(COOKIE.mapId, _svalue);
			expect(getCookie(COOKIE.mapId)).toEqual(_svalue);
		});

		it('Niet bestaande cookie opvragen geeft waarde null', function() {
			expect(getCookie(Math.random())).toBeNull();
		});
	});

	describe('Benoemde cookie wissen', function() {
		it('Gewiste cookie opvragen geeft waarde null', function() {
			eraseCookie(COOKIE.mapId);
			expect(getCookie(COOKIE.mapId)).toBeNull();
		});
	});

	describe('Cookies wissen', function() {
		it('Gewiste cookies opvragen geeft waarde null', function() {
			setCookie(COOKIE.mapId, "a");
			eraseCookies();
			expect(getCookie(COOKIE.mapId)).toBeNull();
			expect(getCookie(COOKIE.baselyr)).toBeNull();
			expect(getCookie(COOKIE.x)).toBeNull();
		});
	});
});