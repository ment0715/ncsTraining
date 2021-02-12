package stg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.StgService;

public class HgAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면구현 문제 만들기 페이지 이동
		
		// hgno 자동증가 가져오기 
		StgService svc = new StgService();
		int hgno = svc.getHgIncreaseNumber();
		
		request.setAttribute("hgno", hgno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/hg/hgMake.jsp");
		return forward;
	}

}
