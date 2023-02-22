package semi.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.member.model.serivce.MemberService;
import semi.member.model.vo.MemberVo;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));	
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		vo.setPhone(request.getParameter("phone"));
		
		System.out.println("Ctrl param: " + vo);
		// DB
		int result = new MemberService().enroll(vo);
		
		if(result < 1) {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath()+"/enroll");
		} else {
			System.out.println("회원가입 성공");
/*			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('알람');");
			out.println("</script>");
			out.flush();
			out.close();
*/
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
