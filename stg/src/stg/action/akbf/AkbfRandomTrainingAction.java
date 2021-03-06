package stg.action.akbf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;
import stg.vo.AkbfVo;

public class AkbfRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 랜덤문제 가져오기
		
		AkbfService svc = new AkbfService();
		AkbfVo vo = svc.getAkbfRandomQuestion();
		
		
		request.setAttribute("akbfRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akbf/akbfRandomQuestion.jsp");
		return forward;
	}

}
