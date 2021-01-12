<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sukkiriShop/css/bootstrap.css"  crossorigin="anonymous">
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<div class="container">
<h1>ログイン完了</h1>
<h5>ようこそ<span style="font-weight: bold; font-size: 25px; text-decoration:underline solid black "><c:out value="${userId }" /></span>さん</h5>
<a href="/sukkiriShop/WelcomeServlet"><button class="btn btn-primary">トップへ</button></a>
</div>
</body>
</html>