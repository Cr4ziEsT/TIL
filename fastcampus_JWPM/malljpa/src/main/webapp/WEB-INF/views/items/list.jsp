<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list</title>
</head>
<body>
<h1>list</h1>
<br>

<div align="center">
<b> 상품 리스트</b>
    <table border="0" width="100%">
        <tr bgcolor="white">
            <td align="right"><a href="/logout">logout</a> </td>
        </tr>

    <c:set var="i" value="0"/>
    <c:set var="j" value="3"/>
    <table border="1">
        <tr>
        <c:forEach items="${items}" var="item">
            <c:if test="${i%j == 0}"> <tr> </c:if>

                <td align="center">
                    <a href="items/${item.id}"><img src="${item.mainImagePath}" width="200" height="300"></a>
                    <a href="items/${item.id}"><h3 align="center">${item.name}</h3></a>
                    <h4 align="center">${item.money}원</h4>
                </td>
            <c:if test="${i%j == j-1}"> </tr> </c:if>
            <c:set var="i" value="${i+1}"/>
        </c:forEach>
    </table>
</div>

</body>
</html>
