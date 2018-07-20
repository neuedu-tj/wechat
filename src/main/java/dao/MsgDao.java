package dao;

import com.alibaba.fastjson.JSONArray;
import domain.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgDao {

    private List<Msg> msgList = new ArrayList<Msg>();

    public MsgDao() {

        msgList.add(new Msg("tom" , "jquery aaaa"));
        msgList.add(new Msg("jack" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose" , "jquery 真疯了"));
        msgList.add(new Msg("boss" , "都不想干了么???"));

    }

    public String getMsgList() {
        return JSONArray.toJSONString(msgList);
    }

    public void addMsg(Msg msg) {

        msgList.add(msg);

        System.out.println(msgList.size());

    }

}
