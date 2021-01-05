<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account account = (Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h1>登録確認画面</h1>
<form action="/sukkiriShop/RegisterServlet" method="get">
<label><dl><dt>ユーザーID：</dt><dd><%= account.getUserId() %></dd></dl></label>
<label><dl><dt>パスワード：</dt><dd><%= account.getPass() %></dd></dl></label>
<label><dl><dt>メールアドレス：</dt><dd><%= account.getMail() %></dd></dl></label>
<label><dl><dt>氏名：</dt><dd><%= account.getName() %></dd></dl></label>
<label><dl><dt>年齢：</dt><dd><%= account.getAge() %>歳</dd></dl></label>
<input type="submit" name="btn" value="登録">
<input type="submit" name="btn" value="修正">
</form>
</body>
</html>