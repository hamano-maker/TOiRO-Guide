<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Guide,java.util.ArrayList" %>
<!-- planListという名前のアレイリストをリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Guide> guideList = (ArrayList<Guide>) request.getAttribute("guideList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン一覧</title>
</head>
<body>
<form action="/toiroGuide/guideList" method="post">
<%for(Guide g : guideList){%>
<input type="radio" name="radiobutton" value="<%=g.getGuide_id()%>">
名前：<%=g.getKanjiName()%> 名前(カナ)：<%=g.getKanaName() %> 生年月日：<%= g.getBirthday() %> 性別：<%=g.getGender2() %><br />
<%} %>
<input type="submit" value="詳細確認">
</form>
<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>
</body>
</html>