package stg.action.akbf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;
import stg.vo.AkbfVo;


public class AkbfProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 문제, 답 저장하기
		String akbfno = request.getParameter("akbfno");
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
		
		AkbfVo vo = new AkbfVo();
		vo.setAkbfno(Integer.parseInt(akbfno));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		AkbfService svc = new AkbfService();
		
		svc.insertAkbf(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/aktsAction.do';</script>");
		out.close();
		return null;
		

	}
	
}
