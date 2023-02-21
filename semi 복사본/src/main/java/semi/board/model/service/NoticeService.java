package semi.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import semi.board.model.dao.AnimalBoardDao;
import semi.board.model.dao.NoticeDao;
import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.NoticeVo;
import semi.common.jdbc.JDBCTemplate;
import semi.common.jdbc.JDBCTemplate;

import static semi.common.jdbc.JDBCTemplate.*;


public class NoticeService {
	
	// 공지사항 조회 
	public List<NoticeVo> getNoticeList(int pNum){
		List<NoticeVo> result = null;
		
		Connection conn = getConnection();
		result = new NoticeDao().getNoticeList(conn, pNum);
		System.out.println("공지사항 조회 src : " + result);
		
		close(conn);
		
		return result;
	}

	// 사용자가 선택한 페이지  
	public Object selectPage(int pNum) {
		ArrayList<NoticeVo> selectList = null;
		Connection conn = getConnection();
		selectList = new NoticeDao().selectPage(conn, pNum);
		close(conn);
		return selectList;
	}

	// 전채 페이지 리스트 
	public List<Integer> getPageList() {
		NoticeDao dao = new NoticeDao();
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

	// 공지사항 상세보기 
	public NoticeVo detail(int boardNum) {
		NoticeVo result = null;
		Connection conn = getConnection();
		result = new NoticeDao().detail(conn, boardNum);
		System.out.println("공지상세 srv : " + result);
		close(conn);
		return result;
	}

	// 공지사항 등록하기 
	public int noticewrite(NoticeVo vo) {
		int result=-1;
		Connection conn = getConnection();
		result = new NoticeDao().noticewrite(conn, vo);
		close(conn);
		return result;
	}
	
	// 조회수 증가 
	public int read(int boardNum){
		int result = -1;
		Connection conn = getConnection();
		result = new NoticeDao().read(conn, boardNum);
		close(conn);
		return result;
		
	}

	// 공지사항 수정
	public int noticere(NoticeVo vo) {
		int result =  -1;
		Connection conn = getConnection();
		result = new NoticeDao().noticere(conn, vo);
		close(conn);
		return result;
	}
	
	// 공지사항 삭제
	public int delete(int noticeNo) {
		int result = -1;
		Connection conn = getConnection();
		result = new NoticeDao().delete(conn, noticeNo);
		close(conn);
		return 0;
	}
	
	
	
	
}
