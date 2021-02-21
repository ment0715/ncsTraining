package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.AktsVo;
import stg.vo.UyVo;




public class AktsDao {
	private Connection con;

	public AktsDao(Connection con) {
		this.con = con;
	}

	// aktsno 자동증가 가져오기
	public int getAktsIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int aktsno = 1;

		try {
			pstmt = con.prepareStatement("select max(aktsno) as aktsno from akts");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				aktsno = rs.getInt("aktsno");
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
		return aktsno;
	}
	
	// 애플리케이션테스트수행 문제 입력하기
	public int insertAkts(AktsVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into akts (aktsno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getAktsno());
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

	// 애플리케이션테스트수행 문제 가져오기
	public AktsVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AktsVo vo = new AktsVo();

		try {
			pstmt = con.prepareStatement("select aktsno, question from akts where aktsno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setAktsno(rs.getInt("aktsno"));
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

	// 애플리케이션테스트수행 정답 가져오기
	public AktsVo getAnswer(AktsVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AktsVo avo = new AktsVo();

		try {
			pstmt = con.prepareStatement("select aktsno, answer from akts where aktsno=?");
			pstmt.setInt(1, vo.getAktsno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setAktsno(rs.getInt("aktsno"));
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
	
	// 애플리케이션테스트수행 다음문제 가져오기
	public AktsVo getAktsNextQuestion(AktsVo aktsvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AktsVo vo = new AktsVo();
		
		try {
			pstmt = con.prepareStatement("select aktsno, question, answer from akts where aktsno=?+1");
			pstmt.setInt(1, aktsvo.getAktsno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setAktsno(rs.getInt("aktsno"));
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
	
	// 애플리케이션테스트수행 랜덤문제 가져오기
			public AktsVo getAktsRandomQuestion() {
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				AktsVo vo = new AktsVo();
				
				try {
					pstmt = con.prepareStatement("select * from (select * from akts order by dbms_random.value) where rownum <=5 and rownum = 1");
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
					vo.setAktsno(rs.getInt("aktsno"));
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
