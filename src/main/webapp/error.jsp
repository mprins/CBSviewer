<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%
	//log de exception en de timestamp
	org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger("ERROR.JSP");
	logger.error(exception.getLocalizedMessage(), exception);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Systeemfout</title>


<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

<!--[if lte IE 7]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" media="all" />
	<![endif]-->
<!--[if gte IE 8]>
		<link rel="stylesheet" href="css/ie-8.css" type="text/css" media="all" />
	<![endif]-->

<link rel="stylesheet" href="css/print.css" type="text/css"
	media="print" />

</head>
<body>
	<h1>Systeemfout</h1>
	<p class="error">
		<%=exception.getLocalizedMessage()%>
	</p>

	<%
		if (logger.isDebugEnabled()) {
	%>
	<p><code>
		<%
			exception.printStackTrace(new java.io.PrintWriter(out));
		%>
	</code></p>
	<%
		}
	%>
</body>
</html>
