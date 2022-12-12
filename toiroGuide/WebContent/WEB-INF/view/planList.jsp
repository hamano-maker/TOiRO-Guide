<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Plan,java.util.ArrayList" %>
<!-- planListという名前のアレイリストをリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Plan> planList = (ArrayList<Plan>) request.getAttribute("planList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン一覧</title>
</head>
<body>
<form action="/toiroGuide/planList" method="post">
<%for(Plan p : planList){%>
<input type="radio" name="radiobutton" value="<%=p.get_Id()%>">
プラン名：<%=p.getPlan_name()%> 場所：<%=p.getPlace_name() %> ガイド名：<%=p.getName_kanji() %><br />
<%} %>
<input type="submit" value="詳細確認">
</form>
<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>
</body>
</html>