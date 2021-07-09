<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>

<main class="h-full pb-16 overflow-y-auto">
          <!-- Remove everything INSIDE this div to a really blank page -->
          <div class="container px-6 mx-auto grid">
            <h2
              class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
            >
              welcome home
            </h2>
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
