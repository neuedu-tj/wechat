package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service~~~~~~");

        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");

        System.out.println("name : "+ name );

        try{
            Thread.sleep(1000);
        }catch (Exception e) {

        }


        PrintWriter out = response.getWriter();

        if("tom".equalsIgnoreCase(name)) {
            out.print("err");
        } else {
            out.print("ok");
        }



    }
}
