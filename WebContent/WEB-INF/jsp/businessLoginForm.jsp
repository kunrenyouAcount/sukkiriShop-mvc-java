<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">
<h1>業務用ログイン画面</h1>
<form action="/sukkiriShop/BusinessLoginServlet" method="post" class="blueborder">
	<div class="form-group">
		<label><dl>
			<dt>ビジネスID：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="businessID" pattern="^([a-zA-Z0-9]{6,30})$" required></dd>
			<dd><small class="form-text text-muted">※半角で6文字以上30字以下で入力してください</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>パスワード：</dt>
			<dd><input type="password" class="form-control" placeholder="必須項目です" name="businessPass" pattern="^([a-zA-Z0-9]{8,30})$" required></dd>
			<dd><small class="form-text text-muted">※半角で8文字以上30字以下で入力してください</small></dd>
		</dl></label>
	</div>
	<button type="submit" class="btn btn-primary">ログイン</button>
	<a href="javascript:history.back();" style="color: white;"><input type="button" class="btn btn-secondary" value="戻る"></a>
</form>
<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-secondary">トップへ</button></a>
</div>
</body>
</html>