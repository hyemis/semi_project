package semi.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import semi.board.model.service.AnimalBoardService;
import semi.board.model.vo.AnimalBoardVo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("/animalwrite")
public class AnimalWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/animal/animalwrite.jsp").forward(request, response);
    	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//1. 
    	AnimalBoardVo vo = new AnimalBoardVo();
    	
    	Date date = new Date();
	   	String inputDate = request.getParameter("animalDate");
	   	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	   	inputDate = fmt.format(date);
	   	java.sql.Date animalDate = java.sql.Date.valueOf(inputDate); 
    	
    	vo.setAnimalDate(animalDate);
    	vo.setAnimalKind(request.getParameter("animalKind"));
    	vo.setAnimalGender(request.getParameter("animalGender"));
    	vo.setAnimalPlace(request.getParameter("animalPlace"));
    	vo.setAnimalDetail(request.getParameter("animalDetail"));
    	
    	
    	//2. 3.
    	int result = new AnimalBoardService().write(vo);
    	
    	if(result < 1) {
    		System.out.println("게시글 등록 실패");
    	} else {
    		System.out.println("게시글 등록 성공");
    	}
		response.sendRedirect(request.getContextPath()+"/animalboard");
    	
	}
    

}
