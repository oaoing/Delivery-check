<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>

<main class="h-full pb-16 overflow-y-auto">
          <!-- Remove everything INSIDE this div to a really blank page -->
          <div class="container px-6 mx-auto grid">
          <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
              Delivery-Check
            </h2>
            <h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">
              개요
            </h4>
            <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
              <p class="text-sm text-gray-600 dark:text-gray-400">
                스마트택배 API를 이용한 통합 배송 조회 웹 애플리케이션
              </p>
            </div>
            <h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">
              개발 환경
            </h4>
            <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
              <p class="text-sm text-gray-600 dark:text-gray-400">
                - eclipse Version: 2020-03 (4.15.0) <br>
						<br>
					  - JavaSE-1.8<br>
						<br>
					  - MariaDB 5.5<br>
						<br>
					  - Apache Tomcat v9.0<br>
						<br>
					  - Maven<br>
              </p>
            </div>
            <h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">
              GitHub
            </h4>
            <a class="flex items-center justify-between p-4 mb-8 text-sm font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple" href="https://github.com/oaoing/Delivery-check">
              <div class="flex items-center">
                <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
                  <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
                </svg>
                <span>View details on GitHub</span>
              </div>
              <span> more →</span>
            </a>
          </div>
        </main>
      </div>
    </div>
    <script>
    $(document).ready(function(){
    	$(".home_sel").prepend('<span class="absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg" aria-hidden="true"></span>');
    	$("#home_a_mobile").addClass('text-gray-800');
		$("#home_a").addClass('text-gray-800');
    })
    </script>
  </body>
</html>
