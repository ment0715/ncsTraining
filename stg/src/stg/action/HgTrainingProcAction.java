package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.vo.HgVo;

public class HgTrainingProcAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면구현 문제 풀이 바로하기
		String hgno = request.getParameter("hgno");
		String answer = request.getParameter("answer");
		
		HgVo avo = new HgVo();
		avo.setHgno(Integer.parseInt(hgno));
		avo.setAnswer(answer);
		
		HgService svc = new HgService();
		
		// 정답 가져오기 
		HgVo vo = svc.getAnswer(avo);
		
	
		// 오답일 경우
		if (!answer.equals(vo.getAnswer())) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('저런.. 다시 생각해보세요..');history.back();</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/hg/hgTraining.jsp");
		return forward;
	}

}
