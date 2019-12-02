package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanAssociations;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class AssociationService {
    // 创建社团
    public JSONObject createAssociation(String name, String type, String introduction, String leader) throws Exception {
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
    // 创建社团
    public JSONObject de(String name, String type, String introduction, String leader) throws Exception {
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

    public static void main(String[] args) throws Exception {
        AssociationService associationService = new AssociationService();
        associationService.createAssociation("wfhjj","fghjj","ghjhy","31701055");
    }
}
