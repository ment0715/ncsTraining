package stg.action.sqlhy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.SqlhyService;

public class SqlhyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// sql활용 트레이닝 만들기 페이지 이동
		
		// sqlhyno 자동증가 가져오기 
		SqlhyService svc = new SqlhyService();
		int sqlhyno = svc.getSqlhyIncreaseNumber();
		
		request.setAttribute("sqlhyno", sqlhyno + 1);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/sqlhy/sqlhyMake.jsp");
		return forward;
	}

}
