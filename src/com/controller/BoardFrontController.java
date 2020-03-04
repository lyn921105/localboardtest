package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.BoardCommand;
import com.service.BoardDeleteCommand;
import com.service.BoardListCommand;
import com.service.BoardReplyUICommand;
import com.service.BoardRetrieveCommand;
import com.service.BoardSearchCommand;
import com.service.BoardUpdateCommand;
import com.service.BoardWriteCommand;
import com.service.BoardpwdCheckCommand;
import com.service.BoardpwdCheckFormCommand;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		BoardCommand command = null;
		String nextPage = null;

		// 목록보기
		if (com.equals("/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			nextPage = "list.jsp";
		}

		// 글쓰기
		if (com.equals("/write.do")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			nextPage = "list.do";
		}

		// 글쓰기 폼
		if (com.equals("/writeui.do")) {
			nextPage = "write.jsp";
		}

		// 글 자세히보기
		if (com.equals("/retrieve.do")) {
			command = new BoardRetrieveCommand();
			command.execute(request, response);
			nextPage = "retrieve.jsp";
		}

		// 비밀번호 입력 화면
		if (com.equals("/pwdCheckui.do")) {
			command = new BoardpwdCheckFormCommand();
			command.execute(request, response);
			nextPage = "passwdChk.jsp";
		}

		// 비밀번호 체크
		if (com.equals("/pwdCheck.do")) {
			command = new BoardpwdCheckCommand();
			command.execute(request, response);
			nextPage = (String) request.getAttribute("resultUrl");
		}

		// 글 수정 화면 보기
		if (com.equals("/updateui.do")) {
			command = new BoardRetrieveCommand();
			command.execute(request, response);
			nextPage = "update.jsp";
		}

		// 글 수정 하기
		if (com.equals("/update.do")) {
			command = new BoardUpdateCommand();
			command.execute(request, response);
			nextPage = "list.do";
		}

		// 글 삭제 하기
		if (com.equals("/delete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			nextPage = "list.do";
		}

		// 글 검색 하기
		if (com.equals("/search.do")) {
			command = new BoardSearchCommand();
			command.execute(request, response);
			nextPage = "list.jsp";
		}

		// 답변글 입력 폼 보기
		if (com.equals("/replyui.do")) {
			command = new BoardReplyUICommand();
			command.execute(request, response);
			nextPage = "reply.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

}
