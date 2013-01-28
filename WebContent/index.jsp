<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%
	System.out.println("Hello from " + System.getenv("VCAP_APP_HOST")
			+ ":" + System.getenv("VCAP_APP_PORT"));
%>
</body>
</html>