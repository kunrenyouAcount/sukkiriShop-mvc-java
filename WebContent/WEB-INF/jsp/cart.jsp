<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
List<Product> cart = (List<Product>) session.getAttribute("cart");
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
<h1>商品カート</h1>
<% if(cart == null) { %>
	<p>カートが空です</p>
<% } else { %>
	<table class="table"	>
	<thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">商品名</th>
	      <th scope="col">単価</th>
	      <th scope="col">数量</th>
	      <th scope="col">小計</th>
	    </tr>
  </thead>
  <tbody>
  <% int cartSumPrice = 0; %>
	<% for(int i = 0; i < cart.size(); i++) { %>
		<% Product product = cart.get(i); %>
		<tr>
			<th><%= i+1 %></th>
			<td><%= product.getProductName() %></td>
			<td><%= product.getProductPrice() %></td>
			<td><%= product.getProductCount() %></td>
			<% int productSumPrice = product.getProductPrice() * product.getProductCount();  %>
			<td><%= productSumPrice %></td>
			<% cartSumPrice += productSumPrice; %>
		</tr>
	<% } %>
	<tr class="table-primary">
		<th colspan="4">合計金額</th>
		<td><%= cartSumPrice %></td>
	</tr>
	</tbody>
	</table>
<% } %>
<div>
	<a href="/sukkiriShop/ProductListServlet"><button class="btn btn-secondary">続けて商品を見る</button></a>
	<a href="/sukkiriShop/PurchaseServlet"><button class="btn btn-primary">購入する</button></a>
</div>
</div>
</body>
</html>