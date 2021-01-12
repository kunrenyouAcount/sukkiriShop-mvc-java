<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product,  java.util.List" %>
<%
List<Product> productList = (List<Product>) session.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<h1>商品一覧</h1>
<form action="/sukkiriShop/CartServlet" method="post">
<% for(Product product: productList) { %>
	<input type="radio" name="selectedProduct" value="<%= product.getId() %>">商品名：<%= product.getName() %>, 価格：<%= product.getPrice() %>, 数量：<%= product.getCount() %><br />
<% } %>
<input type="submit" value="カートに入れる">
</form>
<a>カートへ</a>
</body>
</html>