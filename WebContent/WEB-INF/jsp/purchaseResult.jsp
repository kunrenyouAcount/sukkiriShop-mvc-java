<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
Object cart = session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<% if(cart == null) { %>
	<h1>購入完了</h1>
	<p>購入が完了しました。</p>
<% } else {%>
	<h1>購入失敗</h1>
	<p>購入が失敗しました。</p>
<% } %>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-secondary">トップへ</button></a>
</div>
</body>
</html>