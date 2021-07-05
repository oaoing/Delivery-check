<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="org.json.JSONObject"%>
<%@page import="model.CallAPI"%>
<%@page import="org.json.JSONArray"%>
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
<%
	JSONObject result = CallAPI.callTrackingInfo("6078206507578", "01");
	if (result.getString("result").equals("Y")){
		request.setAttribute("check", true);
		request.setAttribute("invoiceNo",result.getString("invoiceNo"));
		List<Map<String, String>> trackingDetails = new ArrayList<Map<String, String>>();
		Gson gson = new Gson();
		trackingDetails = (List<Map<String, String>>)gson.fromJson(result.getJSONArray("trackingDetails").toString(), trackingDetails.getClass());
		request.setAttribute("trackingDetails", trackingDetails);
	}else{
		request.setAttribute("check", false);
	}
%>

	<c:choose>
		<c:when test="check">
		운송장번호: ${invoiceNo }<br/>
		택배사: ${param.code }<br/>
		<table>
		<thead><tr><td>시간</td><td>현재위치</td><td>배송 상태</td></tr></thead>
	<tbody>
		<c:forEach var="item" items='${trackingDetails }'>	
		<tr><td>${item.get("timeString") }</td><td>${item.get("where") }</td><td>${item.get("kind") }</td></tr>
		</c:forEach>
	</tbody>
	</table>
		</c:when>
		<c:otherwise>잘못된 접근 혹은 운송장 번호입니다.</c:otherwise>
	</c:choose>

</body>
</html>