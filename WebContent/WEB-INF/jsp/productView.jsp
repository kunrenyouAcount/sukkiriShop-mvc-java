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
<link rel="stylesheet" href="/sukkiriShop/css/general.css">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<form name="form1" action="/sukkiriShop/CartServlet?productID=<%= product.getProductID() %>" method="post">
	<h1><%= product.getProductName() %></h1>
	<div class="row">
		<div class="col">
			<img class="img400" src="/sukkiriShop/uploadImage/<%= product.getProductImage() %>"/>
		</div>
		<div class="col">
			<dl><dt>商品説明：</dt><dd><%= product.getProductDescription() %></dd></dl>
			<p class="mb-2">単価：<%= product.getProductPrice() %>円</p>
			<h4 class="mb-2">小計：<span id="sumPrice"></span>円</h4>
			<select name="selectedCount" onChange="countChange()">
			<% for(int i = 1; i<=product.getProductCount(); i++) { %>
				<option value="<%= i %>"><%= i %></option>
			<% } %>
			</select>
			<input type="submit" value="カートに入れる" class="btn btn-primary ml-3"/>
		</div>
	</div>
</form>
	<a href="javascript:history.back();" style="color: white;"><input type="button" class="btn btn-secondary" value="商品一覧に戻る"></a>
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