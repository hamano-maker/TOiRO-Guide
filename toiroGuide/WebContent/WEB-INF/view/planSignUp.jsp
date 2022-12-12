<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<%@ page import="model.Place,java.util.ArrayList" %>
<%@ page import="model.Guide,java.util.ArrayList" %>
<!-- アレイリストをplaceAllという名前でリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Place> placeAll = (ArrayList<Place>) request.getAttribute("placeAll"); %>
<% ArrayList<Guide> guideAll = (ArrayList<Guide>) request.getAttribute("guideAll"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プラン新規登録</title>
</head>
<body>
<form action="/toiroGuide/PSUConfirmation" method="post">
プラン名：<input type="text" name="planName"><br>
プラン内容：<input type="text" name="planContent"><br>
場所：<select name="place">
  <option value="">場所を選んでください。</option>
  <%for(Place p : placeAll){ %>
  <option value="<%= p.getPlace_id() %>"><%=p.getPlace() %></option>
  <%}%>
</select><br>
一人当たりの金額：<input type="text" name="money"><br>
定員人数：<input type="text" name="capacity"><br>
ガイド：<select name="guide">
		<option value="">ガイドを選んでください。</option>
		<%for(Guide g : guideAll){ %>
		<option value="<%= g.getGuide_id() %>"><%=g.getKanjiName() %></option>
		<%}%>
		</select><br>
<input type="submit" value="確認">
</form>
<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>
</body>
</html>