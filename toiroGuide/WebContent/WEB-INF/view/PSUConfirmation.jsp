<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Plan" %>
<%
// リクエストスコープからユーザー情報を取得
Plan plan = (Plan) request.getAttribute("plan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン新規登録確認画面</title>
</head>
<body>
<form action="/toiroGuide/planSignUp" method="post">
プラン名：<input type="hidden"name="planName" value=<%= plan.getPlanName() %>><%= plan.getPlanName() %><br>
プラン内容：<input type="hidden"name="planContent" value=<%= plan.getPlanContent() %>><%= plan.getPlanContent() %><br>
場所：<input type="hidden"name="place" value=<%= plan.getPlace() %>><%= plan.getPlace() %><br>
一人当たりの金額：<input type="hidden"name="money" value=<%= plan.getMoney() %>><%= plan.getMoney() %><br>
定員人数：<input type="hidden"name="capacity" value=<%= plan.getCapacity() %>><%= plan.getCapacity() %><br>
ガイド：<input type="hidden"name="guide" value=<%= plan.getGuide() %>><%= plan.getName_kanji() %><br>
<input type="submit" value="登録">
</form>
<form action="/toiroGuide/planSignUp" method="get"><input type="submit" value="戻る"></form>
</body>
</html>