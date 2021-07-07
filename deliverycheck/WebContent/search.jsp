<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 결과</title>
</head>
<body>

	<c:choose>
		<c:when test="${check }">
		운송장번호: ${param.wayvill }<br/>
		택배사: ${param.code }<br/>
		<table>
		<thead><tr><td>시간</td><td>현재위치</td><td>배송 상태</td></tr></thead>
	<tbody>
		<c:forEach var="item" items='${trackingDetails }'>	
		<tr><td>${item.get("where") }</td><td>${item.get("kind") }</td><td>${item.get("timeString") }</td></tr>
		</c:forEach>
	</tbody>
	</table>
		</c:when>
		<c:otherwise>잘못된 접근 혹은 운송장 번호입니다.</c:otherwise>
	</c:choose>

</body>
</html>