package servlet;

import com.alibaba.fastjson.JSONArray;
import dao.MsgDao;
import domain.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/msg")
public class MsgServlet extends HttpServlet {

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

        String name = request.getParameter("name");
        String content = request.getParameter("msg");

        Msg msg = new Msg(name , content);

        MsgDao dao = new MsgDao();

    }
    //获取所有信息
    protected void getMsg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        MsgDao dao =new MsgDao();
        response.getWriter().print(dao.getMsgList());
    }



}