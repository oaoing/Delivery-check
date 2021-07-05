package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconn.DAO;

@WebServlet("*.do")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("utf-8");
		DAO dao = new DAO();
		
		if (action.equals("main.do")) {
			if (request.getParameter("wayvill")!=null) {
				if(request.getParameter("wayvill").equals("")){
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('운송장 번호를 입력해주세요.'); location.href='add.do';</script>");
					out.flush();
				}else {
					dao.addWayvill(request.getParameter("wayvill"), request.getParameter("company"), request.getParameter("memo"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}

			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}else if(action.equals("add.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}else if(action.equals("delete.do")) {
			dao.deleteWayvill(request.getParameter("wayvill"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
