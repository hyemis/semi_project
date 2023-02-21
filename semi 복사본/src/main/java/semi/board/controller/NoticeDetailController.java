package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.NoticeService;
import semi.board.model.vo.NoticeVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/noticedetail")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("num"));
		
		NoticeVo result = new NoticeService().detail(boardNum);
		int result2 = new NoticeService().read(boardNum);
		
		
		if(result != null) {
			if(result2 > 0) {
				request.getSession().setAttribute("detail", result);
				request.getRequestDispatcher("/WEB-INF/view/notice/noticedetail.jsp").forward(request, response);
			}
		}
		
	}


}
