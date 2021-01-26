<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%
Product product = (Product) session.getAttribute("product");
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
<div class="container" >
<h1>商品登録確認</h1>
<form action="/sukkiriShop/ProductRegisterServlet" method="get">
	<div class="form-group">
		<dl>
			<dt>ビジネスID：</dt>
			<dd><%= product.getBusinessID() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>商品名：</dt>
			<dd><%= product.getProductName() %></dd>
		</dl>
	</div>
	<div class="form-group">
	    <dl>
	    	<dt>単価：</dt>
	    	<dd><%= product.getProductPrice() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>商品数：</dt>
			<dd><%= product.getProductCount() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>商品説明：</dt>
			<dd><%= product.getProductDescription() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>商品画像：</dt>
			<dd><img class="img400" src="/sukkiriShop/uploadImage/<%= product.getProductImage() %>"/></dd>
		</dl>
	</div>
	<button type="submit" class="btn btn-primary">登録</button>
	<a href="javascript:history.back();" style="color: white;"><input type="button" class="btn btn-secondary" value="修正"></a>
</form>
</div>
</body>
</html>