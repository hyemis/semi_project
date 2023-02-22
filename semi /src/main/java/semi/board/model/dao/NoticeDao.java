package semi.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static semi.common.jdbc.JDBCTemplate.*;

import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.NoticeVo;

public class NoticeDao {
	
	// 공지사항 조회 
	public List<NoticeVo> getNoticeList(Connection conn, int pNum){
		List<NoticeVo> result = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select notice_no, notice_title, notice_writer, notice_content, notice_date, notice_viewcount from notice where notice_no BETWEEN ? and ? order by notice_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((pNum-1)*5)+1);
			pstmt.setInt(2, pNum*5);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<NoticeVo>();
			
			while(rs.next()) {
				NoticeVo vo = new NoticeVo();
				
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setNoticeDate(rs.getDate("notice_date"));
				vo.setNoticeNo(rs.getInt("notice_no"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeViewCount(rs.getInt("notice_viewcount"));
				vo.setNoticeWriter(rs.getString("notice_writer"));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 사용자가 선택한 리스트 
	public ArrayList<NoticeVo> selectPage(Connection conn, int pNum) {
		ArrayList<NoticeVo> selectList = new ArrayList<NoticeVo>();
		
		String sql = "select notice_no, notice_title, notice_writer, notice_content, notice_date, notice_viewcount from (select * from notice order by notice_date DESC ) where notice_no BETWEEN ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ((pNum-1)*5)+1);
			pstmt.setInt(2, pNum*5);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeVo vo = new NoticeVo();
				
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setNoticeDate(rs.getDate("notice_date"));
				vo.setNoticeNo(rs.getInt("notice_no"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeViewCount(rs.getInt("notice_viewcount"));
				vo.setNoticeWriter(rs.getString("notice_writer"));
				
				selectList.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace(); 
		} finally {
			close(pstmt);
			close(rs);
		}
		return selectList;
	}

	// 전체 페이지 리스트 
	public int selectTotalRowCount(Connection conn) {
		int count = 0;
		
		String sql ="select count(*) cnt from notice";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}	
		
		return count;
	}

	// 공지 상세 보기
	public NoticeVo detail(Connection conn, int boardNum) {
		NoticeVo result = null;
		
		String sql = "select notice_no, notice_title, notice_writer, notice_content, notice_date, notice_viewcount from notice where notice_no=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new NoticeVo();
				result.setNoticeContent(rs.getString("notice_content"));
				result.setNoticeDate(rs.getDate("notice_date"));
				result.setNoticeNo(rs.getInt("notice_no"));
				result.setNoticeTitle(rs.getString("notice_title"));
				result.setNoticeViewCount(rs.getInt("notice_viewcount"));
				result.setNoticeWriter(rs.getString("notice_writer"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			close(rs);
			close(pstmt);
		}
		
		return result;
	}	
	
	// 공지사항 등록하기 
	public int noticewrite(Connection conn, NoticeVo vo) {
		int result=-1;
		PreparedStatement pstmt = null;
		
		String sql="insert into notice values ((select NVL(MAX(notice_no),0)+1 from notice), ?, ?, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getNoticeTitle());
			pstmt.setString(2, vo.getNoticeWriter());
			pstmt.setString(3, vo.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	 //조회 시 viewcount + 1
	public int read(Connection conn, int boardNum){
		int result = -1;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE notice set notice_viewcount=notice_viewcount+1 where notice_no = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 공지사항 수정하기 
	public int noticere(Connection conn, NoticeVo vo) {
		int result =  -1;
		
		PreparedStatement pstmt = null;
		
		String sql = "update notice set notice_title=?, notice_content=? where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNoticeTitle());
			pstmt.setString(2, vo.getNoticeContent());
			pstmt.setInt(3, vo.getNoticeNo());

			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 공지사항 삭제하기 
	public int delete(Connection conn, int noticeNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		
		String sql = "delete from notice where notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
			System.out.println("공지사항 쿼리 잘 실행?" +result);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
	}
}
