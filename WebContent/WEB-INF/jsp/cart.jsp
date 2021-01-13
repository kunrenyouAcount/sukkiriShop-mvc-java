<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
List<Product> cart = (List<Product>) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css"  crossorigin="anonymous">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<h1>商品カート</h1>
<ul class="list-group">
<% if(cart == null) { %>
	<p>カートが空です</p>
<% } else { %>
	<% for(Product product: cart) { %>
		<li class="list-group-item"><%= product.getId() %>商品名：<%= product.getName() %>, 価格：<%= product.getPrice() %></li>
	<% } %>
<% } %>
</ul>
<div>
	<a href="/sukkiriShop/ProductListServlet"><button class="btn btn-primary">続けて商品を見る</button></a>
	<a href="/sukkiriShop/PurchaseServlet"><button class="btn btn-danger">購入する</button></a>
</div>
</div>
</body>
</html>