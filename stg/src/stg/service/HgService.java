package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.HgDao;
import stg.vo.HgVo;

public class HgService {
	
	public int getHgIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		HgDao dao = new HgDao(con);
		
		int hgno = dao.getHgIncreaseNumber();
		con.close();
		return hgno;
	}
	
	// 화면구현 문제번호 자동증가 가져오기 
	public void insertHg(HgVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		HgDao dao = new HgDao(con);
		
		int count = dao.insertHg(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 화면구현 문제 가져오기 
	public HgVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		HgDao dao = new HgDao(con);
	
		HgVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// 화면구현 정답 가져오기
	public HgVo getAnswer(HgVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		HgDao dao = new HgDao(con);
		
		HgVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// 화면구현 다음문제 가져오기
	public HgVo getHgNextQuestion(HgVo hvo) throws Exception{
		Connection con = new DBConnection().getConnection();
		HgDao dao = new HgDao(con);
		
		HgVo vo = dao.getHgNextQuestion(hvo);
		
		con.close();
		
		return vo;
		
	}
	

}
