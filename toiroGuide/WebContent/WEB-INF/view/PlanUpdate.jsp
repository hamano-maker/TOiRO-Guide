<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Place,java.util.ArrayList" %>
<%@ page import="model.Guide,java.util.ArrayList" %>
<!-- アレイリストをplaceAllという名前でリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Place> placeAll = (ArrayList<Place>) request.getAttribute("placeAll"); %>
<% ArrayList<Guide> guideAll = (ArrayList<Guide>) request.getAttribute("guideAll"); %>
<%@ page import="model.Plan" %>
<!-- planDetailという名前のリストをリクエストスコープからとってきて使えるようにする -->
<% Plan p = (Plan) request.getAttribute("planDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン編集画面</title>
</head>
<body>
<form action="/toiroGuide/PlanUpdate" method="post">
<input type="hidden"name="plan_id" value=<%= p.get_Id() %>>
プラン名：<input type="text"name="planName" value=<%= p.getPlanName()%>><br />
プラン内容：<input type="text"name="planContent" value=<%= p.getPlanContent() %>><br />

場所：<select name="place">
<option value="<%= p.getPlace()%>"><%= p.getPlace_name()%></option>
<%for(Place p1 : placeAll){ %>
<option value="<%= p1.getPlace_id() %>"><%=p1.getPlace() %></option>
<%}%>
</select><br>

一人当たりの金額：<input type="text"name="money" value=<%= p.getMoney()%>><br />
定員人数：<input type="text"name="capacity" value=<%= p.getCapacity()%>><br />

ガイド：<select name="guide">
<option value="<%=p.getGuide()%>"><%= p.getName_kanji()%></option>
<%for(Guide g : guideAll){ %>
<option value="<%= g.getGuide_id() %>"><%=g.getKanjiName() %></option>
<%}%>
</select><br>

<input type="submit" value="決定">
</form>
<form action="/toiroGuide/planList" method="get">
<input type="hidden"name="radiobutton" value=<%= p.get_Id() %>>
<input type="submit" value="戻る">
</form>
</body>
</html>