<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <div>${requestScope.msg}</div>
    <div>
        <form action="/user/join" method="post">
            <div>아이디 : <input type="text" name="uid" placeholder="아이디를 입력해주세요" required></div>
            <div>비밀번호 : <input type="password" name="upw" placeholder="비밀번호를 입력해주세요" required></div>
            <div>이름 : <input type="text" name="nm" placeholder="이름을 입력해주세요"></div>
            <div>
                <label>여자<input type="radio" value="2" name="gender" checked></label>
                <label>남자<input type="radio" value="1" name="gender"></label>
            </div>
            <div>
                <input type="submit" value="가입">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>
</body>
</html>