package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;
import stg.vo.SqlhyVo;


public class SqlhyProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// SQL활용 문제, 답 저장하기
		String sqlhyno = request.getParameter("sqlhyno");
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
		
		SqlhyVo vo = new SqlhyVo();
		vo.setSqlhyno(Integer.parseInt(sqlhyno));
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		SqlhyService svc = new SqlhyService();
		
		svc.insertSqlhy(vo);
		
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('문제를 생성했습니다.');location.href='/puAction.do';</script>");
		out.close();
		return null;
		

	}
	
}
