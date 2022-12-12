<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<%@ page import="model.GuideCompany,java.util.ArrayList" %>
<!-- アレイリストをguideCompanyNameという名前でリクエストスコープからとってきて使えるようにする -->
<% ArrayList<GuideCompany> guideCompanyName = (ArrayList<GuideCompany>) request.getAttribute("cName"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガイド新規登録</title>
</head>
<body>
<form action="/toiroGuide/GSUConfirmation" method="post">
名前：<input type="text" name="kannjiName"><br>
名前(カナ)：<input type="text" name="kanaName"><br>
生年月日：<input type="date" name="date_of_birth" value="YYYY-MM-DD">
【性別】男：<input type="radio" name="radiobutton" value="1">
女：<input type="radio" name="radiobutton" value="2">
その他：<input type="radio" name="radiobutton" value="3"><br>
<input type="submit" value="確認">
</form>
<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>
</body>
</html>