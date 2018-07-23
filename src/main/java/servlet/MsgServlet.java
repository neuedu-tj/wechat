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

@WebServlet(value="/msg" , loadOnStartup = 1)
public class MsgServlet extends HttpServlet {
//
//    @Override
//    public void init() throws ServletException {
//        System.out.println("init ~~~~~~~~~~~~~~~~~");
//    }
    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        if("addMsg".equalsIgnoreCase(method)) {
            addMsg(request , response);
        } else if("getMsg".equalsIgnoreCase(method)) {
            getMsg(request , response);
        } else if("getMsgByPage".equalsIgnoreCase(method)) {
            getMsgByPage(request ,response);
        }
    }

    //按照分页获取信息
    protected void getMsgByPage(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        int pageNo = Integer.parseInt(request.getParameter("pageNo"));

        MsgDao dao = new MsgDao();
        String json = dao.getMsgByPage(pageNo);

        response.getWriter().print(json);

    }

    //发送信息
    protected void addMsg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String content = request.getParameter("msg");

        Msg msg = new Msg(name , content);

        MsgDao dao = new MsgDao();

        dao.addMsg(msg);

    }
    //获取所有信息
    protected void getMsg(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        MsgDao dao =new MsgDao();
        response.getWriter().print(dao.getMsgList());
    }

}
