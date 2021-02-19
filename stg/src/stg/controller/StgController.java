package stg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
