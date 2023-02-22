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

/**
 * Servlet implementation class deleteCommentController
 */
@WebServlet("/commentdelete")
public class DeleteCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String commentNo = request.getParameter("commentNo");
		int result;
		
		if(commentNo != null) {
			result = new AnimalBoardService().delete(Integer.parseInt(commentNo));
			
			if(result < 1) {
				System.out.println("댓글 삭제 실패");
			} else {
				System.out.println("댓글 삭제 성공");
			}
		} else {
			System.out.println("넘겨온 값 null 임");
		}
		
		response.sendRedirect(request.getContextPath()+"/animalboard");
	}

}
