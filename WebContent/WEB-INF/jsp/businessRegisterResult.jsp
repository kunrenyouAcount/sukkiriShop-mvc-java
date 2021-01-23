<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Business" %>
<%
Business business = (Business) session.getAttribute("business");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<link rel="stylesheet" href="/sukkiriShop/css/business.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<% if(business == null) { %>
	<h1>登録失敗</h1>
	<p>登録に失敗しました</p>
<a href="/sukkiriShop/RegisterFormServlet"><button class="btn btn-secondary">ユーザー登録へ</button></a>
<%} else { %>
	<h1>登録完了</h1>
	<p>登録完了しました</p>
<% } %>
<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
</div>
</body>
</html>