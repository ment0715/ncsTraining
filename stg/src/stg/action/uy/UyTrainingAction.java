package stg.action.uy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UyService;
import stg.vo.UyVo;


public class UyTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 응용SW기초기술활용 공부하러가기 
		
		// 문제 가져오기
		UyService svc = new UyService();
		UyVo vo = svc.getQuestion();
		
		request.setAttribute("uyVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/uy/uyTraining.jsp");
		return forward;
	}
}
