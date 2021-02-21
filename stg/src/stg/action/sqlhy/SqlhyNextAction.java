package stg.action.sqlhy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;
import stg.vo.SqlhyVo;

public class SqlhyNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// SQL활용 다음문제 가져오기 
		String sqlhyno = request.getParameter("sqlhyno");
		
		SqlhyVo svo = new SqlhyVo();
		svo.setSqlhyno(Integer.parseInt(sqlhyno));
		
		SqlhyService svc = new SqlhyService();
		
		SqlhyVo vo = svc.getSqlhyNextQuestion(svo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("sqlhyNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/sqlhy/sqlhyNextQuestion.jsp");
		return forward;
	}

}
