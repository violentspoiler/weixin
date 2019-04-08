package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
/**
 * 用户注册，发送code获取openid，作为userId存入数据库
 * @author 韶琪
 *
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");   //拿到微信小程序传过来的code
        String method=request.getParameter("method");
        try {//用户注册
			String str=new UserService().doWhat(code);
			System.out.println(str);
			response.getWriter().write(str);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
