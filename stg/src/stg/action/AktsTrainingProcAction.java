package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AktsService;
import stg.vo.AktsVo;

public class AktsTrainingProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션테스트수행 문제 풀이 바로하기
		String aktsno = request.getParameter("aktsno");
		String answer = request.getParameter("answer");
		
		AktsVo vo = new AktsVo();
		vo.setAktsno(Integer.parseInt(aktsno));
		vo.setAnswer(answer);
		
		AktsService svc = new AktsService();
		
		// 정답 가져오기 
		AktsVo avo = svc.getAnswer(vo);
		
	
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
		forward.setPath("/aktsTrainigProc.do");
		return forward;
	}

}
