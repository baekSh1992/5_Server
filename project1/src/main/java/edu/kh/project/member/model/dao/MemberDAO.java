package edu.kh.project.member.model.dao;
import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import edu.kh.project.main.model.dao.MainDAO;
import edu.kh.project.member.model.vo.Member;

/** 회원 전용 기능 제공 DAO
 * @author BaekSeungHoon
 *
 */
public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();
            // Map<String, String> 형태의 객체, XML 입출력 특화
            
            
            String filePath 
            = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
            
            // driver.xml 파일 읽어오기
            prop.loadFromXML( new FileInputStream(filePath) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 DAO
	 * @param conn
	 * @param member
	 * @return
	 * @throws ex
	 */
	
	
	public Member login(Connection conn, Member member) throws Exception{

//		Member LoginMember = new Member();
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			
			rs=pstmt.executeQuery();
			
			
			// 컬럼 번호는 SQL문 순서가 바뀔경우 에러가 발생 > 바뀔 일 없을때만 사용
			if(rs.next()) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberEmail(rs.getString(2));
				loginMember.setMemberNickname(rs.getString(3));
				loginMember.setMemberTel(rs.getString(4));
				loginMember.setMemberAddress(rs.getString(5));
				loginMember.setProfileImage(rs.getString(6));
				loginMember.setAuthority(rs.getInt(7));
				loginMember.setEnrollDate(rs.getString(8));
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return loginMember;
	}

	/** 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		
			int result = 0;	// 결과 저장용 변수
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {
			
			close(stmt);
		}
		
		
		return result;
	}
	
	
	
	
	
	
}
