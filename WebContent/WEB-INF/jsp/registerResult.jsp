<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%
User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<link rel="stylesheet" href="/sukkiriShop/css/general.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<% if(user == null) { %>
	<h1>登録失敗</h1>
	<p>登録に失敗しました</p>
<a href="/sukkiriShop/RegisterFormServlet"><button class="btn btn-secondary">ユーザー登録へ</button></a>
<%} else { %>
	<h1>登録完了</h1>
	<p>登録完了しました</p>
<% } %>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
</div>
</body>
</html>