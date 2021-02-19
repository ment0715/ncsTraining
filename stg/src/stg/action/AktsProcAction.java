package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AktsService;
import stg.vo.AktsVo;


public class AktsProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션테스트수행 문제, 답 저장하기
		String aktsno = request.getParameter("aktsno");
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
		
		AktsVo vo = new AktsVo();
		vo.setAktsno(Integer.parseInt(aktsno));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		AktsService svc = new AktsService();
		
		svc.insertAkts(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/aktsAction.do';</script>");
		out.close();
		return null;
		

	}
	
}
