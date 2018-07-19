package dao;

import com.alibaba.fastjson.JSONArray;
import domain.User;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> userList = new ArrayList<User>();

    public UserDao() {

        userList.add(new User(1, "tom" , "jquery 很有意思"));
        userList.add(new User(2, "jack" , "楼上的 你疯了么 ? "));

    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }


    public static void main(String[] args) {
        UserDao dao =new UserDao();

        List<User> users = dao.getUserList();
        String json = JSONArray.toJSONString(users);

        System.out.println(json);

    }
}
