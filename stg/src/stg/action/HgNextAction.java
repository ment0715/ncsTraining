package stg.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.common.Action;
import stg.common.ActionForward;
import stg.service.HgService;
import stg.vo.HgVo;

public class HgNextAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 다음문제 가져오기 
		String hgno = request.getParameter("hgno");
		
		HgVo hvo = new HgVo();
		hvo.setHgno(Integer.parseInt(hgno));
		
		HgService svc = new HgService();
		
		HgVo vo = svc.getHgNextQuestion(hvo);
		
		// 다음문제가 없을경우 예외처리
		if (vo.getQuestion() == null) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('다음문제가 없습니다.');history.back();</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("hgNextVo", vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/views/module/hg/hgNextQuestion.jsp");
		return forward;
	}

}
