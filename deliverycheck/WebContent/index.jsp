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
	<table id=wayyvill border=1>
		<thead><tr><td>메모</td><td>운송장번호</td><td>택배사</td><td>조회</td><td>삭제</td></tr></thead>
		<tbody>
		<c:forEach var="item" items="${wayvillList }">
		<tr id="${item }"><td>${item.getMemo() }</td><td>${item.getWayvill() }</td><td>${item.getCompany() }</td>
		<td><button id="searchB" value="${item }">V</button></td>
		<td><button id="deleteB" value="${item }">X</button></td></tr>
		</c:forEach>
		</tbody>
	</table><br>
	<a href="add.do"><button id="addB">운송장 추가</button></a>
	
<script type="text/javascript">
$("deleteB").click(fucntion(){
	$.ajax({
		url: "GetServer",
		type: "get",
		cache: false,
		beforeSend: function(jx, settings) {
		        jx.data = $("#currentPage").val();
		}
	});
});	
	
</script>
</body>
</html>