package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactsDAO;
import game_userDTO.GameUserDTO;

@WebServlet("*.message")
public class MessageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		ContactsDAO dao = ContactsDAO.getInstance();

		try {
			// 입력
			if(cmd.equals("/insert.message")) {
				// 작성자
				String writer = request.getParameter("writer");
				// 메시지
				String msg = request.getParameter("msg");

				dao.insert(new GameUserDTO(0, writer, msg, null));
				response.sendRedirect("/index.jsp");
			} 
			// 리스트
			else if(cmd.equals("/list.message")) {
				List<GameUserDTO> list = new ArrayList<>();

				list = dao.selectAll();
				request.setAttribute("list", list);			

				// list를 list.jsp로 전송
				request.getRequestDispatcher("//outputForm.jsp").forward(request, response);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
