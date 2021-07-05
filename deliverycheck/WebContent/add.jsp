<%@page import="dbconn.DTOCompany"%>
<%@page import="java.util.List"%>
<%@page import="dbconn.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	DAO dao = new DAO();
	List<DTOCompany> company = dao.searchCompany();
	request.setAttribute("company", company);
	
%>
<form>
운송장 번호: <input type="text" name="wayvill"/><br>
택배사: <select name="company">
<c:forEach var="item" items="${company }">
	<option value="${item.getCode()}">${item.getName() }</option>
</c:forEach>
</select><br>
메모: <input type="text" name="memo"/><br>

<button formaction="main.do">등록</button>
</form>
</body>
</html>