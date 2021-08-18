<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>

<main class="h-full pb-16 overflow-y-auto">
          <div class="container grid px-6 mx-auto">
            <h2
              class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
            >
              ADD
            </h2>
            <!-- General elements -->
            <form action="list.do">
              <div class="object-contain w-full overflow-x-auto">
              <div
              class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
	            <span
	              class="mb-4 font-semibold text-gray-600 dark:text-gray-300">
	              운송장 번호
	            </span>
            
              <label class="block text-sm">
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="wayvill"
                  id="wayvill"
                />
              </label>
              </div>
				<div
              	class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
               	<span
              	class="mb-4 font-semibold text-gray-600 dark:text-gray-300">
              	택배사
            	</span>
             
            <label class="block mt-4 text-sm">
                <select
                  class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-select focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                  name="company"
                  id="company"
                >
                </select>
              </label>
              </div>
     			<div
              class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
               <span
              class="mb-4 font-semibold text-gray-600 dark:text-gray-300">
              메모
            </span>
			
              <label class="block mt-4 text-sm">
                <textarea
                  class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-textarea focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                  rows="3"
                  placeholder="Enter some long form content."
                  name="memo"
                ></textarea>
              </label>
              </div>
              </div>
              <button class="flex w-full p-3 mt-5 text-sm justify-center font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple"
				type="submit">ADD</button>
              </form>
              </div>
        </main>
	</div>
	</div>
<script>
        $(document).ready(function(){
    	$(".table_sel").prepend('<span class="absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg" aria-hidden="true"></span>');
    	$("#table_a_mobile").addClass('text-gray-800');
		$("#table_a").addClass('text-gray-800');
		var url = "http://info.sweettracker.co.kr/api/v1/companylist?t_key=" + "${key}";
		$.getJSON(url,
				function(data){
					list = data['Company']
					for( var i = 0, len = list.length || 0; i < len; i++){
						$("#company").append('<option value=' + list[i]['Code'] + ':' + list[i]['Name'] + '>' + list[i]['Name'] + '</option>');
					}
				}).fail(function(xhr, status, err){
					console.log(err + '... failed');
				});
    })
</script>
  </body>
</html>


