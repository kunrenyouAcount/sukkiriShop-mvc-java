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
	#showProductAddButton {
		display: none;
	}
	#WelcomeViewButton{
		display:inline;
	}
	#logoutButton {
		display:none;
	}
<% } else { %>
	#registerButton {
		display: none;
	}
	#loginButton {
		display: none;
	}
	#showProductAddButton {
		display: inline;
	}
	#WelcomeViewButton{
		display:none;
	}
	#logoutButton {
		display:inline;
	}
<% } %>
</style>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<link rel="stylesheet" href="/sukkiriShop/css/business.css">
</head>
<body>
<div class="container">
<h1 class="text-center">ビジネス用スッキリ商店</h1>
<a href="/sukkiriShop/WelcomeServlet" id="WelcomeViewButton" class="fixed-top" style="left:initial;"><button class="btn btn-secondary">一般用はこちら</button></a>
<a href="/sukkiriShop/BusinessLogoutServlet" id="logoutButton" class="fixed-top" style="left:initial;"><button class="btn btn-secondary">ログアウト</button></a>
<ul class="list-group text-center">
<li class="list-group-item p-5"><img src="/sukkiriShop/img/shoppingCartGreen_256.png"/></li>
<a href="/sukkiriShop/BusinessRegisterFormServlet" style="color: white" id="registerButton"><li class="list-group-item active">ユーザー登録</li></a>
<a href="/sukkiriShop/BusinessLoginServlet" id="loginButton"><li class="list-group-item">ログイン</li></a>
<a href="/sukkiriShop/BusinessProductListServlet" style="color: white" id="showProductAddButton"><li class="list-group-item active">商品を追加する</li></a>
</ul>
</div>
</body>
</html>