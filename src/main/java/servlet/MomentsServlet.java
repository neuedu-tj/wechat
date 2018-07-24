package servlet;


import dao.MomentsDao;
import domain.Moments;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/moments")
@MultipartConfig
public class MomentsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String content = request.getParameter("content");

        Moments moments = new Moments();
        moments.setNickname(nickname);
        moments.setContent(content);

        StringBuilder url = new StringBuilder();
        Collection<Part> parts = request.getParts();

        for (Part p : parts) {
            if("img".equalsIgnoreCase(p.getName())) {
                FileUtils.copyInputStreamToFile( p.getInputStream() , new File("e:/wechat/img/"+p.getSubmittedFileName()));
                url.append("http://localhost:8080/wechat/img/"+p.getSubmittedFileName()).append(";");
            }
        }
        url.delete(url.length()-1 , url.length());

        //文件存入E盘


        //文件的网络访问路径 , 是图片服务器地址


        moments.setImg(url.toString());

        MomentsDao momentsDao = new MomentsDao();
        int row = momentsDao.saveMoments(moments);

        System.out.println("row : " + row);
    }
}
