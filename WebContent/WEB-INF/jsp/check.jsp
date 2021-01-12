<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account account = (Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css"  crossorigin="anonymous">
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
			<dd><%= account.getUserId() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>パスワード：</dt>
			<dd><%= account.getPass() %></dd>
		</dl>
	</div>
	<div class="form-group">
	    <dl>
	    	<dt>メールアドレス</dt>
	    	<dd><%= account.getMail() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>氏名：</dt>
			<dd><%= account.getName() %></dd>
		</dl>
	</div>
	<div class="form-group">
		<dl>
			<dt>年齢：</dt>
			<dd><%= account.getAge() %>歳</dd>
		</dl>
	</div>
	<button type="submit" class="btn btn-primary" name="btn" value="register">登録</button>
	<button class="btn btn-secondary"><a href="javascript:history.back();" id="fix">修正</a></button>
</form>
</div>
</body>
</html>