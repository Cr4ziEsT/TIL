<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
</head>
<body>
<h1>List</h1>
<br>

<%-- �� �Ǿ� �о �����ֱ� ���� --%>
<c:forEach items="${boards}" var="board">
    ${board.title}<br>
</c:forEach>
<br>

<a href="/boards/writeform">�۾���</a>
</body>
</html>