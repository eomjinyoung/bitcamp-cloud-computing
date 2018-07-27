<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${param.a} ${param.op} ${param.b} =
<c:choose>
  <c:when test="${param.op == '+'}">${param.a + param.b}</c:when>
  <c:when test="${param.op == '-'}">${param.a - param.b}</c:when>
  <c:when test="${param.op == '*'}">${param.a * param.b}</c:when>
  <c:when test="${param.op == '/'}">${param.a / param.b}</c:when>
  <c:otherwise>해당 연산을 지원하지 않습니다.</c:otherwise>
</c:choose>
<%
Thread.currentThread().sleep(10000);
%>