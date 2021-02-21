package stg.action.pu;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.PuService;
import stg.vo.PuVo;

public class PuRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그래밍언어활용 랜덤문제 가져오기
		
		PuService svc = new PuService();
		PuVo vo = svc.getPuRandomQuestion();
		
		
		request.setAttribute("puRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/pu/puRandomQuestion.jsp");
		return forward;
	}

}
