<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Guide" %>
<%
// リクエストスコープからユーザー情報を取得
Guide guide = (Guide) request.getAttribute("guide");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガイド新規登録確認画面</title>
</head>
<body>
<form action="/toiroGuide/guideSignUp" method="post">
名前：<input type="hidden"name="kannjiName" value=<%= guide.getKanjiName() %>><%= guide.getKanjiName() %><br>
名前(カナ)：<input type="hidden" name="kanaName" value=<%= guide.getKanaName() %>><%= guide.getKanaName() %><br>
年齢：<input type="hidden" name="date_of_birth" value=<%= guide.getBirthday() %>><%= guide.getBirthday() %><br>
性別：<input type="hidden" name="radiobutton" value=<%= guide.getGender() %>>
<% if(guide.getGender() == 1) {%>
男
<% }else if(guide.getGender() == 2){%>
女
<%}else{%>
その他
<%}%>
<input type="submit" value="登録">
</form>
<form action="/toiroGuide/guideSignUp" method="get"><input type="submit" value="戻る"></form>
</body>
</html>