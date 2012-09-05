<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Hello world</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/print.css" type="text/css"
	media="print" />
<!--[if lte IE 7]>
		<link rel="stylesheet" href="static/css/ie.css" type="text/css" media="all" />
<![endif]-->
<!--[if gte IE 8]>
		<link rel="stylesheet" href="static/css/ie-8.css" type="text/css" media="all" />
<![endif]-->
<script type="text/javascript">
	document.documentElement.className += ' js';
</script>

</head>
<body>
	<h1>Hello World!</h1>

	<div id="kaart" class="kaart"></div>

	<%-- scripts als laatste laden --%>
	<script type="text/javascript" src="lib/OpenLayers.js"></script>
	<script type="text/javascript" src="lib/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="js/cbsviewer.js"></script>
	<script type="text/javascript" src="js/config.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
