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
<h1>商品登録</h1>
<form action="/sukkiriShop/ProductRegisterFormServlet" method="post" class="greenborder">
	<div class="form-group">
		<label><dl>
			<dt>商品名：</dt>
			<dd><input type="text" class="form-control" placeholder="必須項目です" name="productName" pattern="^.{1,20}$" required></dd>
			<dd>
			<small class="form-text text-muted">
				・文字数<br />
				　<b>1文字以上20文字以下で入力してください</b><br />
			</small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>単価：</dt>
			<dd><input type="number" min="0" class="form-control" placeholder="必須項目です" name="productPrice" pattern="^([1-9][0-9]*)$" required></dd>
			<dd><small class="form-text text-muted">
				・使用可能文字<br/>
				　- 半角数字(0～9)
			</small></dd>
		</dl></label>
	</div>
	<div class="form-group" >
	    <label><dl>
	    	<dt>商品数：</dt>
		    <dd>
		    <select name="productCount">
		    <%for(int i = 1; i <= 100; i++) { %>
		    	<option value="<%= i %>"><%= i %></option>
		    <% } %>
		    </select>
		    <dd><small class="form-text text-muted"><b>※必須項目です</b></small></dd>
		</dl></label>
	</div>
	<div class="form-group">
		<label><dl>
			<dt>商品説明：</dt>
			<dd><textarea rows="8" cols="70" class="form-control" placeholder="必須項目です" name="productDescription"  required ></textarea></dd>
			<dd><small class="form-text text-muted">
				・文字数<br />
				　<b>1文字以上200文字以下で入力してください</b><br />
			</small></dd>
		</dl></label>
	</div>
	<button type="submit" class="btn btn-primary">確認</button>
</form>
</div>
</body>
</html>