package semi.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.member.model.serivce.MemberService;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DupIdCheckController
 */
@WebServlet("/dupid")
public class DupIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전달 받은 데이터 가져오기 
		String id = request.getParameter("id");
		
		// 2. TODO: DB 다녀오기 
		int result = new MemberService().dupIdChk(id);
		
		// 3. 페이지 이동(ajax 의 경우 페이지 이동 없음) + 데이터 전달 
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

}
