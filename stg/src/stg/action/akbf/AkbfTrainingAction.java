package stg.action.akbf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;
import stg.vo.AkbfVo;


public class AkbfTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 공부하러가기 
		
		// 문제 가져오기
		AkbfService svc = new AkbfService();
		AkbfVo vo = svc.getQuestion();
		
		request.setAttribute("akbfVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/akbf/akbfTraining.jsp");
		return forward;
	}
}
