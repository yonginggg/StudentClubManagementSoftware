package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanMember;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    //查询member信息
    public List<JSONObject> selectMember(String userid, int associationid) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject = null;
        List<BeanMember> member1 = null;
        SqlSession session = MybatiesSession.getSession();
        BeanMember member =new BeanMember();
        member.setUserid(userid);
        member.setAssociationsid(associationid);

       member1 =session.selectList("selectMember",member);
       
        if(member1==null){
            jsonObject = JsonUtil.errorResult(401, "用户信息不存在");
        }
        else{
            for(int i=0;i<member1.size();i++) {
                jsonObject = JsonUtil.MemberResult(200, member1.get(i));
                list.add(jsonObject);
            }}
        session.commit();
        return list;

    }
//    public static void main(String[] args) throws Exception {
//        MemberService a = new MemberService();
//        JSONObject zs = (JSONObject) a.selectMember("1",1);
//        System.out.println(zs);
//    }
}
