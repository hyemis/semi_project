package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.AnimalBoardService;
import semi.board.model.service.NoticeService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		// paging
		
		String pageNumber = request.getParameter("p");
		int pNum;
				
		if(pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
			} else {
				pNum = Integer.parseInt(pageNumber);
			}
		request.setAttribute("selectList",new NoticeService().selectPage(pNum));
		request.setAttribute("noticeList", new NoticeService().getNoticeList(pNum));
				
		List<Integer>pageList = new NoticeService().getPageList();
		request.setAttribute("pageList", pageList);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/notice.jsp").forward(request, response);
	}

}
