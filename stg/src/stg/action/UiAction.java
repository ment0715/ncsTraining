package stg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UiService;

public class UiAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// UI테스트 트레이닝 만들기 페이지 이동
		
		// uino 자동증가 가져오기 
		UiService svc = new UiService();
		int uino = svc.getUiIncreaseNumber();
		
		request.setAttribute("uino", uino + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/ui/uiMake.jsp");
		return forward;
	}

}
