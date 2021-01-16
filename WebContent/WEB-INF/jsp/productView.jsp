<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%
Product product = (Product) request.getAttribute("selectedProduct");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css">
<link rel="stylesheet" href="/sukkiriShop/css/style.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<h1><%= product.getProductName() %></h1>
<dl><dt>商品説明：</dt><dd><%= product.getProductDescription() %></dd></dl>
<form name="form1" action="/sukkiriShop/CartServlet?selectedProductID=<%= product.getProductID() %>" method="post">
<p class="mb-2">単価：<%= product.getProductPrice() %>円</p>
<h4 class="mb-2">小計：<span id="sumPrice"></span>円</h4>
<select name="selectedCount" onChange="countChange()">
<% for(int i = 1; i<=product.getProductCount(); i++) { %>
	<option value="<%= i %>"><%= i %></option>
<% } %>
<input type="submit" value="カートに入れる" class="btn btn-primary ml-3"/>
</select>
</form>
<a href="/sukkiriShop/ProductListServlet"><button class="btn btn-secondary">商品一覧に戻る</button></a>
</div>
<script>
document.getElementById('sumPrice').textContent =<%= product.getProductPrice() %> * 1;
function countChange(){
	let count = document.form1.selectedCount.selectedIndex;
	document.getElementById('sumPrice').textContent =<%= product.getProductPrice() %> * parseInt(count+1);
}
</script>
</body>
</html>