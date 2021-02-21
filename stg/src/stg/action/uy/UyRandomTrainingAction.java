package stg.action.uy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UyService;
import stg.vo.UyVo;

public class UyRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 응용SW기초기술활용 랜덤문제 가져오기
		
		UyService svc = new UyService();
		UyVo vo = svc.getUyRandomQuestion();
		
		
		request.setAttribute("uyRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/uy/uyRandomQuestion.jsp");
		return forward;
	}

}
