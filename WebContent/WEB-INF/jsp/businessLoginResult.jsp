<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Business" %>
<%
String businessID = (String) session.getAttribute("businessID");
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
<% if(businessID == null) { %>
	<h1>ログイン失敗</h1>
	<h5>情報が登録されていないか、正しくありません。</h5>
	<a href="/sukkiriShop/BusinessLoginServlet"><button class="btn btn-secondary">ログインページへ</button></a>
<% } else { %>
	<h1>ログイン完了</h1>
	<h5>ようこそ<span style="font-weight: bold; font-size: 25px; text-decoration:underline solid black "><%= businessID %></span>さん</h5>
<% } %>
<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
</div>
</body>
</html>