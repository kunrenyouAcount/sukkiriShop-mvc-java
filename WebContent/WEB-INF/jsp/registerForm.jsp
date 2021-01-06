<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css"  crossorigin="anonymous">
</head>
<body>
<div class="container" >
<h1>ユーザー登録</h1>
<form action="/sukkiriShop/RegisterFormServlet" method="post">
	<div class="form-group">
		<label><dl>
			<dt>ユーザーID：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="userId"></dd>
			<dd><small class="form-text text-muted">※半角で6文字以上で入力してください</small></dd>
			<dd><small class="form-text text-muted">※登録済みのIDは使用できません</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>パスワード：</dt>
			<dd><input type="password" class="form-control" placeholder="必須項目です" name="pass"></dd>
			<dd><small class="form-text text-muted">※半角英数字で8文字以上で入力してください</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
	    <label><dl>
	    	<dt>メールアドレス</dt>
		    <dd><input type="email" class="form-control" placeholder="必須項目です" name="mail"></dd>
		    <dd><small class="form-text text-muted">※半角で入力してください</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>氏名：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="name"></dd>
			<dd><small class="form-text text-muted"></small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>年齢：</dt>
			<dd><input type="number" class="form-control" placeholder="任意項目です" name="age"></dd>
			<dd><small class="form-text text-muted">※半角数字で入力してください</small></dd>
		</dl></label>
	</div>
	<button type="submit" class="btn btn-primary">確認</button>
</form>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-secondary" style="color: white">トップへ</button></a>
</div>
</body>
</html>