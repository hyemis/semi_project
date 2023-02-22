package semi.board.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static semi.common.jdbc.JDBCTemplate.*;
import semi.board.model.vo.AnimalBoardVo;
import semi.board.model.vo.CommentVo;
import semi.board.model.vo.NoticeVo;

public class AnimalBoardDao {

	// 게시글 조회 
	public List<AnimalBoardVo> getBoardList(Connection conn){
		List<AnimalBoardVo> result = null; 
		
		String sql = "select animal_no, animal_date, animal_kind, animal_gender, animal_place, animal_detail from animal order by animal_date DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<AnimalBoardVo>();
			
			while(rs.next()) {
				 AnimalBoardVo vo = new AnimalBoardVo();
				 
				 vo.setAnimalDate(rs.getDate("animal_Date"));
				 vo.setAnimalDetail(rs.getString("animal_Detail"));
				 vo.setAnimalGender(rs.getString("animal_Gender"));
				 vo.setAnimalKind(rs.getString("animal_Kind"));
				 vo.setAnimalNo(rs.getInt("animal_No"));
				 vo.setAnimalPlace(rs.getString("animal_Place"));
				 result.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("dao : " + result);
		return result;
		
	}
	
	
	// 게시글 상세 조회 
	public AnimalBoardVo detail(Connection conn, int boardNum) {
		AnimalBoardVo result = null;
		
		String sql = "select animal_no, animal_date, animal_kind, animal_gender, animal_place, animal_detail from animal where animal_no=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//
				result = new AnimalBoardVo();
				result.setAnimalNo(rs.getInt("animal_no"));
				result.setAnimalDate(rs.getDate("animal_date"));
				result.setAnimalKind(rs.getString("animal_kind"));
				result.setAnimalGender(rs.getString("animal_gender"));
				result.setAnimalPlace(rs.getString("animal_place"));
				result.setAnimalDetail(rs.getString("animal_detail"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			close(rs);
			close(pstmt);
		}
		
		return result;
	
	}
	
	// 게시글 등록 
	public int write(Connection conn, AnimalBoardVo vo) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		
		String sql="insert into animal values ((select NVL(MAX(animal_no),0)+1 from animal),?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, vo.getAnimalDate());
			pstmt.setString(2, vo.getAnimalKind());
			pstmt.setString(3, vo.getAnimalGender());
			pstmt.setString(4, vo.getAnimalPlace());
			pstmt.setString(5, vo.getAnimalDetail());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	

	// 댓글 조회 
	public List<CommentVo> getCommentlist(Connection conn, int boardNum) {
		List<CommentVo> result = null;
		
		String sql = "select comment_no, animal_no, comment_date, comment_writer, comment_comment from cmt where animal_no=? order by comment_date DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			
			result = new ArrayList<CommentVo>();
			
			while(rs.next()) {
				CommentVo vo = new CommentVo();
				
				vo.setAnimalNo(rs.getInt("comment_No"));
				vo.setCommentcomment(rs.getString("comment_Comment"));
				vo.setCommentNo(rs.getInt("comment_no"));
				vo.setCommentWriter(rs.getString("comment_writer"));
				vo.setCommentDate(rs.getDate("comment_Date"));
				
				result.add(vo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
	}
	
	// 댓글 등록 
	public int add(Connection conn, CommentVo vo) {
		int result = -1;
		
		String sql = "INSERT INTO CMT VALUES((select NVL(MAX(COMMENT_NO),0)+1 from CMT),?,default,default,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getAnimalNo());
			pstmt.setString(2, vo.getCommentcomment());
			
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("댓글 등록 dao :" + result);
		return result;
		
	}
	
	// 사용자 선택 페이지
	public ArrayList<AnimalBoardVo> selectPage(Connection conn, int pNum) {
		//<AnimalBoardVo> result = null; 
		ArrayList<AnimalBoardVo> selectList = new ArrayList<AnimalBoardVo>();
		
		String sql = "select animal_no, animal_date, animal_kind, animal_gender, animal_place, animal_detail "
				+ " from (select * from ANIMAL order by animal_date DESC )"
				+ " where animal_no BETWEEN ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ((pNum-1)*5)+1);
			pstmt.setInt(2, pNum*5);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AnimalBoardVo vo = new AnimalBoardVo();
				vo.setAnimalNo(rs.getInt("animal_no"));
				vo.setAnimalDate(rs.getDate("animal_date"));
				vo.setAnimalKind(rs.getString("animal_kind"));
				vo.setAnimalGender(rs.getString("animal_gender"));
				vo.setAnimalPlace(rs.getString("animal_place"));
				vo.setAnimalDetail(rs.getString("animal_detail"));
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
		
		String sql ="select count(*) cnt from animal";
		
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
	
	// 댓글 삭제 
	public int delete(Connection conn, int commentNo) {
		int result = -1;
		
		String sql = "delete from CMT where comment_no=?";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시글 수정하기
	public int animalre(Connection conn, AnimalBoardVo vo) {
		int result = -1;
		
		PreparedStatement pstmt = null;
		
		String sql="update animal set ANIMAL_KIND=?, ANIMAL_GENDER=?, ANIMAL_PLACE=?, ANIMAL_DETAIL=? where ANIMAL_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAnimalKind());
			pstmt.setString(2, vo.getAnimalGender());
			pstmt.setString(3, vo.getAnimalPlace());
			pstmt.setString(4, vo.getAnimalDetail());
			pstmt.setInt(5, vo.getAnimalNo());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
