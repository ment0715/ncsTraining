package stg.action.ui;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UiService;
import stg.vo.UiVo;


public class UiRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// UI테스트 랜덤문제 가져오기
		
		UiService svc = new UiService();
		UiVo vo = svc.getUiRandomQuestion();
		
		
		request.setAttribute("uiRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/ui/uiRandomQuestion.jsp");
		return forward;
	}

}
