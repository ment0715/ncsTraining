package stg.action.akbf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;

public class AkbfAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 트레이닝 만들기 페이지 이동
		
		// akbfno 자동증가 가져오기 
		AkbfService svc = new AkbfService();
		int akbfno = svc.getAkbfIncreaseNumber();
		
		request.setAttribute("akbfno", akbfno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akbf/akbfMake.jsp");
		return forward;
	}

}
