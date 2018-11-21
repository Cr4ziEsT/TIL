<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<html>
<body>
<h1>회원가입</h1>

<br>
<form method="post" action="/members/signup">
    이름 : <input type="text" name="id"><br>
    생년월일 : <input type="password" name="password"><br>
    성별 : <input type="text" name="brithDay"><br>
    전화번호 : <input type="number" name="phoneNum"><br>
    이메일 : <input type="email" name="email"><br>
    닉네임 : <input type="text" name="nickname"><br>
    비밀번호 : <input type="password" name="password"><br>
    집 주소 : <input type="text" name="homeAddress"><br>
    우편번호 : <input type="number" name="zipCode"><br>
    키 : <input type="number" name="height"><br>
    몸무게 : <input type="number" name="weight"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
</body>
</html>
</body>
</html>