package semi.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.NoticeService;
import semi.board.model.vo.NoticeVo;
import semi.member.model.serivce.MemberService;
import semi.member.model.vo.MemberVo;

import java.io.IOException;

/**
 * Servlet implementation class MyinfoReController
 */
@WebServlet("/myinfore")
public class MyinfoReController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoReController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/myinfore.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVo vo = new MemberVo();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		vo.setNo(no);
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		vo.setPhone(request.getParameter("phone"));
		
		int result = new MemberService().myinfore(vo);
		
		if(result < 1) {
			System.out.println("내정보 수정 실패");
		} else {
			System.out.println("내정보 수정 성공");
		}
		
		response.sendRedirect(request.getContextPath()+"/");
		
	}
	
}
