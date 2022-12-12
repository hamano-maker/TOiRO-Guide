<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.GuideCompany" %>
<%
// セッションスコープからユーザー情報を取得
GuideCompany loginUser = (GuideCompany) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ガイド会社</title>
</head>
</head>
<body>
<h1>メインページ</h1>
<p>ようこそ<%=loginUser.getCompany_name()%>さん</p>
<a href="/toiroGuide/planSignUp">プラン新規登録</a><br />
<a href="/toiroGuide/guideSignUp">ガイド新規登録</a><br />
<a href="/toiroGuide/planList">プラン一覧</a><br />
<a href="/toiroGuide/guideList">ガイド一覧</a><br />
<a href="/toiroGuide/InquiryList?radiobutton=0">お問い合わせページ</a><br />
<a href="/toiroGuide/Logout">ログアウト</a><br />
</body>
</html>