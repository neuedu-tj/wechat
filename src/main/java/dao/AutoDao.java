package dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import config.JDBCUtils;
import domain.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoDao {

        //json string
     public String loadData( String name ) {
         List<Auto> results = new ArrayList();
         String sql = "select * from auto where name like ?";
         try{
             Connection connection = new JDBCUtils().openConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setString(1,"%"+name+"%");
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Auto auto = new Auto(rs.getInt(1) , rs.getString(2));
                 results.add(auto);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return JSONArray.toJSONString(results);
     }


    public static void main(String[] args)  {

         System.out.println(new AutoDao().loadData("e"));
    }



}
