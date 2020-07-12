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
        List<BeanMember> memberList = null;
        SqlSession session = MybatiesSession.getSession();
        BeanMember member =new BeanMember();
        member.setUserid(userid);
        member.setAssociationsid(associationid);

        memberList =session.selectList("selectMember",member);

        if(memberList==null){
            jsonObject = JsonUtil.errorResult(401, "用户信息不存在");
        }
        else{
            for(int i=0;i<memberList.size();i++) {
                jsonObject = JsonUtil.MemberResult(200, memberList.get(i));
                list.add(jsonObject);
            }}
        session.commit();
        return list;
    }

    //查询社团成员
    public List<JSONObject> selectMemberByAssociationsId(int associationid) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject;
        List<BeanMember> memberList;
        SqlSession session = MybatiesSession.getSession();

        memberList =session.selectList("selectMemberByAssociationsId",associationid);

        if(memberList==null){
            jsonObject = JsonUtil.errorResult(401, "暂无社团成员");
        }
        else{
            for(int i=0;i<memberList.size();i++) {
                jsonObject = JsonUtil.MemberResult(200, memberList.get(i));
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
