package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UiService;
import stg.vo.UiVo;

public class UiProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// UI테스트 문제, 답 저장하기
		String uino = request.getParameter("uino");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		if (question == null || question.equals("")
				|| answer == null || answer.equals("")) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		UiVo vo = new UiVo();
		vo.setUino(Integer.parseInt(uino));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		UiService svc = new UiService();
		
		svc.insertUi(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/uiAction.do';</script>");
		out.close();
		return null;
		

	}
	
}
