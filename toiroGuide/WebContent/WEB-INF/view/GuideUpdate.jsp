<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Gender,java.util.ArrayList" %>
<!-- アレイリストをgenderAllという名前でリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Gender> genderAll = (ArrayList<Gender>) request.getAttribute("genderAll"); %>
<%@ page import="model.Guide" %>
<%@ page import="model.Gender" %>
<!-- guideDetailという名前のリストをリクエストスコープからとってきて使えるようにする -->
<% Guide g = (Guide) request.getAttribute("guideDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガイド編集画面</title>
</head>
<body>
<form action="/toiroGuide/GuideUpdate" method="post">
<input type="hidden"name="guide_id" value=<%= g.getGuide_id() %>>
名前：<input type="text"name="guideNameKanji" value=<%= g.getKanjiName()%>><br />
名前(カナ)：<input type="text"name="guideNameKana" value=<%= g.getKanaName() %>><br />
生年月日：<input type="date" name="date_of_birth" value="<%= g.getBirthday()%>"><br />
性別：<select name="genderId">
<option value="<%=g.getGender()%>"><%= g.getGender2()%></option>
<%for(Gender gender : genderAll){ %>
<option value="<%= gender.getGender_id()%>"><%=gender.getGenderType() %></option>
<%}%>
</select><br>

<input type="submit" value="決定">
</form>
<form action="/toiroGuide/guideList" method="get">
<input type="hidden"name="radiobutton" value=<%= g.getGuide_id() %>>
<input type="submit" value="戻る">
</form>
</body>
</html>