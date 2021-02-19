package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.PuVo;

public class PuDao {
	private Connection con;

	public PuDao(Connection con) {
		this.con = con;
	}

	// puno 자동증가 가져오기
	public int getPuIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int puno = 1;

		try {
			pstmt = con.prepareStatement("select max(puno) as puno from pu");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				puno = rs.getInt("puno");
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
		return puno;
	}

	// 프로그래밍언어활용 문제 입력하기
	public int insertPu(PuVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into pu (puno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getPuno());
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

	// 프로그래밍언어활용 문제 가져오기
	public PuVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PuVo vo = new PuVo();

		try {
			pstmt = con.prepareStatement("select puno, question from pu where puno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setPuno(rs.getInt("puno"));
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

	// 프로그래밍언어활용 정답 가져오기
	public PuVo getAnswer(PuVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PuVo avo = new PuVo();

		try {
			pstmt = con.prepareStatement("select puno, answer from pu where puno=?");
			pstmt.setInt(1, vo.getPuno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setPuno(rs.getInt("puno"));
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
	
	// 프로그래밍언어활용 다음문제 가져오기
	public PuVo getPuNextQuestion(PuVo pvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PuVo vo = new PuVo();
		
		try {
			pstmt = con.prepareStatement("select puno, question, answer from pu where puno=?+1");
			pstmt.setInt(1, pvo.getPuno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setPuno(rs.getInt("puno"));
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
