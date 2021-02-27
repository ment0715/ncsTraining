package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.UiDao;
import stg.dao.UyDao;
import stg.vo.UiVo;
import stg.vo.UyVo;

public class UiService {
	
	// UI테스트 문제 자동증가 번호 가져오기
	public int getUiIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
		
		int uino = dao.getUiIncreaseNumber();
		con.close();
		return uino;
	}
	
	// UI테스트 트레이닝 만들기
	public void insertUi(UiVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
		
		int count = dao.insertUi(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// UI테스트 문제 가져오기 
	public UiVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
	
		UiVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// UI테스트 정답 가져오기
	public UiVo getAnswer(UiVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
		
		UiVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// UI테스트 다음문제 가져오기
	public UiVo getUiNextQuestion(UiVo uivo) throws Exception{
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
		
		UiVo vo = dao.getUiNextQuestion(uivo);
		
		con.close();
		
		return vo;
		
	}
	
	// UI테스트 랜덤문제 가져오기
	public UiVo getUiRandomQuestion() throws Exception{
		Connection con = new DBConnection().getConnection();
		UiDao dao = new UiDao(con);
		
		UiVo vo = dao.getUiRandomQuestion();
		
		con.close();
		
		return vo;
		
	}
	

}
