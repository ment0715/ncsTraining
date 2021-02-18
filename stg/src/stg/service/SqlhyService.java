package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.SqlhyDao;
import stg.vo.SqlhyVo;

public class SqlhyService {
	
	// SQL활용 문제 자동증가 번호 가져오기
	public int getSqlhyIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		SqlhyDao dao = new SqlhyDao(con);
		
		int sqlhyno = dao.getSqlhyIncreaseNumber();
		con.close();
		return sqlhyno;
	}
	
	// SQL활용 트레이닝 만들기
	public void insertSqlhy(SqlhyVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		SqlhyDao dao = new SqlhyDao(con);
		
		int count = dao.insertSqlhy(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// SQL활용 문제 가져오기 
	public SqlhyVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		SqlhyDao dao = new SqlhyDao(con);
	
		SqlhyVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// SQL활용 정답 가져오기
	public SqlhyVo getAnswer(SqlhyVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		SqlhyDao dao = new SqlhyDao(con);
		
		SqlhyVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// SQL활용 다음문제 가져오기
	public SqlhyVo getSqlhyNextQuestion(SqlhyVo svo) throws Exception{
		Connection con = new DBConnection().getConnection();
		SqlhyDao dao = new SqlhyDao(con);
		
		SqlhyVo vo = dao.getSqlhyNextQuestion(svo);
		
		con.close();
		
		return vo;
		
	}
	

}
