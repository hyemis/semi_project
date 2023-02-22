
package semi.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static semi.common.jdbc.JDBCTemplate.*;
import semi.member.model.vo.MemberVo;

public class MemberDao {
	
	// 로그인 
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String query = "select *  from member where id=? and passwd=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());

			// 단일행 쿼리문 꺼내와서 Member Vo 에 담기
			rs = pstmt.executeQuery();


			if(rs.next()) {
				result = new MemberVo();
				result.setNo(rs.getInt("NO"));
				result.setId(rs.getString("ID"));
				result.setPasswd(rs.getString("PASSWD"));
				result.setName(rs.getString("NAME"));
				result.setEmail(rs.getString("EMAIL"));
				result.setAddress(rs.getNString("ADDRESS"));
				result.setPhone(rs.getString("PHONE"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		System.out.println("로그인"+result);
		return result;
	}
	
	
	// 회원가입
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query = "insert into member values ((select NVL(MAX(no),0)+1 from member),?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getPhone());

			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("DAO enroll() return: "+ result);
		return result;


	}

	// 아이디 중복 체크 
	public int dupIdChk(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) cnt from member where id=?";
		
		try{
			pstmt = conn.prepareStatement(query); 
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); 
			
				if(rs.next()) {
				result = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			} finally {
				close(rs);
				close(pstmt); 
			}
		
		System.out.println(result);
		return result;
	}

	// 내 정보 수정하기 
	public int myinfore(Connection conn, MemberVo vo) {
		int result = -1;
		PreparedStatement pstmt = null;
		
		String sql = "update member set name=?, email=?, address=?, phone=? where no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
