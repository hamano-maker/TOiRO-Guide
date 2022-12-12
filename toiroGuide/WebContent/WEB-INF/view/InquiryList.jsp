<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Inquiry,java.util.ArrayList" %>
<!-- inquiryListという名前のアレイリストをリクエストスコープからとってきて使えるようにする -->
<% ArrayList<Inquiry> inquiryList = (ArrayList<Inquiry>) request.getAttribute("inquiryList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ一覧</title>
</head>
<body>

<% if(inquiryList.get(0).getResolution() == 0) {%>

	<form action="/toiroGuide/InquiryList" method="get">
	未解決：<input type="radio" name="radiobutton" value="0" checked="checked">
	解決：<input type="radio" name="radiobutton" value="1">
	<input type="submit" value="切り替え">
	</form>

	<form action="/toiroGuide/InquiryList" method="post">
	<%for(Inquiry i : inquiryList){%>
	<input type="radio" name="radiobutton" value="<%=i.getInquiry_id()%>">
	問い合わせID：<%=i.getInquiry_id()%> ユーザー名：<%=i.getUser_name()%>
	問い合わせ内容：<%=i.getInquiry_content() %> 受付日：<%=i.getReception_date() %><br />
	<%} %>
	<input type="submit" value="詳細確認">
	</form>
	<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>
<%} else {%>

	<form action="/toiroGuide/InquiryList" method="get">
	未解決：<input type="radio" name="radiobutton" value="0">
	解決：<input type="radio" name="radiobutton" value="1" checked="checked">
	<input type="submit" value="切り替え">
	</form>

	<form action="/toiroGuide/InquiryList" method="post">
	<%for(Inquiry i : inquiryList){%>
	<input type="radio" name="radiobutton" value="<%=i.getInquiry_id()%>">
	問い合わせID：<%=i.getInquiry_id()%> ユーザー名：<%=i.getUser_name()%>
	問い合わせ内容：<%=i.getInquiry_content() %> 受付日：<%=i.getReception_date() %><br />
	<%} %>
	<input type="submit" value="詳細確認">
	</form>
	<form action="/toiroGuide/Login" method="get"><input type="submit" value="戻る"></form>

<%}%>
</body>
</html>