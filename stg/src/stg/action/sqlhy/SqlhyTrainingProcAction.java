package stg.action.sqlhy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;
import stg.vo.SqlhyVo;

public class SqlhyTrainingProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// SQL활용 문제 풀이 바로하기
		String sqlhyno = request.getParameter("sqlhyno");
		String answer = request.getParameter("answer");
		
		SqlhyVo vo = new SqlhyVo();
		vo.setSqlhyno(Integer.parseInt(sqlhyno));
		vo.setAnswer(answer);
		
		SqlhyService svc = new SqlhyService();
		
		// 정답 가져오기 
		SqlhyVo avo = svc.getAnswer(vo);
		
	
		// 오답일 경우
		if (!answer.equals(avo.getAnswer())) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다시 한번 생각해보세요.');history.back();</script>");
			out.close();
			return null;
		}
		
		// 정답일 경우
		if (answer.equals(avo.getAnswer())) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('정답입니다.');history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/sqlhyTrainigProc.do");
		return forward;
	}

}
