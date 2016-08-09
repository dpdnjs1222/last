package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리
		request.setCharacterEncoding("UTF8");
		// 2. 입력받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//체크박스같은것은 parametervalues이용
		// 3. 로직처리를 한다
		UserService service = new UserService();
		boolean result = service.login(id, pw);
		
		RequestDispatcher rd=request.getRequestDispatcher("loginResult.jsp");
		if(result){
			//세션 부여
			HttpSession session=request.getSession(true);
			session.setAttribute("USERID",id);
			request.setAttribute("flag", true);
			rd.forward(request, response);
		}else{
			request.setAttribute("flag", false);
			rd.forward(request, response);
		}
		
	}

}
