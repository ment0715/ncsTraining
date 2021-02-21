package stg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.action.akbf.AkbfAction;
import stg.action.akbf.AkbfNextAction;
import stg.action.akbf.AkbfProcAction;
import stg.action.akbf.AkbfTrainingAction;
import stg.action.akbf.AkbfTrainingProcAction;
import stg.action.akts.AktsAction;
import stg.action.akts.AktsNextAction;
import stg.action.akts.AktsProcAction;
import stg.action.akts.AktsTrainingAction;
import stg.action.akts.AktsTrainingProcAction;
import stg.action.hg.HgAction;
import stg.action.hg.HgNextAction;
import stg.action.hg.HgProcAction;
import stg.action.hg.HgRandomTrainingAction;
import stg.action.hg.HgTrainingAction;
import stg.action.hg.HgTrainingProcAction;
import stg.action.pu.PuAction;
import stg.action.pu.PuNextAction;
import stg.action.pu.PuProcAction;
import stg.action.pu.PuRandomTrainingAction;
import stg.action.pu.PuTrainingAction;
import stg.action.pu.PuTrainingProcAction;
import stg.action.sqlhy.SqlhyAction;
import stg.action.sqlhy.SqlhyNextAction;
import stg.action.sqlhy.SqlhyProcAction;
import stg.action.sqlhy.SqlhyRandomTrainingAction;
import stg.action.sqlhy.SqlhyTrainingAction;
import stg.action.sqlhy.SqlhyTrainingProcAction;
import stg.action.ui.UiAction;
import stg.action.ui.UiNextAction;
import stg.action.ui.UiProcAction;
import stg.action.ui.UiTrainingAction;
import stg.action.ui.UiTrainingProcAction;
import stg.action.uy.UyAction;
import stg.action.uy.UyNextAction;
import stg.action.uy.UyProcAction;
import stg.action.uy.UyTrainingAction;
import stg.action.uy.UyTrainingProcAction;
import stg.common.Action;
import stg.common.ActionForward;


@WebServlet("*.do")
public class StgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getRequestURI();
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("/hgAction.do")) { // 화면구현 트레이닝만들기 이동
			action = new HgAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hgProc.do")) { // 화면구현 문제 만들기
			action = new HgProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hgTraining.do")) { // 화면구현 문제풀기 
			action = new HgTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hgTrainigProc.do")) { // 화면구현 답 확인하기
			action = new HgTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hgNext.do")) { // 화면구현 다음문제 이동하기
			action = new HgNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/randomHgTraining.do")) { // 화면구현 랜덤문제 이동하기
			action = new HgRandomTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/puAction.do")) { // 프로그래밍언어활용 트레이닝만들기 이동
			action = new PuAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/puProc.do")) { // 프로그래밍언어활용 문제 만들기
			action = new PuProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/puTraining.do")) { // 프로그래밍언어활용 문제풀기 
			action = new PuTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/puTrainigProc.do")) { // 프로그래밍언어활용 답 확인하기
			action = new PuTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/puNext.do")) { // 프로그래밍언어활용 다음문제 이동하기
			action = new PuNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/randomPuTraining.do")) { // 프로그래밍언어활용 랜덤 트레이닝
			action = new PuRandomTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/sqlhyAction.do")) { // SQL활용 트레이닝만들기 이동
			action = new SqlhyAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/sqlhyProc.do")) { // SQL활용 문제 만들기
			action = new SqlhyProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/sqlhyTraining.do")) { // SQL활용 문제풀기 
			action = new SqlhyTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/sqlhyTrainigProc.do")) { // SQL활용 답 확인하기
			action = new SqlhyTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/sqlhyNext.do")) { // SQL활용 다음문제 이동하기
			action = new SqlhyNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/randomSqlhyTraining.do")) { // SQL활용 랜덤문제 이동하기
			action = new SqlhyRandomTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uyAction.do")) { // 응용SW기초기술활용 트레이닝만들기 이동
			action = new UyAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uyProc.do")) { // 응용SW기초기술활용 문제 만들기
			action = new UyProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uyTraining.do")) { // 응용SW기초기술활용 문제풀기 
			action = new UyTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uyTrainigProc.do")) { // 응용SW기초기술활용 답 확인하기
			action = new UyTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uyNext.do")) { // 응용SW기초기술활용 다음문제 이동하기
			action = new UyNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/aktsAction.do")) { // 애플리케이션테스트수행 트레이닝만들기 이동
			action = new AktsAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/aktsProc.do")) { // 애플리케이션테스트수행 문제 만들기
			action = new AktsProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/aktsTraining.do")) { // 애플리케이션테스트수행 문제풀기 
			action = new AktsTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/aktsTrainigProc.do")) { // 애플리케이션테스트수행 답 확인하기
			action = new AktsTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/aktsNext.do")) { // 애플리케이션테스트수행 다음문제 이동하기
			action = new AktsNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/akbfAction.do")) { // 애플리케이션배포 트레이닝만들기 이동
			action = new AkbfAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/akbfProc.do")) { // 애플리케이션배포 문제 만들기
			action = new AkbfProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/akbfTraining.do")) { // 애플리케이션배포 문제풀기 
			action = new AkbfTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/akbfTrainigProc.do")) { // 애플리케이션배포 답 확인하기
			action = new AkbfTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/akbfNext.do")) { // 애플리케이션배포 다음문제 이동하기
			action = new AkbfNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uiAction.do")) { // UI테스트 트레이닝만들기 이동
			action = new UiAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uiProc.do")) { // UI테스트 문제 만들기
			action = new UiProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uiTraining.do")) { // UI테스트 문제풀기 
			action = new UiTrainingAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uiTrainigProc.do")) { // UI테스트 답 확인하기
			action = new UiTrainingProcAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/uiNext.do")) { // UI테스트 다음문제 이동하기
			action = new UiNextAction();
			
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		if (forward != null ) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	

}
