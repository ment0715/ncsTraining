package stg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UiService;
import stg.vo.UiVo;


public class UiTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// UI테스트 공부하러가기 
		
		// 문제 가져오기
		UiService svc = new UiService();
		UiVo vo = svc.getQuestion();
		
		request.setAttribute("uiVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/ui/uiTraining.jsp");
		return forward;
	}
}
