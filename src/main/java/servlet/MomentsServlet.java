package servlet;


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

        FileUtils.copyInputStreamToFile( part.getInputStream() , new File("e:/"+part.getSubmittedFileName()));


    }
}
