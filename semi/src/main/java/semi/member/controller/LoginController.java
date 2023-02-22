package semi.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.member.model.serivce.MemberService;
import semi.member.model.vo.MemberVo;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Post");
		
		// 1. 사용자로부터 입력 받은 값 변수에 저장 
		MemberVo vo = new MemberVo();
		
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));

		System.out.println("아이디, 비밀번호 param: " + vo);
		
		// 2. DB 다녀오기 
		MemberVo result = new MemberService().login(vo);
		
		if(result != null) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("lgnss", result);
		} else {
			System.out.println("로그인 실패");
		}
		response.sendRedirect(request.getContextPath()+"/");
	}

}
