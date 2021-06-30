<%@page import="dbconn.DAO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합 배송 조회</title>
</head>
<body>
<%	
	DAO dao = new DAO();
	request.setAttribute("wayvillList", dao.searchWayvill());
%>
	<table border=1>
		<thead><tr><td>메모</td><td>운송장번호</td><td>택배사</td><td>조회</td><td>삭제</td></tr></thead>
		<tbody>
		<c:forEach var="item" items="${wayvillList }">
		<tr><td>${item.getMemo() }</td><td>${item.getWayvill() }</td><td>${item.getCompany() }</td>
		<td><button value="${item }" onclick="#">V</button></td>
		<td><button value="${item }" onclick="#">X</button></td></tr>
		</c:forEach>
		</tbody>
	</table><br>
	<button onclick="#">운송장 추가</button>
</body>
</html>