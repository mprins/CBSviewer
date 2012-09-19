<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    //bepaal de exception: ik weet niet meer precies waarom dit meestal werkt.
    Throwable t = (exception != null) ? exception : (Throwable) request
            .getAttribute("javax.servlet.error.exception");

    //log de exception en de timestamp
    org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger("ERROR.JSP");
    if (t != null) {
        logger.error(t.getMessage(), t);
    }
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
	<p>
		<%
		    t.getMessage();
		%>
	</p>
	<hr />
	<p>
		<%
		    t.printStackTrace();
		%>
	</p>
</body>
</html>


