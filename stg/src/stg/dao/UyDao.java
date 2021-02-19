package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.UyVo;



public class UyDao {
	private Connection con;

	public UyDao(Connection con) {
		this.con = con;
	}

	// uyno 자동증가 가져오기
	public int getUyIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uyno = 1;

		try {
			pstmt = con.prepareStatement("select max(uyno) as uyno from uy");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uyno = rs.getInt("uyno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return uyno;
	}

	public int insertUy(UyVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into uy (uyno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getUyno());
			pstmt.setString(2, vo.getQuestion());
			pstmt.setString(3, vo.getAnswer());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	// 응용SW기초기술활용 문제 가져오기
	public UyVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UyVo vo = new UyVo();

		try {
			pstmt = con.prepareStatement("select uyno, question from uy where uyno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setUyno(rs.getInt("Uyno"));
				vo.setQuestion(rs.getString("question"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 응용SW기초기술활용 정답 가져오기
	public UyVo getAnswer(UyVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UyVo avo = new UyVo();

		try {
			pstmt = con.prepareStatement("select uyno, answer from uy where uyno=?");
			pstmt.setInt(1, vo.getUyno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setUyno(rs.getInt("uyno"));
				avo.setAnswer(rs.getString("answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return avo;

	}
	
	// 응용SW기초기술활용 다음문제 가져오기
	public UyVo getUyNextQuestion(UyVo uvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UyVo vo = new UyVo();
		
		try {
			pstmt = con.prepareStatement("select uyno, question, answer from uy where uyno=?+1");
			pstmt.setInt(1, uvo.getUyno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setUyno(rs.getInt("uyno"));
			vo.setQuestion(rs.getString("question"));
			vo.setAnswer(rs.getString("answer"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	
	

}
