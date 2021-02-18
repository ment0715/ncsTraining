package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.SqlhyVo;


public class SqlhyDao {
	private Connection con;

	public SqlhyDao(Connection con) {
		this.con = con;
	}

	// sqlhyno 자동증가 가져오기
	public int getSqlhyIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sqlhyno = 1;

		try {
			pstmt = con.prepareStatement("select max(sqlhyno) as sqlhyno from sqlhy");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sqlhyno = rs.getInt("sqlhyno");
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
		return sqlhyno;
	}

	public int insertSqlhy(SqlhyVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			pstmt = con.prepareStatement("insert into sqlhy (sqlhyno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getSqlhyno());
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

	// SQL활용 문제 가져오기
	public SqlhyVo getQuestion() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SqlhyVo vo = new SqlhyVo();

		try {
			pstmt = con.prepareStatement("select sqlhyno, question from sqlhy where sqlhyno=1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setSqlhyno(rs.getInt("sqlhyno"));
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

	// SQL활용 정답 가져오기
	public SqlhyVo getAnswer(SqlhyVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SqlhyVo avo = new SqlhyVo();

		try {
			pstmt = con.prepareStatement("select sqlhyno, answer from sqlhy where sqlhyno=?");
			pstmt.setInt(1, vo.getSqlhyno());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avo.setSqlhyno(rs.getInt("sqlhyno"));
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
	
	// SQL활용 다음문제 가져오기
	public SqlhyVo getSqlhyNextQuestion(SqlhyVo pvo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SqlhyVo vo = new SqlhyVo();
		
		try {
			pstmt = con.prepareStatement("select sqlhyno, question, answer from sqlhy where sqlhyno=?+1");
			pstmt.setInt(1, pvo.getSqlhyno());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo.setSqlhyno(rs.getInt("sqlhyno"));
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
