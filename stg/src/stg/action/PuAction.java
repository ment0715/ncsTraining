package stg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.PuService;

public class PuAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그래밍언어활용 트레이닝 만들기 페이지 이동
		
		// puno 자동증가 가져오기 
		PuService svc = new PuService();
		int puno = svc.getPuIncreaseNumber();
		
		request.setAttribute("puno", puno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/pu/puMake.jsp");
		return forward;
	}

}
