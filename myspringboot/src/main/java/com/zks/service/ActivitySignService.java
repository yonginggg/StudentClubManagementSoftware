package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanActivity;
import com.zks.model.BeanActivitySign;
import com.zks.model.BeanAssociations;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitySignService {
    // 活动报名
    public JSONObject createActivitySign(String userId, Integer activityId) throws Exception {
        BeanActivity activity = new BeanActivity();
        List<BeanActivitySign> activitySignList = null;
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        activity = session.selectOne("selectActivity",activityId);
        activitySignList = session.selectList("selectActivitySignByUserId",userId);
        int sum = 0;
        for(int i=0;i<activitySignList.size();i++){
            if(activitySignList.get(i).getActivityid() == activityId){
                sum++;
            }
        }

        if(activity == null){
            jsonObject = JsonUtil.errorResult(401,"活动不存在");
        } else if(now.after(activity.getActivitydeadline())){
            jsonObject = JsonUtil.errorResult(401,"活动报名已截止");
        } else if(sum != 0){
            jsonObject = JsonUtil.errorResult(401,"已报名过此活动");
        }

        else{
            BeanActivitySign activitySign = new BeanActivitySign();
            activitySign.setStudentsigntime(now);
            activitySign.setActivitysignstate("等待审核");
            activitySign.setUserid(userId);
            activitySign.setActivityid(activityId);

            session.insert("insertActivitySign",activitySign);
            jsonObject = JsonUtil.ActivitySignResult(200, activitySign);
        }

        session.commit();
        return jsonObject;
    }

    // 社长审核报名
    public JSONObject changeSignState(int activitySignId, Boolean answer) throws Exception {
        BeanActivitySign activitySign = new BeanActivitySign();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();

        activitySign = session.selectOne("selectActivitySign",activitySignId);
        if(activitySign == null){
            jsonObject = JsonUtil.errorResult(401,"活动报名不存在");
        }
        else {
            if(answer == true){
                activitySign.setActivitysignstate("审核通过");
            } else{
                activitySign.setActivitysignstate("审核拒绝");
            }

            session.update("updateActivitySign", activitySign);
            jsonObject = JsonUtil.ActivitySignResult(200, activitySign);
        }

        session.commit();
        return jsonObject;
    }


    // 显示等待审核的报名（审核通过、审核拒绝）
    public List<JSONObject> loadActivitySignByState(String state, int activityId) throws Exception {
        List<BeanActivitySign> activitySignList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        activitySignList = session.selectList("selectActivitySignByState",state);

        for(int i=0;i<activitySignList.size();i++) {
            if(activitySignList.get(i).getActivityid() == activityId) {
                jsonObject = JsonUtil.ActivitySignResult(200, activitySignList.get(i));
                list.add(jsonObject);
            }
        }

        session.commit();
        return list;
    }

    public static void main(String[] args) throws Exception {
        ActivitySignService a = new ActivitySignService();
        Date date = new Date();
//        JSONObject zs = a.createActivitySign("3",2);
        List<JSONObject> zs = a.loadActivitySignByState("等待审核",2);
//        JSONObject zs = a.register("311","22","1233","1233","nan","yixue","1702","13429590334");
        System.out.println(zs);
    }

}
