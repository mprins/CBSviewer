<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false"
		trimDirectiveWhitespaces="false" language="java" isThreadSafe="false"
		isErrorPage="false" />

	<fmt:setBundle basename="MenuLabelsBundle" />

	<div class="dropDownMenu">
	<!--a id="skipNavigation"></a-->
	<ul class="siteNavigation">
		<li id="toplevel" class="sectionTheme">
			<a href="#thememenu" id="hasMenu"><fmt:message key="KEY_MAINBUTTON_LABEL" /><span><fmt:message key="KEY_SELECTMENU_DEFAULT_HOVER" /></span></a>
			<div class="navDropDown">
				<ol class="navCategories">
					<li id="thememenu">
						<a href="#thememenu"><fmt:message key="KEY_FILTER_THEME" /><span><fmt:message key="KEY_FILTER_THEME_TOOLTIP" /></span></a>
						<jsp:include page="main_menu_theme_include.jsp"/>
					</li>
					<li id="yearmenu">
						<a href="#yearmenu"><fmt:message key="KEY_FILTER_YEAR" /><span><fmt:message key="KEY_FILTER_YEAR_TOOLTIP" /></span></a>
						<jsp:include page="main_menu_year_include.jsp"/>
					</li>
					<li id="layermenu">
						<a href="#layermenu"><fmt:message key="KEY_FILTER_LAYER" /><span><fmt:message key="KEY_FILTER_LAYER_TOOLTIP" /></span></a>
						<jsp:include page="main_menu_layer_include.jsp"/>
					</li>
					<li id="infobox"></li>
				</ol>
				<a href="#closemega" class="closeMega">Sluit</a>
			</div>
		</li>
	</ul>
</div>

</jsp:root>
