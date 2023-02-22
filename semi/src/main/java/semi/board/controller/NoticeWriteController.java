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
 * Servlet implementation class noticewrite
 */
@WebServlet("/noticewrite")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/noticewrite.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeVo vo = new NoticeVo();
		
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeWriter(request.getParameter("noticeWrite"));
		vo.setNoticeContent(request.getParameter("noticeContent"));
		
		//DB 다녀오기 
		int result = new NoticeService().noticewrite(vo);
		
		if(result < 1) {
			System.out.println("공지사항 등록 실패");
		} else {
			System.out.println("공지사항 등록 성공");
		}
		
		response.sendRedirect(request.getContextPath()+"/notice");
	
	}

}
