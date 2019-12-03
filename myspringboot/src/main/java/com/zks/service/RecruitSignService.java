package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanAssociations;
import com.zks.model.BeanRecruitSign;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecruitSignService {
    //创建招新申请表(招新报名)
    public JSONObject insertrecruit(String userid, int associationsId,String content){
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        BeanAssociations association = new BeanAssociations();
        BeanRecruitSign sign = new BeanRecruitSign();
        BeanRecruitSign selectSign = new BeanRecruitSign();

        association = session.selectOne("selectAssociation",associationsId);
    //    sign = session.selectOne("selectRecruitSignByUAndAId",userid,associationsId);
        if(association ==null){
            jsonObject = JsonUtil.errorResult(401,"社团不存在");
        }else if(sign != null){
           // 用户只能在每个社团只能提供一次申请表
          //  需要查询是否存在，若存在则报错
            jsonObject = JsonUtil.errorResult(401,"已提交招新表");
        }else if(content == null|| content == ""){
            jsonObject = JsonUtil.errorResult(401,"个人介绍不能为空");
        }
        else{
            BeanRecruitSign recruitSign = new BeanRecruitSign();
            recruitSign.setRecruitsigntime(now);
            recruitSign.setUserid(userid);
            recruitSign.setAssociationsid(associationsId);
            recruitSign.setRecruitSignContent(content);
            recruitSign.setRecruitSignApplicationState("等待审核");

            session.insert("insertRecruit",recruitSign);
            jsonObject = JsonUtil.RecruitSignResult(200, recruitSign);
        }
        session.commit();
        return jsonObject;
    }

    //审核招新申请表
    public JSONObject changeState(int userid, Boolean answer) throws Exception {
        BeanRecruitSign recruitSign = new BeanRecruitSign();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();

        recruitSign = session.selectOne("selectRecruitSignByUserid",userid);
        if(recruitSign == null){
            jsonObject = JsonUtil.errorResult(401,"招新申请表不存在");
        }
        else {
            if(answer == true){
                recruitSign.setRecruitSignApplicationState("审核通过");
            } else{
                recruitSign.setRecruitSignApplicationState("审核拒绝");
            }

            session.update("updateRecruitSign", recruitSign);
            jsonObject = JsonUtil.RecruitSignResult(200, recruitSign);
        }

        session.commit();
        return jsonObject;
    }

    //显示所有招新申请表
    public List<JSONObject> loadAllRecruitSign() throws Exception {
        List<BeanRecruitSign> recruitSignList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        recruitSignList = session.selectList("selectAllRecruitSign");

        for(int i = 0; i < recruitSignList.size(); i++){
            jsonObject = JsonUtil.RecruitSignResult(200, recruitSignList.get(i));
            list.add(jsonObject);
        }
        session.commit();
        return list;
    }

    //显示该用户所属社团的所有申请表(社长查询
    public List<JSONObject> loadAllRecruitSignByAssociation(String userid) throws Exception {
        List<BeanRecruitSign> recruitSignList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        //显示该用户所属社团的所有申请表
        //如果用户所处两个社团，只需要显示其职位下社团所有申请表
        //sql语句 还需要区分社长下掌管社团和普通社团
        //select* from recruitsign where associationsId in(select associationsId from recruitsign where userid = 2)
        //在社团表里根据uerid/leader查询社团id
        recruitSignList = session.selectList("selectRecruitSignByUserAndAssc",userid);
        if(recruitSignList == null){
            jsonObject = JsonUtil.errorResult(401,"无招新申请表");
        }
        else {
            for (int i = 0; i < recruitSignList.size(); i++) {
                jsonObject = JsonUtil.RecruitSignResult(200, recruitSignList.get(i));
                list.add(jsonObject);
            }
        }
        session.commit();
        return list;
    }


    public static void main(String[] args) throws Exception {
        RecruitSignService a = new RecruitSignService();
  //      JSONObject zs = a.insertrecruit("2",3,"ugyuih");
      List<JSONObject> test1 = a.loadAllRecruitSignByAssociation("2");
     //   List<JSONObject> test2 = a.loadAllRecruitSign();
        System.out.println(test1);
      //  System.out.println(test2);
//        JSONObject test3 = a.changeState(2,true);
//        System.out.println(test3);

    }
}
