package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.PuService;
import stg.vo.PuVo;

public class PuNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그래밍언어활용 다음문제 가져오기 
		String puno = request.getParameter("puno");
		
		PuVo pvo = new PuVo();
		pvo.setPuno(Integer.parseInt(puno));
		
		PuService svc = new PuService();
		
		PuVo vo = svc.getPuNextQuestion(pvo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("puNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/pu/puNextQuestion.jsp");
		return forward;
	}

}
