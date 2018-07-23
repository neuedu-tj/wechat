package servlet;

import dao.AutoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auto")
public class AutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        response.setCharacterEncoding("utf-8");
        AutoDao dao = new AutoDao();
        response.getWriter().print(dao.loadData(name));


    }
}
