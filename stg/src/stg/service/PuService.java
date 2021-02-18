package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.PuDao;
import stg.vo.PuVo;

public class PuService {
	
	// 프로그래밍언어활용 문제 자동증가 번호 가져오기
	public int getPuIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		PuDao dao = new PuDao(con);
		
		int puno = dao.getPuIncreaseNumber();
		con.close();
		return puno;
	}
	
	// 프로그래밍언어활용 트레이닝 만들기
	public void insertPu(PuVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		PuDao dao = new PuDao(con);
		
		int count = dao.insertPu(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 프로그래밍언어활용 문제 가져오기 
	public PuVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		PuDao dao = new PuDao(con);
	
		PuVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// 프로그래밍언어활용 정답 가져오기
	public PuVo getAnswer(PuVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		PuDao dao = new PuDao(con);
		
		PuVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// 프로그래밍언어활용 다음문제 가져오기
	public PuVo getPuNextQuestion(PuVo pvo) throws Exception{
		Connection con = new DBConnection().getConnection();
		PuDao dao = new PuDao(con);
		
		PuVo vo = dao.getPuNextQuestion(pvo);
		
		con.close();
		
		return vo;
		
	}
	

}
