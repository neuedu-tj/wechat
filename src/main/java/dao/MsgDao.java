package dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import domain.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgDao {

    private List<Msg> msgList = new ArrayList<Msg>();

    public MsgDao() {

        msgList.add(new Msg("tom1" , "jquery aaaa"));
        msgList.add(new Msg("jack1" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose1" , "jquery 真疯了"));
        msgList.add(new Msg("boss1" , "都不想干了么???"));

        msgList.add(new Msg("tom2" , "jquery aaaa"));
        msgList.add(new Msg("jack2" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose2" , "jquery 真疯了"));
        msgList.add(new Msg("boss2" , "都不想干了么???"));

        msgList.add(new Msg("tom3" , "jquery aaaa"));
        msgList.add(new Msg("jack3" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose3" , "jquery 真疯了"));
        msgList.add(new Msg("boss3" , "都不想干了么???"));

        msgList.add(new Msg("tom4" , "jquery aaaa"));
        msgList.add(new Msg("jack4" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose4" , "jquery 真疯了"));
        msgList.add(new Msg("boss4" , "都不想干了么???"));

        msgList.add(new Msg("tom5" , "jquery aaaa"));
        msgList.add(new Msg("jack5" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose5" , "jquery 真疯了"));
        msgList.add(new Msg("boss5" , "都不想干了么???"));

        msgList.add(new Msg("tom6" , "jquery aaaa"));
        msgList.add(new Msg("jack6" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose6" , "jquery 真疯了"));
        msgList.add(new Msg("boss6" , "都不想干了么???"));

        msgList.add(new Msg("tom7" , "jquery aaaa"));
        msgList.add(new Msg("jack7" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose7" , "jquery 真疯了"));
        msgList.add(new Msg("boss7" , "都不想干了么???"));

        msgList.add(new Msg("tom8" , "jquery aaaa"));
        msgList.add(new Msg("jack8" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose8" , "jquery 真疯了"));
        msgList.add(new Msg("boss8" , "都不想干了么???"));

        msgList.add(new Msg("tom9" , "jquery aaaa"));
        msgList.add(new Msg("jack9" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose9" , "jquery 真疯了"));
        msgList.add(new Msg("boss9" , "都不想干了么???"));

        msgList.add(new Msg("tom10" , "jquery aaaa"));
        msgList.add(new Msg("jack10" , "楼上的 你疯了么 ? "));
        msgList.add(new Msg("rose10" , "jquery 真疯了"));
        msgList.add(new Msg("boss10" , "都不想干了么???"));


    }

    public String getMsgList() {
        return JSONArray.toJSONString(msgList);
    }


    public String getMsgByPage(int pageNo) {

        int start = (pageNo-1)*8;
        if(pageNo*8 > msgList.size()) return null;
        else return JSONArray.toJSONString( msgList.subList(start , pageNo*8));

    }

    public void addMsg(Msg msg) {
        msgList.add(msg);
        System.out.println(msgList.size());
    }

    public static void main(String[] args) {
        String info = new MsgDao().getMsgByPage(3);

        System.out.println(info);

    }

}
