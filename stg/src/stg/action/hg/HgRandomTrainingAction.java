package stg.action.hg;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.vo.HgVo;


public class HgRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면구현 랜덤문제 가져오기
		
		HgService svc = new HgService();
		HgVo vo = svc.getHgRandomQuestion();
		
		
		request.setAttribute("hgRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/hg/hgRandomQuestion.jsp");
		return forward;
	}

}
