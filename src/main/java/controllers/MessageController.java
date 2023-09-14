package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAO;
import game_userDTO.GameUserDTO;

@WebServlet("*.message")
public class MessageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		MessageDAO dao = MessageDAO.getInstance();

		try {
			// 입력
			if(cmd.equals("/insert.message")) {
				// 작성자
				String writer = request.getParameter("writer");
				// 메시지
				String message = request.getParameter("message");

				dao.insertgit(new GameUserDTO(0, writer, message, null));
				response.sendRedirect("/index.jsp");
			} 
			// 리스트
			else if(cmd.equals("/list.message")) {
				List<MessageDTO> list = new ArrayList<>();

				list = dao.selectAll();
				request.setAttribute("list", list);			

				// list를 list.jsp로 전송
				request.getRequestDispatcher("/list.jsp").forward(request, response);
			}
			// 번호로 검색하여 삭제
			else if(cmd.equals("/delete.message")) {
				// 검색에 사용할 번호
				int seq = Integer.parseInt(request.getParameter("seq"));

				dao.deleteBySeq(seq);

				response.sendRedirect("/list.message");

			} 
			// 수정
			else if(cmd.equals("/update.message")) {
				// 수정할 이름
				String writer = request.getParameter("writer");
				// 수정할 내용
				String message = request.getParameter("message");
				// 검색에 사용할 번호
				int seq = Integer.parseInt(request.getParameter("seq"));

				dao.updateBySeq(new GameUserDTO(seq, writer, message, null));
				response.sendRedirect("/list.message");

			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
