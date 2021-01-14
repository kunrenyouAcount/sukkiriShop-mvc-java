<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
List<Product> productList = (List<Product>) request.getAttribute("productList");
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
<h1>商品一覧</h1>
<ul class="list-group">
<% for(Product product: productList) { %>
	<a href="/sukkiriShop/ProductViewServlet?selectedProductId=<%= product.getId()%>"><li class="list-group-item">・商品名：<%= product.getName() %>/価格：<%= product.getPrice() %></li></a>
<% } %>
</ul>
</div>
</body>
</html>