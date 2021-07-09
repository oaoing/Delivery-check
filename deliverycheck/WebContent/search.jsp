<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="header.jsp" %>
<main class="h-full pb-16 overflow-y-auto">
          <div class="container grid px-6 mx-auto">
            <h2
              class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
            >
              조회 결과
            </h2>
            <c:choose>
            <c:when test='${check}'>
			<div class="grid gap-6 mb-8 md:grid-cols-2">
              <div
                class="min-w-0 p-4 text-white bg-purple-600 rounded-lg shadow-xs"
              >
                <h4 class="mb-4 font-semibold">
                  운송장 번호
                </h4>
                <p>
                  ${param.wayvill }
                </p>
              </div>
              <div
                class="min-w-0 p-4 text-white bg-purple-600 rounded-lg shadow-xs"
              >
                <h4 class="mb-4 font-semibold">
                  택배사
                </h4>
                <p>
                  ${company }
                </p>
              </div>
            </div>
            
            <div class="w-full mb-8 overflow-hidden rounded-lg shadow-xs">
              <div class="w-full overflow-x-auto">
             
                <table class="w-full whitespace-no-wrap">
                  <thead>
                    <tr
                      class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800"
                    >
                      <th class="px-4 py-3">시간</th>
                      <th class="px-4 py-3">현재위치</th>
                      <th class="px-4 py-3">배송 상태</th>
                    </tr>
                  </thead>
                  
                  <tbody
                    class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800"
                  >
                  <c:choose>
            	<c:when test='${result eq "Y"}'>	
                  <c:forEach var="item" items='${trackingDetails }'>
                    <tr class="text-gray-700 dark:text-gray-400">
                      <td class="px-4 py-3">
                        <div class="flex items-center text-sm">
                          <div>
                            <p class="font-semibold">${item.get("timeString") }</p>
                          </div>
                        </div>
                      </td>
                      <td class="px-4 py-3 text-sm">
                        ${item.get("where") }
                      </td>
                      <td class="px-4 py-3 text-xs">
                      <c:choose>
                      <c:when test='${fn:contains(item.get("kind"), "완료")}'>
                      <span
                          class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-full dark:bg-green-700 dark:text-green-100"
                        >
                          ${item.get("kind") }
                        </span>
                        
                      </c:when>
                      <c:otherwise>
                        <span
                          class="px-2 py-1 font-semibold leading-tight text-gray-700 bg-gray-100 rounded-full dark:text-gray-100 dark:bg-gray-700"
                        >
                          ${item.get("kind") }
                        </span>
                        </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                    </c:forEach>
                    </c:when>
                <c:when test='${result eq "N"}'>
                	<tr class="text-gray-700 dark:text-gray-400">
                	<td class="px-4 py-3 text-sm">조회된 데이터가 없습니다.</td>
                	</tr>
                </c:when>
                </c:choose>
               
                  </tbody>
                </table>
                </div>
            	</div>
            	</c:when>
			<c:otherwise>잘못된 접근 혹은 운송장 번호입니다.</c:otherwise>
			</c:choose>
			<button class="flex w-full p-3 mt-8 text-sm justify-center font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple" 
			onclick="location.href='list.do'">
			BACK
			</button>
			</div>
        </main>
      </div>
    </div>
    <script>
    $(document).ready(function(){
    	$(".table_sel").prepend('<span class="absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg" aria-hidden="true"></span>');
    	$("#table_a_mobile").addClass('text-gray-800');
		$("#table_a").addClass('text-gray-800');
    })
    </script>
  </body>
</html>
