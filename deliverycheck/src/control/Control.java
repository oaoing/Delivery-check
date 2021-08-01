package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import dbconn.DAO;
import dbconn.DTOCompany;
import dbconn.DTOWayvill;
import model.CallAPI;

@WebServlet("*.do")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }
    private final static String KEY = "v3pMtS3ZZMLZNMGvdb0bwQ";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("utf-8");
		DAO dao = new DAO();
		
		if (action.equals("list.do")) {
			String wayvill = request.getParameter("wayvill");
			List<DTOWayvill> temp = dao.searchWayvill();
			List<String> wayvillList = new ArrayList<String>();
			
			for (DTOWayvill t : temp) {
				wayvillList.add(t.getWayvill());
			}
			if (wayvill!=null) {
				if(wayvill.equals("")){
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('운송장 번호를 입력해주세요.'); location.href='add.do';</script>");
					out.flush();

				}else {
					if(wayvillList.contains(wayvill)) {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('이미 등록된 운송장 번호입니다.'); location.href='add.do';</script>");
						out.flush();
					}else {
						dao.addWayvill(wayvill, request.getParameter("company"), request.getParameter("memo"));
						request.setAttribute("wayvillList", dao.searchWayvill());
						RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
						dispatcher.forward(request, response);
					}
				}

			}else {
				request.setAttribute("wayvillList", dao.searchWayvill());
				RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
				dispatcher.forward(request, response);
			}
		}else if(action.equals("add.do")) {
			request.setAttribute("key", KEY);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
		}else if(action.equals("delete.do")) {
			dao.deleteWayvill(request.getParameter("wayvill"));
			response.sendRedirect("list.do");
		}else if(action.equals("search.do")) {
			request.setAttribute("key", KEY);
			RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}else if(action.equals("main.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
