package stg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stg.action.AkbfAction;
import stg.action.AkbfNextAction;
import stg.action.AkbfProcAction;
import stg.action.AkbfTrainingAction;
import stg.action.AkbfTrainingProcAction;
import stg.action.AktsAction;
import stg.action.AktsNextAction;
import stg.action.AktsProcAction;
import stg.action.AktsTrainingAction;
import stg.action.AktsTrainingProcAction;
import stg.action.HgAction;
import stg.action.HgNextAction;
import stg.action.HgProcAction;
import stg.action.HgTrainingAction;
import stg.action.HgTrainingProcAction;
import stg.action.PuAction;
import stg.action.PuNextAction;
import stg.action.PuProcAction;
import stg.action.PuTrainingAction;
import stg.action.PuTrainingProcAction;
import stg.action.SqlhyAction;
import stg.action.SqlhyNextAction;
import stg.action.SqlhyProcAction;
import stg.action.SqlhyTrainingAction;
import stg.action.SqlhyTrainingProcAction;
import stg.action.UiAction;
import stg.action.UiNextAction;
import stg.action.UiProcAction;
import stg.action.UiTrainingAction;
import stg.action.UiTrainingProcAction;
import stg.action.UyAction;
import stg.action.UyNextAction;
import stg.action.UyProcAction;
import stg.action.UyTrainingAction;
import stg.action.UyTrainingProcAction;
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
