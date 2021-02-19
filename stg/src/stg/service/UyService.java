package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.UyDao;
import stg.vo.UyVo;

public class UyService {
	
	// 응용SW기초기술활용 문제 자동증가 번호 가져오기
	public int getUyIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		UyDao dao = new UyDao(con);
		
		int uyno = dao.getUyIncreaseNumber();
		con.close();
		return uyno;
	}
	
	// 응용SW기초기술활용 트레이닝 만들기
	public void insertUy(UyVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		UyDao dao = new UyDao(con);
		
		int count = dao.insertUy(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 응용SW기초기술활용 문제 가져오기 
	public UyVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		UyDao dao = new UyDao(con);
	
		UyVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// 응용SW기초기술활용 정답 가져오기
	public UyVo getAnswer(UyVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		UyDao dao = new UyDao(con);
		
		UyVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// 응용SW기초기술활용 다음문제 가져오기
	public UyVo getUyNextQuestion(UyVo uyvo) throws Exception{
		Connection con = new DBConnection().getConnection();
		UyDao dao = new UyDao(con);
		
		UyVo vo = dao.getUyNextQuestion(uyvo);
		
		con.close();
		
		return vo;
		
	}
	

}
