package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.AkbfVo;




public class AkbfDao {
	private Connection con;

	public AkbfDao(Connection con) {
		this.con = con;
	}

	// akbfno 자동증가 가져오기
	public int getAkbfIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int akbfno = 1;

		try {
			pstmt = con.prepareStatement("select max(akbfno) as akbfno from akbf");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				akbfno = rs.getInt("akbfno");
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
		return akbfno;
	}
	
	// 애플리케이션배포 문제 입력하기
	public int insertAkbf(AkbfVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into akbf (akbfno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getAkbfno());
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

	// 애플리케이션배포 문제 가져오기
	public AkbfVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AkbfVo vo = new AkbfVo();

		try {
			pstmt = con.prepareStatement("select akbfno, question from akbf where akbfno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setAkbfno(rs.getInt("akbfno"));
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

	// 애플리케이션배포 정답 가져오기
	public AkbfVo getAnswer(AkbfVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AkbfVo avo = new AkbfVo();

		try {
			pstmt = con.prepareStatement("select akbfno, answer from akbf where akbfno=?");
			pstmt.setInt(1, vo.getAkbfno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setAkbfno(rs.getInt("akbfno"));
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
	
	// 애플리케이션배포 다음문제 가져오기
	public AkbfVo getAkbfNextQuestion(AkbfVo akbfvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AkbfVo vo = new AkbfVo();
		
		try {
			pstmt = con.prepareStatement("select akbfno, question, answer from akbf where akbfno=?+1");
			pstmt.setInt(1, akbfvo.getAkbfno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setAkbfno(rs.getInt("akbfno"));
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
