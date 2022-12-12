<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Inquiry" %>
<!-- guideDetailという名前のリストをリクエストスコープからとってきて使えるようにする -->
<% Inquiry i = (Inquiry) request.getAttribute("inquiryDetail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ詳細画面</title>
</head>
<body>
<form action="/toiroGuide/InquiryUpDate" method="post">
<input type="hidden"name="inquiry_id" value=<%= i.getInquiry_id() %>>問い合わせID：<%=i.getInquiry_id()%><br />
ユーザー名：<%=i.getUser_name()%><br />
問い合わせ内容：<%=i.getInquiry_content() %><br />
受付日：<%=i.getReception_date() %><br />
電話番号：<%=i.getPhone_number() %><br />
メールアドレス：<%=i.getAddress() %><br />
メモ：<input type="text"name="memo" value=<%=i.getMemo() %>><br />
<% if(i.getResolution() == 0) {%>
	未解決：<input type="radio" name="radiobutton" value="0" checked="checked">
	解決：<input type="radio" name="radiobutton" value="1"><br />
<%}else{%>
	未解決：<input type="radio" name="radiobutton" value="0">
	解決：<input type="radio" name="radiobutton" value="1" checked="checked"><br />
<%}%>
<input type="submit" value="更新">
</form>

<form action="/toiroGuide/InquiryList" method="get">
<input type="hidden"name="radiobutton" value=<%= i.getResolution() %>>
<input type="submit" value="戻る">
</form>

</body>
</html>