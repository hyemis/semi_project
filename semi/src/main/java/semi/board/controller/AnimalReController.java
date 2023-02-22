package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.AnimalBoardService;
import semi.board.model.service.NoticeService;
import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.NoticeVo;

import java.io.IOException;

/**
 * Servlet implementation class AnimalReController
 */
@WebServlet("/animalre")
public class AnimalReController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalReController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/animal/animalre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AnimalBoardVo vo = new AnimalBoardVo();
		
		int animalNo = Integer.parseInt(request.getParameter("animalNo"));
		
		vo.setAnimalNo(animalNo);
		vo.setAnimalKind(request.getParameter("animalKind"));
		vo.setAnimalGender(request.getParameter("animalGender"));
		vo.setAnimalPlace(request.getParameter("animalPlace"));
		vo.setAnimalDetail(request.getParameter("animalDetail"));
		
		int result =  new AnimalBoardService().animalre(vo);
		
		if(result < 1) {
			System.out.println("유기동물 수정 실패");
		} else {
			System.out.println("유기동물 수정 성공");
		}
		
		response.sendRedirect(request.getContextPath()+"/animalboard");
	
	
	
	
	
	}

}
