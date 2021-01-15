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
<table class="table">
	<thead>
	    <tr>
	      <th scope="col">商品名</th>
	      <th scope="col">単価</th>
	      <th scope="col">商品数</th>
	    </tr>
  </thead>
  <tbody>
<% for(Product product: productList) { %>
			<tr>
					<td><a href="/sukkiriShop/ProductViewServlet?selectedProductId=<%= product.getId()%>"><%= product.getName() %></a></td>
					<td><%= product.getPrice() %></td>
					<td><%= product.getCount() %></td>
			</tr>
<% } %>
	</tbody>
</table>
</div>
</body>
</html>