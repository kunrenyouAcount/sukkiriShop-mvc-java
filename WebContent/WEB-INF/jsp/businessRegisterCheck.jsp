<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Business" %>
<%
Business business = (Business) session.getAttribute("business");
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
<h1>登録確認画面</h1>
<form action="/sukkiriShop/BusinessRegisterServlet" method="get">
	<div class="form-group">
		<dl>
			<dt>ビジネスID：</dt>
			<dd><%= business.getBusinessID() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>パスワード：</dt>
			<dd><%= business.getBusinessPass() %></dd>
		</dl>
	</div>
	<div class="form-group">
	    <dl>
	    	<dt>メールアドレス</dt>
	    	<dd><%= business.getBusinessMail() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>氏名：</dt>
			<dd><%= business.getBusinessName() %></dd>
		</dl>
	</div>
	<button type="submit" class="btn btn-primary">登録</button>
	<button class="btn btn-secondary"><a href="javascript:history.back();" style="color: white;">修正</a></button>
</form>
</div>
</body>
</html>