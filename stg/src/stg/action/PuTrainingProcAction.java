package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.service.PuService;
import stg.vo.HgVo;
import stg.vo.PuVo;

public class PuTrainingProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 프로그래밍언어활용 문제 풀이 바로하기
		String puno = request.getParameter("puno");
		String answer = request.getParameter("answer");
		
		PuVo vo = new PuVo();
		vo.setPuno(Integer.parseInt(puno));
		vo.setAnswer(answer);
		
		PuService svc = new PuService();
		
		// 정답 가져오기 
		PuVo avo = svc.getAnswer(vo);
		
	
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
		forward.setPath("/puTrainigProc.do");
		return forward;
	}

}
