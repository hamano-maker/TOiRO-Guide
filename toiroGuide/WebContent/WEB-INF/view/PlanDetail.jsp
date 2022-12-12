<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Plan" %>
<!-- planDetailという名前のリストをリクエストスコープからとってきて使えるようにする -->
<% Plan p = (Plan) request.getAttribute("planDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン詳細画面</title>
</head>
<body>
<form action="/toiroGuide/PlanUpdate" method="get">
<input type="hidden"name="plan_id" value=<%= p.get_Id() %>>
プラン名：<%= p.getPlanName()%>
プラン内容：<%= p.getPlanContent() %>
場所：<%= p.getPlace_name()%>
一人当たりの金額：<%= p.getMoney()%>
定員人数：<%= p.getCapacity()%>
ガイド名：<%= p.getName_kanji()%>
<input type="submit" value="編集">
</form>
<form action="/toiroGuide/planList" method="get"><input type="submit" value="戻る"></form>
</body>
</html>