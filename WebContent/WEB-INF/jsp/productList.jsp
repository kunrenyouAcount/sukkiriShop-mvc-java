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
<form class="form-group" action="/sukkiriShop/CartServlet" method="post">
<% for(Product product: productList) { %>
	<input type="radio" name="selectedProductId" value="<%= product.getId() %>"><%= product.getId() %>商品名：<%= product.getName() %>, 価格：<%= product.getPrice() %>, 数量：<%= product.getCount() %><br />
<% } %>
	<button type="submit" class="btn btn-warning">カートに入れる</button>
</form>
</div>
</body>
</html>