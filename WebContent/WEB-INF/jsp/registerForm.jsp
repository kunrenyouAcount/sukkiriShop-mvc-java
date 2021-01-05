<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="/sukkiriShop/RegisterFormServlet" method="post">
<label><dl><dt>ユーザーID：</dt><dd><input type="text" name="userId"></dd></dl></label>
<label><dl><dt>パスワード：</dt><dd><input type="password" name="pass"></dd></dl></label>
<label><dl><dt>メールアドレス：</dt><dd><input type="email" name="mail"></dd></dl></label>
<label><dl><dt>氏名：</dt><dd><input type="text" name="name"></dd></dl></label>
<label><dl><dt>年齢：</dt><dd><input type="number" name="age">歳</dd></dl></label>
<input type="submit" value="確認">
</form>
</body>
</html>