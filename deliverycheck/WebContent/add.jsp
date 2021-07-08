<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>

<main class="h-full pb-16 overflow-y-auto">
          <div class="container px-6 mx-auto grid">
            <h2
              class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200"
            >
              ADD
            </h2>
            <!-- General elements -->
            
            <form action="list.do">
            <h4
              class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
            >
              운송장 번호
            </h4>
            <div
              class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800"
            >
              <label class="block text-sm">
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="wayvill"
                  id="wayvill"
                />
              </label>

              </div>
              <h4
              class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
            >
              택배사
            </h4>
              <div
              class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800"
            >
            <label class="block mt-4 text-sm">
                <select
                  class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-select focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                  name="company"
                >
                   <c:forEach var="c" items="${company }">
					<option value="${c.getCode()}">${c.getName() }</option>
				</c:forEach>
                </select>
              </label>
              </div>
              <h4
              class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
            >
              메모
            </h4>
			<div
              class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800"
            >
              <label class="block mt-4 text-sm">
                <textarea
                  class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-textarea focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                  rows="3"
                  placeholder="Enter some long form content."
                  name="memo"
                ></textarea>
              </label>
              </div>
				<button class="flex p-3 mt-8 text-sm justify-center font-semibold text-purple-100 bg-purple-600 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple"
				type="submit">ADD</button>
              </form>
              </div>
        </main>
  </body>
</html>


