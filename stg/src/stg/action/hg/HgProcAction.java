package stg.action.hg;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.vo.HgVo;

public class HgProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면구현 문제, 답 저장하기
		String hgno = request.getParameter("hgno");
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
		
		HgVo vo = new HgVo();
		vo.setHgno(Integer.parseInt(hgno));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		HgService svc = new HgService();
		
		svc.insertHg(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/hgAction.do';</script>");
		out.close();
		return null;
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("/hgAction.do");
//		return forward;
	}
	
}
