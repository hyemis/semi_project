package semi.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semi.board.model.dao.AnimalBoardDao;
import semi.board.model.dao.NoticeDao;
import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.CommentVo;
import semi.board.model.vo.NoticeVo;
import semi.common.jdbc.JDBCTemplate;

import static semi.common.jdbc.JDBCTemplate.*;

public class AnimalBoardService {
	
	// 게시글 조회 
	public List<AnimalBoardVo> getBoardList(){
		List<AnimalBoardVo> result = null;
		
		Connection conn = getConnection();
		result = new AnimalBoardDao().getBoardList(conn);
		System.out.println("srv : " + result);
		
		close(conn);
		return result;
	}

	// 상세 조회 
	public AnimalBoardVo detail(int boardNum) {
		AnimalBoardVo result = null;
		Connection conn = getConnection();
		result = new AnimalBoardDao().detail(conn, boardNum);
		System.out.println("상세조회 srv : " + result);
		close(conn);
		return result;
	}
	
	// 댓글 조회 
	public List<CommentVo> getCommentlist(int boardNum) {
		List<CommentVo> result = null;
		Connection conn = getConnection();
		result = new AnimalBoardDao().getCommentlist(conn, boardNum);
		System.out.println("댓글조회  srv : " + result);
		close(conn);
		return result;
	}

	// 댓글 등록 
	public int add(CommentVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new AnimalBoardDao().add(conn, vo);
		close(conn);
		return result;
	}

	// 사용자가 선택한 페이지 
	public Object selectPage(int pNum) {
		ArrayList<AnimalBoardVo> selectList = null;
		Connection conn = getConnection();
		selectList = new AnimalBoardDao().selectPage(conn, pNum);
		close(conn);
		return selectList;
	}
	
	// 전체 페이지 리스트 
	public List<Integer> getPageList() {
		AnimalBoardDao dao = new AnimalBoardDao();
		Connection conn = getConnection();
		int totalRowCount = dao.selectTotalRowCount(conn);
		int mod = (totalRowCount % 5 ) == 0 ? 0 : 1; 
		int pageCount = (totalRowCount / 5) + mod;
		   
		List<Integer> pageList = new ArrayList<Integer>();
		
		for(int i = 1; i<=pageCount; i++){
		       pageList.add(i);
		     }
		
		close(conn);
		return pageList;
	}

	// 댓글 삭제 
	public int delete(int commentNo) {
		int result = -1;
		Connection conn = getConnection();
		result = new AnimalBoardDao().delete(conn, commentNo);
		close(conn);
		return result;
	}

	// 게시글 등록
	public int write(AnimalBoardVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new AnimalBoardDao().write(conn, vo);
		close(conn);
		return result;
	}
	
	// 게시글 수정
	public int animalre(AnimalBoardVo vo) {
		int result =  -1;
		Connection conn = getConnection();
		result = new AnimalBoardDao().animalre(conn, vo);
		close(conn);
		return result;
	}

}
