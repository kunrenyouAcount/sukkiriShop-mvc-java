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
<form name="form1" action="/sukkiriShop/CartServlet?selectedProductId=<%= product.getId() %>" method="post">
<p class="mb-2">単価：<%= product.getPrice() %>円</p>
<h4 class="mb-2">小計：<span id="sum_price" name="sum_price"></span>円</h4>
<select name="selected_count" onChange="countChange()">
<% for(int i = 1; i<=product.getCount(); i++) { %>
	<option value="<%= i %>"><%= i %></option>
<% } %>
<input type="submit" value="カートに入れる" class="btn btn-primary ml-3"/>
</select>
</form>
<a href="/sukkiriShop/ProductListServlet"><button class="btn btn-secondary">商品一覧に戻る</button></a>
</div>
<script>
document.getElementById('sum_price').textContent =<%= product.getPrice() %> * 1;
function countChange(){
	let count = document.form1.selected_count.selectedIndex;
	document.getElementById('sum_price').textContent =<%= product.getPrice() %> * parseInt(count+1);
}
</script>
</body>
</html>