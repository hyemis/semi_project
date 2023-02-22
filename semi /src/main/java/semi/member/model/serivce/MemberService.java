package semi.member.model.serivce;

import java.sql.Connection;

import static semi.common.jdbc.JDBCTemplate.*;
import semi.member.model.dao.MemberDao;
import semi.member.model.vo.MemberVo;

public class MemberService {
	
	//로그인	
	public MemberVo login(MemberVo vo) {
	MemberVo result = null;
	Connection conn = getConnection();
	result = new MemberDao().login(conn, vo);
	close(conn);
	return result;
}
	
	// 회원가입 
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new MemberDao().enroll(conn,vo);
		close(conn);
		return result;
	}
	
	// 아이디 중복 체크 
	public int dupIdChk(String id) {
		int result = 0;
		Connection conn = getConnection();
		result = new MemberDao().dupIdChk(conn, id);
		close(conn);
		return result;
	}

	// 내 정보 수정
	public int myinfore(MemberVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new MemberDao().myinfore(conn,vo);
		close(conn);
		return result;
	}

	
}
