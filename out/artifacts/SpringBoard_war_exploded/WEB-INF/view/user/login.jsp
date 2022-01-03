<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>로그인</h1>
    <div>${requestScope.msg}</div>
    <div>
        <form action="/user/login" method="post">
            <div><input type="text" name="uid" placeholder="id"></div>
            <div><input type="password" name="upw" placeholder="password"></div>
            <div><input type="submit" value="login"></div>
        </form>
    </div>
    <div>
        <a href="/user/join">Join</a>
    </div>
</body>
</html>