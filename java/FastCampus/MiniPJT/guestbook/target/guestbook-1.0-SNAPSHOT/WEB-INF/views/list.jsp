<%--
  Created by IntelliJ IDEA.
  User: crazy
  Date: 18. 10. 2
  Time: 오전 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>list</h1>
    <a href="/guestbook/login">관리자 로그인</a>
    <a href="/guestbook/logout">관리자 로그아웃</a>
    <br><br>

    <form method="post" action="/guestbook/write">
        이름 : <input type="text" name="name"><br>
        내용 : <br>
        <textarea name="content" id="content" cols="30" rows="10"></textarea>
        <input type="submit">
    </form>

    <!-- 방명록을 출력한다.(html 폼 태그) -->
    이름 : 홍길동 <br>
    내용 : 자바가 ... <br>
    <a href="/guestbook/delete?id=1">삭제</a><br><br>
    이름 : 고길동 <br>
    내용 : 하하  ... <br>
    <a href="/guestbook/delete?id=2">삭제</a><br>
</body>
</html>
