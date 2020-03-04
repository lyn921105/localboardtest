package com.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;

public class BoardpwdCheckCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String mode = request.getParameter("mod");
		String passwd = request.getParameter("passwd");

		BoardDAO dao = new BoardDAO();
		Map<String, String> map = dao.pwdCheck(num, mode, passwd);
		request.setAttribute("num", num);
		request.setAttribute("resultUrl", map.get("resultUrl"));
		request.setAttribute("resultMsg", map.get("resultMsg"));

	}

}
