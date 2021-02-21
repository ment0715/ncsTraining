package stg.action.akbf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;
import stg.vo.AkbfVo;

public class AkbfNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 다음문제 가져오기 
		String akbfno = request.getParameter("akbfno");
		
		AkbfVo akbfvo = new AkbfVo();
		akbfvo.setAkbfno(Integer.parseInt(akbfno));
		
		AkbfService svc = new AkbfService();
		
		AkbfVo vo = svc.getAkbfNextQuestion(akbfvo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("akbfNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/akbf/akbfNextQuestion.jsp");
		return forward;
	}

}
