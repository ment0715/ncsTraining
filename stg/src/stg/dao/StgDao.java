package stg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import stg.vo.HgVo;

public class StgDao {
	private Connection con;

	public StgDao(Connection con) {
		this.con = con;
	}
	
	// hgno 자동증가 가져오기 
	public int getHgIncreaseNumber() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int hgno = 1;
		
		try {
			pstmt = con.prepareStatement("select max(hgno) as hgno from hg");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hgno = rs.getInt("hgno");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hgno;
	}
	
	public int insertHg(HgVo vo) {
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			pstmt = con.prepareStatement("insert into hg (hgno, question, answer) values (?,?,?)");
			pstmt.setInt(1, vo.getHgno());
			pstmt.setString(2, vo.getQuestion());
			pstmt.setString(3, vo.getAnswer());
			count = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	// 문제 가져오기

}
