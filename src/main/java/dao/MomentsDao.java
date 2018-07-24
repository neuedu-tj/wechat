package dao;

import com.alibaba.fastjson.JSONArray;
import config.JDBCUtils;
import domain.Moments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MomentsDao {

    public int saveMoments(Moments moments) {
        int row = 0;
        String sql = "insert into moments ( nickname , content , img  ) values ( ? , ? ,? )";
        try{
            Connection connection = new JDBCUtils().openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, moments.getNickname() );
            ps.setString(2, moments.getContent());
            ps.setString(3, moments.getImg());

            row = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public String getMoments() {
        String results = "";
        List<Moments> moments = new ArrayList<>();
        String sql = "select * from moments";
        try{
            Connection connection = new JDBCUtils().openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
            while(rs.next()) {

                Moments m = new Moments();
                m.setNickname(rs.getString("nickname"));
                m.setContent(rs.getString("content"));
                m.setImg(rs.getString("img"));
                moments.add(m);
            }

            results = JSONArray.toJSONString(moments);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


}
