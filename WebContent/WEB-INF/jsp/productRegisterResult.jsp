<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Product" %>
<%
Product product = (Product) session.getAttribute("product");
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
<% if(product == null) { %>
	<h1>登録完了</h1>
	<h5>登録が完了しました。</h5>
	<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
<% } else { %>
	<h1>登録失敗</h1>
	<h5>登録に失敗しました。再度登録ボタンを押してください</h5>
	<a href="/sukkiriShop/ProductRegisterServlet"><button class="btn btn-primary">登録</button></a>
<% } %>
</div>
</body>
</html>