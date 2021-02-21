package stg.action.pu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.service.PuService;
import stg.vo.HgVo;
import stg.vo.PuVo;

public class PuTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그래밍언어활용 공부하러가기 
		
		// 문제 가져오기
		PuService svc = new PuService();
		PuVo vo = svc.getQuestion();
		
		request.setAttribute("puVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/pu/puTraining.jsp");
		return forward;
	}
}
