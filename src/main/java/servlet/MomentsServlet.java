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

        Part part = request.getPart("img");

        //文件存入E盘
        FileUtils.copyInputStreamToFile( part.getInputStream() , new File("e:/wechat/img/"+part.getSubmittedFileName()));

        //文件的网络访问路径 , 是图片服务器地址
        String url = "http://localhost:8080/wechat/img/"+part.getSubmittedFileName();

        moments.setImg(url);

        MomentsDao momentsDao = new MomentsDao();
        int row = momentsDao.saveMoments(moments);

        System.out.println("row : " + row);
    }
}
