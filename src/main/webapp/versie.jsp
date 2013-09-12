<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		import="java.io.File,java.util.jar.Manifest,java.io.FileInputStream,java.util.jar.Attributes,java.util.Date,nl.mineleni.cbsviewer.util.LabelsBundle"
		session="false" trimDirectiveWhitespaces="true" isErrorPage="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		omit-xml-declaration="no" />

	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">

<jsp:scriptlet>/* info uitlezen/ophalen uit de manifest */
			String appServerHome = getServletContext().getRealPath("/");
			File manifestFile = new File(appServerHome, "META-INF/MANIFEST.MF");
			Manifest mf = new Manifest();
			mf.read(new FileInputStream(manifestFile));
			Attributes atts = mf.getMainAttributes();
			org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("nl.mineleni.cbsviewer");</jsp:scriptlet>
<head>
<jsp:include page="WEB-INF/jsp/head_include.jsp" />

<title>Versie informatie voor <jsp:expression>atts.getValue("Implementation-Title")</jsp:expression>
	<jsp:expression>atts.getValue("Implementation-Version")</jsp:expression>.<jsp:expression>atts.getValue("Implementation-Build")</jsp:expression>
</title>
</head>
<jsp:body>
	<h1><jsp:expression>atts.getValue("Implementation-Title")</jsp:expression></h1>
	<hr />
	Versie: <jsp:expression>atts.getValue("Implementation-Version")</jsp:expression>
	<br />
	Build: <jsp:expression>atts.getValue("Implementation-Build")</jsp:expression>
	<br />
	Release: <jsp:expression>atts.getValue("release")</jsp:expression> (SCM revisie: <jsp:expression>atts.getValue("SCM-Revision")</jsp:expression>)
	<br />
	OpenLayers versie: <jsp:expression>atts.getValue("OpenLayers-Version")</jsp:expression>
	<hr />

	<jsp:scriptlet>if (logger.isDebugEnabled()) {</jsp:scriptlet>
		Deze applicatie draait op host: <jsp:expression>request.getLocalAddr()</jsp:expression>:<jsp:expression>request.getLocalPort()</jsp:expression> (<jsp:expression>request.getLocalName()</jsp:expression>)
		en is benaderd vanaf: <jsp:expression>request.getRemoteAddr()</jsp:expression>:<jsp:expression>request.getRemotePort()</jsp:expression> (<jsp:expression>request.getRemoteHost()</jsp:expression>) op <jsp:expression>new Date()</jsp:expression>
		<br />
		Server info: <jsp:expression>getServletContext().getServerInfo()</jsp:expression>
		<br />
		Java Servlet API <jsp:expression>getServletContext().getMajorVersion()</jsp:expression>.<jsp:expression>getServletContext().getMinorVersion()</jsp:expression>
	<jsp:scriptlet>}</jsp:scriptlet>
</jsp:body>
	</html>
</jsp:root>