<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실행 오류!</title>
</head>
<body>
<h1>오류 발생!</h1>
<pre>
<%
Throwable error = (Throwable)request.getAttribute("error");
error.printStackTrace(new PrintWriter(out));
%>
</pre>
</body>
</html>