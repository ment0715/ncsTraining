package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.AkbfDao;
import stg.vo.AkbfVo;

public class AkbfService {
	
	// 애플리케이션배포 문제 자동증가 번호 가져오기
	public int getAkbfIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		AkbfDao dao = new AkbfDao(con);
		
		int akbfno = dao.getAkbfIncreaseNumber();
		con.close();
		return akbfno;
	}
	
	// 애플리케이션배포 트레이닝 만들기
	public void insertAkbf(AkbfVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		AkbfDao dao = new AkbfDao(con);
		
		int count = dao.insertAkbf(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 애플리케이션배포 문제 가져오기 
	public AkbfVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		AkbfDao dao = new AkbfDao(con);
	
		AkbfVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}
	
	// 애플리케이션배포 정답 가져오기
	public AkbfVo getAnswer(AkbfVo vo) throws Exception {
		Connection con = new DBConnection().getConnection();
		AkbfDao dao = new AkbfDao(con);
		
		AkbfVo avo = dao.getAnswer(vo);
		
		con.close();
		return avo;
		
	}
	
	// 애플리케이션배포 다음문제 가져오기
	public AkbfVo getAkbfNextQuestion(AkbfVo akbfvo) throws Exception{
		Connection con = new DBConnection().getConnection();
		AkbfDao dao = new AkbfDao(con);
		
		AkbfVo vo = dao.getAkbfNextQuestion(akbfvo);
		
		con.close();
		
		return vo;
		
	}
	

}
