package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.AnimalBoardService;
import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.CommentVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AnimalDetailController
 */
@WebServlet("/animaldetail")
public class AnimalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(request.getParameter("num"));
		
		// 2. DB 
		AnimalBoardVo result = new AnimalBoardService().detail(boardNum);
		List<CommentVo> result2 = new  AnimalBoardService().getCommentlist(boardNum);
		
		if(result != null) {
			request.getSession().setAttribute("detail", result);
			request.getSession().setAttribute("comment", result2);

			request.getRequestDispatcher("/WEB-INF/view/animal/animaldetail.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentVo vo = new CommentVo();
		int animalNo =Integer.parseInt(request.getParameter("animalNo"));		
	
		vo.setCommentcomment(request.getParameter("comment"));
		vo.setAnimalNo(animalNo);
		
		// Db 다녀오기 
		int result = new AnimalBoardService().add(vo);
		
		if(result < 1) {
			System.out.println("댓글 등록 실패");
		} else {
			System.out.println("댓글 등록 성공");
	}
	
		response.sendRedirect(request.getContextPath()+"/animalboard");
		
	}

}
