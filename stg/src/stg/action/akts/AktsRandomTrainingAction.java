package stg.action.akts;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AktsService;
import stg.vo.AktsVo;

public class AktsRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션테스트수행 랜덤문제 가져오기
		
		AktsService svc = new AktsService();
		AktsVo vo = svc.getAktsRandomQuestion();
		
		
		request.setAttribute("aktsRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akts/aktsRandomQuestion.jsp");
		return forward;
	}

}
