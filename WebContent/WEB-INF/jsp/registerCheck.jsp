<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User) session.getAttribute("user");
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
<div class="container" >
<h1>登録確認画面</h1>
<form action="/sukkiriShop/RegisterServlet" method="get">
	<div class="form-group">
		<dl>
			<dt>ユーザーID：</dt>
			<dd><%= user.getUserID() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>パスワード：</dt>
			<dd><%= user.getUserPass() %></dd>
		</dl>
	</div>
	<div class="form-group">
	    <dl>
	    	<dt>メールアドレス</dt>
	    	<dd><%= user.getUserMail() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>氏名：</dt>
			<dd><%= user.getUserName() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>住所：</dt>
			<dd><%= user.getUserAddress() %></dd>
		</dl>
	</div>
	<button type="submit" class="btn btn-primary">登録</button>
	<a href="javascript:history.back();" style="color: white;"><input type="button" class="btn btn-secondary" value="修正"></a>
</form>
</div>
</body>
</html>