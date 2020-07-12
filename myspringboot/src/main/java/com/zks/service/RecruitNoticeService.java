package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanAssociations;
import com.zks.model.BeanRecruitNotice;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecruitNoticeService {
    //创建招新表/发布招新表
    public JSONObject createRecruitNotice(int userid,String recruitNoticeContent, Date recruitNoticeStartTime,
                                          Date recruitNoticeEndTime, Date recruitNoticeReleaseTime,
                                          int associationsId) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if("".equals(associationsId)){
            jsonObject = JsonUtil.errorResult(401, "请选择社团");
        }else if("".equals(recruitNoticeContent)){
            jsonObject = JsonUtil.errorResult(401, "请输入内容");
            return jsonObject;
        }else if(recruitNoticeStartTime == null){
            jsonObject = JsonUtil.errorResult(401, "开始时间不能为空");
        }else if(recruitNoticeEndTime == null){
            jsonObject = JsonUtil.errorResult(401, "结束时间不能为空");
        }else if(recruitNoticeReleaseTime == null){
            jsonObject = JsonUtil.errorResult(401, "发布时间不能为空");
        }else if(recruitNoticeStartTime.after(recruitNoticeEndTime)){
            jsonObject = JsonUtil.errorResult(401, "结束时间不得早于或等于开始时间");
        } else if(now.after(recruitNoticeEndTime)){
            jsonObject = JsonUtil.errorResult(401, "结束时间不得早于或等于当前时间");
        } else if(recruitNoticeReleaseTime.after(recruitNoticeEndTime)) {
            jsonObject = JsonUtil.errorResult(401, "发布时间不得晚于结束时间");
        }else {
            BeanRecruitNotice recruitNotice = new BeanRecruitNotice();
            recruitNotice.setRecruitnoticecontent(recruitNoticeContent);
            recruitNotice.setRecruitnoticestarttime(recruitNoticeStartTime);
            recruitNotice.setRecruitnoticeendtime(recruitNoticeEndTime);
            recruitNotice.setRecruitnoticereleasetime(recruitNoticeReleaseTime);
            recruitNotice.setAssociationsid(associationsId);

            session.insert("insertRecruitNotice", recruitNotice);
            jsonObject = JsonUtil.RecruitNoticeResult(200, recruitNotice);
        }

        session.commit();
        return jsonObject;
    }

//    显示所有招新表
    public List<JSONObject> loadAllRecruitNotice() throws Exception {
        List<BeanRecruitNotice> recruitNoticeList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();
        Date now = new Date();

        SqlSession session = MybatiesSession.getSession();
        recruitNoticeList = session.selectList("selectAllRecruitNotice");

        for(int i = 0; i < recruitNoticeList.size(); i++){
            if(recruitNoticeList.get(i).getRecruitnoticeendtime().after(now)) {
                jsonObject = JsonUtil.RecruitNoticeResult(200, recruitNoticeList.get(i));
                list.add(jsonObject);
            }
        }
        session.commit();
        return list;
    }

//    //显示所有招新表
//    public List<JSONObject> loadAllRecruitNotice() throws Exception {
//        List<BeanRecruitNotice> recruitNoticeList = null;
//        JSONObject jsonObject = null;
//        List<JSONObject> list = new ArrayList<JSONObject>();
//
//        SqlSession session = MybatiesSession.getSession();
//        recruitNoticeList = session.selectList("selectAllRecruitNotice");
//
//        for(int i = 0; i < recruitNoticeList.size(); i++){
//            Date now = new Date();
//            if(now.after(recruitNoticeList.get(i).getRecruitnoticeendtime())){continue;}
//            else {
//                BeanAssociations associationName = session.selectOne("selectAssociationName_one",recruitNoticeList.get(i).getAssociationsid());
//                jsonObject = JsonUtil.TwoRecruitNoticeResult(200, recruitNoticeList.get(i),associationName.getAssociationsname());
//                list.add(jsonObject);
//            }
//        }
//        session.commit();
//        return list;
//    }

    //删除招新表
    public List<JSONObject> deleteRecruitNotice(int recruitNoticeId) throws Exception {
        BeanRecruitNotice recruitNotice = new BeanRecruitNotice();
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();
        SqlSession session = MybatiesSession.getSession();
        session.delete("deleteRecruitNotice",recruitNoticeId);

        List<BeanRecruitNotice> recruitNoticeList = null;
        recruitNoticeList = session.selectList("selectAllRecruitNotice");
        for(int i = 0; i < recruitNoticeList.size(); i++){
            jsonObject = JsonUtil.RecruitNoticeResult(200, recruitNoticeList.get(i));
            list.add(jsonObject);
        }
        session.commit();
        return list;
    }


    public static void main(String[] args) throws Exception {
        RecruitNoticeService a = new RecruitNoticeService();
        List<JSONObject> test2 = a.loadAllRecruitNotice();
        System.out.println(test2);
//        a.deleteRecruitNotice(2);

    }
}
