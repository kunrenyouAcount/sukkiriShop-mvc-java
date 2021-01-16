<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login,  java.util.List" %>
<%
String businessID = (String) session.getAttribute("businessID");
%>
<!DOCTYPE html>
<html>
<head>
<style>
<% if(businessID == null) {%>
	#registerButton {
		display: inline;
	}
	#loginButton {
		display: inline;
	}
	#showProductListButton {
		display: none;
	}
<% } else { %>
	#registerButton {
		display: none;
	}
	#loginButton {
		display: none;
	}
	#showProductListButton {
		display: inline;
	}
<% } %>
</style>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
</head>
<body>
<div class="container">
<h1 class="text-center">ビジネス用スッキリ商店</h1>
<a href="/sukkiriShop/WelcomeServlet" id="WelcomeViewButton" class="fixed-top" style="left:initial;"><button class="btn btn-secondary">一般用はこちら</button></a>
<ul class="list-group text-center">
<li class="list-group-item p-5"><img src="/sukkiriShop/img/shoppingCartGreen_256.png"/></li>
<a href="/sukkiriShop/BusinessRegisterFormServlet" style="color: white" id="registerButton"><li class="list-group-item active" style="background-color: green;">ユーザー登録</li></a>
<a href="/sukkiriShop/BusinessLoginServlet" id="loginButton"><li class="list-group-item" style="color: green">ログイン</li></a>
<a href="/sukkiriShop/ProductListServlet" style="color: white" id="showProductListButton"><li class="list-group-item active" style="color: green">商品を見る</li></a>
</ul>
</div>
</body>
</html>