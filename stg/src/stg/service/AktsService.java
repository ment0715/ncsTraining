package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.AktsDao;
import stg.vo.AktsVo;

public class AktsService {
	
	// 애플리케이션테스트수행 문제 자동증가 번호 가져오기
	public int getAktsIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		AktsDao dao = new AktsDao(con);
		
		int aktsno = dao.getAktsIncreaseNumber();
		con.close();
		return aktsno;
	}
	
	// 애플리케이션테스트수행 트레이닝 만들기
	public void insertAkts(AktsVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		AktsDao dao = new AktsDao(con);
		
		int count = dao.insertAkts(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 애플리케이션테스트수행 문제 가져오기 
	public AktsVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		AktsDao dao = new AktsDao(con);
	
		AktsVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// 애플리케이션테스트수행 정답 가져오기
	public AktsVo getAnswer(AktsVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		AktsDao dao = new AktsDao(con);
		
		AktsVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// 애플리케이션테스트수행 다음문제 가져오기
	public AktsVo getAktsNextQuestion(AktsVo aktsvo) throws Exception{
		Connection con = new DBConnection().getConnection();
		AktsDao dao = new AktsDao(con);
		
		AktsVo vo = dao.getAktsNextQuestion(aktsvo);
		
		con.close();
		
		return vo;
		
	}
	

}
