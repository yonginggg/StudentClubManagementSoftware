package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanAssociations;
import com.zks.model.BeanMember;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssociationService {
    // 创建社团
    public JSONObject createAssociation(String name, String type, String introduction,  String leader) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();

        BeanAssociations associations = new BeanAssociations();
        associations.setAssociationsname(name);
        associations.setAssociationstype(type);
        associations.setAssociationsintroduction(introduction);
        associations.setAssociationsnumber(1);
        associations.setAssociationsleader(leader);
        associations.setAssociationsapplicationtime(now);
        associations.setAssociationstime(now);
        associations.setAssociationsapplicationstate("等待审核");


        session.insert("insertAssociation",associations);
        jsonObject = JsonUtil.AssociationResult(200, associations);

        session.commit();
        return jsonObject;
    }
    // allassociationbyuserid
    public List<JSONObject> selectAssociationByUserId(String userid) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject = null;
        BeanAssociations associations = null;

        SqlSession session = MybatiesSession.getSession();
        List<String> assId = session.selectList("selectAssociationIdByUserId",userid);


        for (int i = 0; i < assId.size(); i++){
            associations = (session.selectOne("selectAssociationById",assId.get(i)));
            jsonObject = JsonUtil.AssociationResult(200,associations);
            list.add(jsonObject);
        }
        session.commit();
        return list;
    }
    // allassociations
    public List<JSONObject> selectAllAssociations( ) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        List<BeanAssociations> associations = session.selectList("selectAllAssociations");

        for (int i = 0; i < associations.size(); i++){
            jsonObject = JsonUtil.AssociationResult(200,associations.get(i));
            list.add(jsonObject);
        }
        session.commit();
        return list;
    }
    // 按状态查找社团
    public List<JSONObject> selectAssociationsByState(String state) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        List<BeanAssociations> associations = session.selectList("selectAssociationsByState",state);

        for (int i = 0; i < associations.size(); i++){
            if (associations.get(i).getAssociationsid() > 0) {
                jsonObject = JsonUtil.AssociationResult(200,associations.get(i));
                list.add(jsonObject);
            }

        }
        session.commit();
        return list;
    }
    // 按id查找社团
    //没有创建controller
    public JSONObject selectAssociationsById(int id) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanAssociations associations = session.selectOne("selectAssociationById",id);

        jsonObject = JsonUtil.AssociationResult(200,associations);
        session.commit();
        return jsonObject;
    }

    //更改社团状态（比如说：已删除，正在审核，审核通过，审核失败）
    //审核通过之后，更改社团创立时间，将社长加入member
    public void modifyMemberInsertLeader(String userid, int assid){
        SqlSession session = MybatiesSession.getSession();
        BeanMember member = new BeanMember();
        member.setUserid(userid);
        member.setAssociationsid(assid);
        member.setMemberintroduction("Leader");
        member.setMembertime(new Date());
        member.setMemberpost("社长");
        member.setDepartmentid(999999);
        session.insert("insertMember",member);
        session.commit();
    }

    public JSONObject modifyAssociationsState(int id, String state) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanAssociations associations = session.selectOne("selectAssociationById",id);
        associations.setAssociationsapplicationstate(state);
        if(state.equals("审核通过")) {
            associations.setAssociationstime(new Date());
            this.modifyMemberInsertLeader(associations.getAssociationsleader(),id);
        }
        session.update("updateByAssociationsId",associations);

        jsonObject = JsonUtil.AssociationResult(200,associations);

        session.commit();
        return jsonObject;
    }

    //更改社团简介
    public JSONObject modifyAssociationsIntroductById(int id, String intro) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanAssociations associations = session.selectOne("selectAssociationById",id);
        associations.setAssociationsintroduction(intro);
        session.update("updateByAssociationsId",associations);

        jsonObject = JsonUtil.AssociationResult(200,associations);

        session.commit();
        return jsonObject;
    }
    public static void main(String[] args) throws Exception {

    }
}
