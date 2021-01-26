<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
List<Product> productList = (List<Product>) request.getAttribute("productList");
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
<h1>商品一覧</h1>
<table class="table">
	<thead>
	    <tr>
		  <th scope="col">商品画像</th>
	      <th scope="col">商品名</th>
	      <th scope="col">単価</th>
	      <th scope="col">商品数</th>
	    </tr>
  </thead>
  <tbody>
<% for(Product product: productList) { %>
			<tr>
					<td><a href="/sukkiriShop/ProductViewServlet?selectedProductID=<%= product.getProductID()%>"><img class="img100" src="/sukkiriShop/uploadImage/<%= product.getProductImage() %>"/></a></td>
					<td><a href="/sukkiriShop/ProductViewServlet?selectedProductID=<%= product.getProductID()%>"><%= product.getProductName() %></a></td>
					<td><%= product.getProductPrice() %></td>
					<td><%= product.getProductCount() %></td>
			</tr>
<% } %>
	</tbody>
</table>
<a href="/sukkiriShop/CartServlet"><button class="btn btn-primary">カートへ</button></a>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-secondary">トップへ</button></a>
</div>
</body>
</html>