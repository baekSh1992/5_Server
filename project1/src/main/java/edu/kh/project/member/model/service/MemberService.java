package edu.kh.project.member.model.service;
import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.vo.Member;


/** 회원 전용 기능 제공 서비스
 * @author BaekSeungHoon
 *
 */
public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 로그인 Service
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public Member login(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, member);
		
		close(conn);
		
		return loginMember;
	}

	
	/** 회원가입 Service
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.signUp(conn, member);

		if(result > 0) {
			commit(conn);
			
		}else{
			rollback(conn);
		}
		
		return result;
	}
	
	
	
	
	/**
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int updateMember(Member member) throws Exception{
	
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, member);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
}
