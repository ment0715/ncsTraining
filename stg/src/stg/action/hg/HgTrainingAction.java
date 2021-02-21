package stg.action.hg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.vo.HgVo;

public class HgTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면구현 공부하러가기 
		
		// 문제 가져오기
		HgService svc = new HgService();
		HgVo vo = svc.getQuestion();
		
		request.setAttribute("hgVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/hg/hgTraining.jsp");
		return forward;
	}
}
