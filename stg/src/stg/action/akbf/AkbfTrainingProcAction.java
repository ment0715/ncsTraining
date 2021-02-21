package stg.action.akbf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.AkbfService;
import stg.vo.AkbfVo;

public class AkbfTrainingProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 애플리케이션배포 문제 풀이 바로하기
		String akbfno = request.getParameter("akbfno");
		String answer = request.getParameter("answer");
		
		AkbfVo vo = new AkbfVo();
		vo.setAkbfno(Integer.parseInt(akbfno));
		vo.setAnswer(answer);
		
		AkbfService svc = new AkbfService();
		
		// 정답 가져오기 
		AkbfVo avo = svc.getAnswer(vo);
		
	
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
		forward.setPath("/akbfTrainigProc.do");
		return forward;
	}

}
