package stg.action.uy;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.UyService;
import stg.vo.UyVo;

public class UyNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 응용SW기초기술활용 다음문제 가져오기 
		String uyno = request.getParameter("uyno");
		
		UyVo uyvo = new UyVo();
		uyvo.setUyno(Integer.parseInt(uyno));
		
		UyService svc = new UyService();
		
		UyVo vo = svc.getUyNextQuestion(uyvo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("uyNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/uy/uyNextQuestion.jsp");
		return forward;
	}

}
