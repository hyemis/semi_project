package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.NoticeService;
import semi.board.model.vo.NoticeVo;

import java.io.IOException;

/**
 * Servlet implementation class NoticeReController
 */
@WebServlet("/noticere")
public class NoticeReController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeReController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/noticere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeVo vo = new NoticeVo();
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		vo.setNoticeNo(noticeNo);
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeWriter(request.getParameter("noticeWrite"));
		vo.setNoticeContent(request.getParameter("noticeContent"));
		
		int result = new NoticeService().noticere(vo);
		
		if(result < 1) {
			System.out.println("공지사항 수정 실패");
		} else {
			System.out.println("공지사항 수정 성공");
		}
		
		response.sendRedirect(request.getContextPath()+"/notice");
		
	}

}
