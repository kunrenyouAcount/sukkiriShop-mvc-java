<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userID = (String)session.getAttribute("userID");
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
<% if(userID == null) { %>
	<h1>ログイン失敗</h1>
	<h5>情報が登録されていないか、正しくありません。</h5>
	<a href="/sukkiriShop/LoginServlet"><button class="btn btn-secondary">ログインページへ</button></a>
<% } else { %>
	<% userID = (String) userID; %>
	<h1>ログイン完了</h1>
	<h5>ようこそ<span style="font-weight: bold; font-size: 25px; text-decoration:underline solid black "><%= userID %></span>さん</h5>
<% } %>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
</div>
</body>
</html>