<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<html>
<body>
<h1>ȸ������</h1>

<br>
<form method="post" action="/members/signup">
    �̸� : <input type="text" name="id"><br>
    ������� : <input type="password" name="password"><br>
    ���� : <input type="text" name="brithDay"><br>
    ��ȭ��ȣ : <input type="number" name="phoneNum"><br>
    �̸��� : <input type="email" name="email"><br>
    �г��� : <input type="text" name="nickname"><br>
    ��й�ȣ : <input type="password" name="password"><br>
    �� �ּ� : <input type="text" name="homeAddress"><br>
    �����ȣ : <input type="number" name="zipCode"><br>
    Ű : <input type="number" name="height"><br>
    ������ : <input type="number" name="weight"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit">
</form>
</body>
</html>
</body>
</html>