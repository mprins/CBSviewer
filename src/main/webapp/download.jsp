<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" version="2.1">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="false"
		language="java" isThreadSafe="false" isErrorPage="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<fmt:setBundle basename="DownloadLabelsBundle" />

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<title><fmt:message key="KEY_PAG_TITEL" /></title>
</head>
<body>
	<div class="page smallpopup">
		<h1>
			<fmt:message key="KEY_PAG_TITEL" />
		</h1>

		<p>
			<fmt:message key="KEY_HEADER_SUBTITLE" />
		</p>
		
		<table class="download">
		  <tr>
			<th colspan="2"><fmt:message key="KEY_TABLE_HEADER" /></th>
		  </tr>
		  <tr class="yellow"> 
			<td><fmt:message key="KEY_TABLE_COLUMNHEADER1" /></td>
			<td><fmt:message key="KEY_TABLE_COLUMNHEADER2" /></td>
			<td><fmt:message key="KEY_TABLE_COLUMNHEADER3" /></td>
		  </tr>		  	  
		  <tr> 
			<td><a href="http://www.cbs.nl/nl-NL/menu/themas/dossiers/nederland-regionaal/links/2013-wijk-en-buurtkaart-2012-versie-1.htm">Gemeente, wijk- en buurtkaart 2012</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>57 MB</td>
		  </tr>		  
		  <tr> 
			<td><a href="http://www.cbs.nl/nl-NL/menu/themas/dossiers/nederland-regionaal/links/2013-wijk-en-buurtkaart-2011-versie-2.htm">Gemeente, wijk- en buurtkaart 2011</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>57 MB</td>
		  </tr>
		  <tr> 
			<td><a href="http://www.cbs.nl/nl-NL/menu/themas/dossiers/nederland-regionaal/links/2013-wijk-en-buurtkaart-2010-versie-3.htm">Gemeente, wijk- en buurtkaart 2010</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>32 MB</td>
		  </tr>
		  <tr> 
			<td><a href="http://www.cbs.nl/nl-NL/menu/themas/dossiers/nederland-regionaal/links/2012-wijk-en-buurtkaart-2009-3-el.htm">Gemeente, wijk- en buurtkaart 2009</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>11 MB</td>
		  </tr>
		  <tr> 
			<td><a href="http://www.cbs.nl/nl-NL/menu/themas/dossiers/nederland-regionaal/links/2012-bevolkingskernen-2008-el.htm">Bevolkingskernen 2008</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>8 MB</td>
		  </tr>
		  <tr> 
			<td><a href="http://download.cbs.nl/regionale-kaarten/2012-cbs-vierkant-100m.zip">Vierkanten 100 meter bij 100 meter</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>106 MB</td>
		  </tr>
		  <tr> 
			<td><a href="http://download.cbs.nl/regionale-kaarten/2012-cbs-vierkant-500m.zip">Vierkanten 500 meter bij 500 meter</a></td>
			<td><fmt:message key="KEY_TABLE_FILETYPE" /></td>
			<td>8 MB</td>
		  </tr>
		</table>
	</div>
	<c:if test="${param.coreonly==true}">
		<jsp:include page="WEB-INF/jsp/footer_include.jsp" />
	</c:if>
</body>
	</html>
</jsp:root>