<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%
Product product = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<h1><%= product.getName() %></h1>
<dl><dt>商品説明：</dt><dd><%= product.getDescription() %></dd></dl>
<form action="/sukkiriShop/CartServlet" method="post">
<h4>価格：<%= product.getPrice() %>円</h4>
<h5>小計：<span id="calc_price"></span></h5>
<select name="count" onChange="selectChange()" id="count">
<% for(int i = 1; i<=product.getCount(); i++) { %>
	<option value="<%= i %>"><%= i %></option>
<% } %>
<input type="submit" value="カートに入れる" class="btn btn-primary ml-3"/>
</select>
</form>
<a href="/sukkiriShop/ProductListServlet"><button class="btn btn-secondary">商品一覧に戻る</button></a>
</div>
<script>
let price = document.getElmentById('calc_price');
let count = document.getElmentById('count');
function selectChange(){
	price.textContent = <%= product.getPrice() %> * count;
}
</script>
</body>
</html>