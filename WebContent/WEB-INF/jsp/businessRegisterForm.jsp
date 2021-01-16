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
<div class="container" >
<h1>ビジネスユーザー登録</h1>
<form action="/sukkiriShop/BusinessRegisterFormServlet" method="post" class="greenborder">
	<div class="form-group">
		<label><dl>
			<dt>ビジネスID：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="businessID" pattern="^([a-zA-Z0-9]{8,})$"></dd>
			<dd>
			<small class="form-text text-muted">
				・文字数<br />
				　<b>8字以上</b><br />
			</small></dd>
			<dd><small class="form-text text-muted">
				・使用可能文字<br/>
				　- 英字小文字（a～z）, 英字大文字(A～Z)<br/>
				　　※大文字と小文字は区別して登録できます。<br />
				　- 数字(0～9)　<br/>
				　- 記号は使用できません。
			</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>パスワード：</dt>
			<dd><input type="password" class="form-control" placeholder="必須項目です" name="businessPass" pattern="^([a-zA-Z0-9]{8,})$"></dd>
			<dd>
			<small class="form-text text-muted">
				・文字数<br />
				　<b>英字と数字を必ず1文字以上ずつ使用してください</b><br/>
				　<b>8字以上</b><br />
			</small></dd>
			<dd><small class="form-text text-muted">
				・使用可能文字<br/>
				　- 英字小文字（a～z）, 英字大文字(A～Z)<br/>
				　　※大文字と小文字は区別して登録できます。<br />
				　- 数字(0～9)　<br/>
				　- 記号は使用できません。
			</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
	    <label><dl>
	    	<dt>メールアドレス</dt>
		    <dd><input type="email" class="form-control" placeholder="必須項目です" name="businessMail" pattern="^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$"></dd>
		    <dd><small class="form-text text-muted"><b>※半角で入力してください</b></small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>会社名：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="businessName"></dd>
			<dd><small class="form-text text-muted">例）（株）とぴあ</small></dd>
		</dl></label>
	</div>
	<button type="submit" class="btn btn-primary">確認</button>
</form>
<a href="/sukkiriShop/BusinessWelcomeServlet"><button class="btn btn-secondary" style="color: white">トップへ</button></a>
</div>
</body>
</html>