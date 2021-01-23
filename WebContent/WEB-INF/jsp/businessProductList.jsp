<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product, java.util.List" %>
<%
List<Product> businessProductList = (List<Product>) request.getAttribute("businessProductList");
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
<%if (businessProductList == null) { %>
	<h3>まだ商品がありません</h3>
<% } else { %>
	<h1>商品一覧</h1>
	<p>商品を変更したい場合は、商品名をクリックしてください。</p>
	<table class="table">
		<thead>
		    <tr>
		      <th scope="col">商品名</th>
		      <th scope="col">単価</th>
		      <th scope="col">商品数</th>
		    </tr>
	  </thead>
	  <tbody>
		<% for(Product product: businessProductList) { %>
					<tr>
							<td><a href="/sukkiriShop/ProductChangeFormServlet?productID=<%= product.getProductID()%>"><%= product.getProductName() %></a></td>
							<td><%= product.getProductPrice() %></td>
							<td><%= product.getProductCount() %></td>
					</tr>
		<% } %>
		</tbody>
	</table>
<% } %>
<a href="/sukkiriShop/ProductRegisterFormServlet"><button class="btn btn-primary">新規追加</button></a>
<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-secondary">トップへ</button></a>
</div>
</body>
</html>