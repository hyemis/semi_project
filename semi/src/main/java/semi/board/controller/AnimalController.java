package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.AnimalBoardService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AnimalController
 */
@WebServlet("/animalboard")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("animallist", new AnimalBoardService().getBoardList());
		
		String pageNumber = request.getParameter("p");
		int pNum;
		
		if(pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		} else {
			pNum = Integer.parseInt(pageNumber);
		}

		request.setAttribute("selectList",new AnimalBoardService().selectPage(pNum));
		
		List<Integer>pageList = new AnimalBoardService().getPageList();
		request.setAttribute("pageList", pageList);
		
		
		request.getRequestDispatcher("/WEB-INF/view/animal/animalboard.jsp").forward(request, response);

	
	}
	
	
	

}
