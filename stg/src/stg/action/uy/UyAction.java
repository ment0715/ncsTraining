package stg.action.uy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UyService;

public class UyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 응용SW기초기술활용 트레이닝 만들기 페이지 이동
		
		// uyno 자동증가 가져오기 
		UyService svc = new UyService();
		int uyno = svc.getUyIncreaseNumber();
		
		request.setAttribute("uyno", uyno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/uy/uyMake.jsp");
		return forward;
	}

}
