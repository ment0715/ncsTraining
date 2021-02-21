package stg.action.akts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AktsService;

public class AktsAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션테스트수행 트레이닝 만들기 페이지 이동
		
		// aktsno 자동증가 가져오기 
		AktsService svc = new AktsService();
		int aktsno = svc.getAktsIncreaseNumber();
		
		request.setAttribute("aktsno", aktsno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akts/aktsMake.jsp");
		return forward;
	}

}
