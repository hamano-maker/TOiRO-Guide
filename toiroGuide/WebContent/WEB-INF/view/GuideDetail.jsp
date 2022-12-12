<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Guide" %>
<!-- guideDetailという名前のリストをリクエストスコープからとってきて使えるようにする -->
<% Guide g = (Guide) request.getAttribute("guideDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガイド詳細画面</title>
</head>
<body>
<form action="/toiroGuide/GuideUpdate" method="get">
<input type="hidden"name="guide_id" value=<%= g.getGuide_id() %>>
名前：<%= g.getKanjiName()%>
名前(カナ)：<%= g.getKanaName() %>
生年月日：<%= g.getBirthday()%>
性別：<%= g.getGender2()%>
<input type="submit" value="編集">
</form>
<form action="/toiroGuide/guideList" method="get"><input type="submit" value="戻る"></form>
</body>
</html>