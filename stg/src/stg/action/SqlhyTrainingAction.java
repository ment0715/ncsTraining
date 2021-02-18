package stg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;
import stg.vo.SqlhyVo;


public class SqlhyTrainingAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// SQL활용 공부하러가기 
		
		// 문제 가져오기
		SqlhyService svc = new SqlhyService();
		SqlhyVo vo = svc.getQuestion();
		
		request.setAttribute("sqlhyVo", vo);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("views/module/sqlhy/sqlhyTraining.jsp");
		return forward;
	}
}
