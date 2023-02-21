package semi.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.member.model.vo.MemberVo;

import java.io.IOException;

/**
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/checkpw.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호 확인 작업 후 myinfo페이지 열기 
		String checkpw = request.getParameter("checkpasswd");
		
		System.out.println("받아온 Input 값 " + checkpw);
		
		String passwd = null;
		if(request.getSession().getAttribute("lgnss") != null) {
			passwd = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getPasswd();
			
			System.out.println("저장되어있던 패스워드 : " + passwd);
			
			if(passwd.equals(checkpw)) {
				System.out.println("일치");
				// 세션 값 들고 이동...
				request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
			} else {
			System.out.println("불일치");
		}
		}
		
	}
}
