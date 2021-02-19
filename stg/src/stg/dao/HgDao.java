package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.HgVo;

public class HgDao {
	private Connection con;

	public HgDao(Connection con) {
		this.con = con;
	}

	// hgno 자동증가 가져오기
	public int getHgIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int hgno = 1;

		try {
			pstmt = con.prepareStatement("select max(hgno) as hgno from hg");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hgno = rs.getInt("hgno");
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
		return hgno;
	}

	// 화면구현 문제 입력하기
	public int insertHg(HgVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into hg (hgno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getHgno());
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

	// 화면구현 문제 가져오기
	public HgVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HgVo vo = new HgVo();

		try {
			pstmt = con.prepareStatement("select hgno, question from hg where hgno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setHgno(rs.getInt("hgno"));
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

	// 화면구현 정답 가져오기
	public HgVo getAnswer(HgVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HgVo avo = new HgVo();

		try {
			pstmt = con.prepareStatement("select hgno, answer from hg where hgno=?");
			pstmt.setInt(1, vo.getHgno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setHgno(rs.getInt("hgno"));
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
	
	// 화면구현 다음문제 가져오기
	public HgVo getHgNextQuestion(HgVo hvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HgVo vo = new HgVo();
		
		try {
			pstmt = con.prepareStatement("select hgno, question, answer from hg where hgno=?+1");
			pstmt.setInt(1, hvo.getHgno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setHgno(rs.getInt("hgno"));
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
