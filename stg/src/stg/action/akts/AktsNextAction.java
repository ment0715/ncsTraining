package stg.action.akts;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AktsService;
import stg.vo.AktsVo;

public class AktsNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션테스트수행 다음문제 가져오기 
		String aktsno = request.getParameter("aktsno");
		
		AktsVo aktsvo = new AktsVo();
		aktsvo.setAktsno(Integer.parseInt(aktsno));
		
		AktsService svc = new AktsService();
		
		AktsVo vo = svc.getAktsNextQuestion(aktsvo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("aktsNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akts/aktsNextQuestion.jsp");
		return forward;
	}

}
