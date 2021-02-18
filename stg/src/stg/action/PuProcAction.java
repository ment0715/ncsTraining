package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.PuService;
import stg.vo.PuVo;

public class PuProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그램언어활용 문제, 답 저장하기
		String puno = request.getParameter("puno");
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
		
		PuVo vo = new PuVo();
		vo.setPuno(Integer.parseInt(puno));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		PuService svc = new PuService();
		
		svc.insertPu(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/puAction.do';</script>");
		out.close();
		return null;
		

	}
	
}
