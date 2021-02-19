package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.UiVo;


public class UiDao {
	private Connection con;

	public UiDao(Connection con) {
		this.con = con;
	}

	// uino 자동증가 가져오기
	public int getUiIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uino = 1;

		try {
			pstmt = con.prepareStatement("select max(uino) as uino from ui");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uino = rs.getInt("uino");
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
		return uino;
	}

	// UI테스트 문제 입력하기
	public int insertUi(UiVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into ui (uino, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getUino());
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

	// UI테스트 문제 가져오기
	public UiVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UiVo vo = new UiVo();

		try {
			pstmt = con.prepareStatement("select uino, question from ui where uino=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setUino(rs.getInt("uino"));
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

	// UI테스트 정답 가져오기
	public UiVo getAnswer(UiVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UiVo avo = new UiVo();

		try {
			pstmt = con.prepareStatement("select uino, answer from ui where uino=?");
			pstmt.setInt(1, vo.getUino());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setUino(rs.getInt("uino"));
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
	
	// UI테스트 다음문제 가져오기
	public UiVo getUiNextQuestion(UiVo uvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UiVo vo = new UiVo();
		
		try {
			pstmt = con.prepareStatement("select uino, question, answer from ui where uino=?+1");
			pstmt.setInt(1, uvo.getUino());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setUino(rs.getInt("uino"));
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
