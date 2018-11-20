<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<html>
<body>
사용자가 만든 로그인 화면.
<br>
<form method="post" action="/members/login">
    email : <input type="text" name="id"><br>
    password : <input type="password" name="password"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
</body>
</html>