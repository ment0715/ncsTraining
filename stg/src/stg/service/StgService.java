package stg.service;

import java.sql.Connection;

import stg.common.DBConnection;
import stg.dao.StgDao;
import stg.vo.HgVo;

public class StgService {
	
	public int getHgIncreaseNumber() throws Exception {
		Connection con = new DBConnection().getConnection();
		StgDao dao = new StgDao(con);
		
		int hgno = dao.getHgIncreaseNumber();
		con.close();
		return hgno;
	}
	
	// 문제번호 자동증가 가져오기 
	public void insertHg(HgVo vo) throws Exception{
		Connection con = new DBConnection().getConnection();
		StgDao dao = new StgDao(con);
		
		int count = dao.insertHg(vo);
		
		if (count > 0) {
			con.commit();
		}else {
			con.rollback();
		}
		con.close();
	}
	
	// 문제 가져오기 
	public HgVo getQuestion() throws Exception {
		Connection con = new DBConnection().getConnection();
		StgDao dao  = new StgDao(con);
	
		HgVo vo = dao.getQuestion();
		
		con.close();
		return vo;
	}

}
