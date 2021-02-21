package stg.action.sqlhy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;
import stg.vo.SqlhyVo;

public class SqlhyRandomTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// SQL활용 랜덤문제 가져오기
		
		SqlhyService svc = new SqlhyService();
		SqlhyVo vo = svc.getSqlhyRandomQuestion();
		
		
		request.setAttribute("sqlhyRandomVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/sqlhy/sqlhyRandomQuestion.jsp");
		return forward;
	}

}
