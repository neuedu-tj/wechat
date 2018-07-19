package servlet;

import com.alibaba.fastjson.JSONArray;
import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        if("addMsg".equalsIgnoreCase(method)) {
            addMsg(request , response);
        } else if("getMsg".equalsIgnoreCase(method)) {
            getMsg(request , response);
        }
    }

    //发送信息
    protected void addMsg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        System.out.println("addMsg");
        response.getWriter().print("");
    }
    //获取所有信息
    protected void getMsg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        System.out.println("getMsg");

        UserDao dao =new UserDao();

        List<User> users = dao.getUserList();
        String json = JSONArray.toJSONString(users);
        response.getWriter().print(json);
    }



}
