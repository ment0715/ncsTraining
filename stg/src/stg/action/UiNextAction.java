package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UiService;
import stg.vo.UiVo;

public class UiNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// UI테스트 다음문제 가져오기 
		String uino = request.getParameter("uino");
		
		UiVo uivo = new UiVo();
		uivo.setUino(Integer.parseInt(uino));
		
		UiService svc = new UiService();
		
		UiVo vo = svc.getUiNextQuestion(uivo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("uiNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/ui/uiNextQuestion.jsp");
		return forward;
	}

}
