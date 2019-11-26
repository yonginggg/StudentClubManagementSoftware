package com.zks.service;

import com.zks.model.BeanActivity;
import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import org.apache.ibatis.session.SqlSession;
import com.zks.Tool.MybatiesSession;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityService {
    // 创建活动
    public JSONObject createActivity(String range, String name, String introduction, Date startTime, Date endTime, Date releaseTime, Date deadLine, int palaceid, int associationid, int departmentid) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if(startTime.after(endTime)){
            jsonObject = JsonUtil.errorResult(401, "结束时间不得早于开始时间");
        } else if(startTime.after(now)){
            jsonObject = JsonUtil.errorResult(401, "开始时间不得早于当前时间");
        } else if(deadLine.after(now)){
            jsonObject = JsonUtil.errorResult(401, "报名截止时间不得早于当前时间");
        } else if (!placeAvailability(palaceid,startTime,endTime)){
            jsonObject = JsonUtil.errorResult(401, "场地已被占用");
        }
        else {
            BeanActivity activity = new BeanActivity();
            activity.setActivityrange(range);
            activity.setActivityname(name);
            activity.setActivityintroduction(introduction);
            activity.setActivitystarttime(startTime);
            activity.setActivityendtime(endTime);
            activity.setActivityreleasetime(releaseTime);
            activity.setActivitydeadline(deadLine);
            activity.setActivitypalce(palaceid);
            activity.setAssociationsid(associationid);
            if(range.equals("校内"))
                activity.setDepartmentid(0);
            else
                activity.setDepartmentid(departmentid);
            activity.setActivitiesapplicationtime(now);
            activity.setActivitiesapplicationstate("等待审核");

            session.insert("insertActivity",activity);
            jsonObject = JsonUtil.ActivityResult(200, activity);
        }

        session.commit();
        return jsonObject;
    }

    // 审核活动
    public JSONObject changeState(int activityid, Boolean answer) throws Exception {
        BeanActivity activity = new BeanActivity();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();

        activity = session.selectOne("selectActivity",activityid);
        if(activity == null){
            jsonObject = JsonUtil.errorResult(401,"社团不存在");
        }
        else {
            if(answer == true){
                activity.setActivitiesapplicationstate("审核通过");
            } else{
                activity.setActivitiesapplicationstate("审核拒绝");
            }

            session.update("updateActivity", activity);
            jsonObject = JsonUtil.ActivityResult(200, activity);
        }

        session.commit();
        return jsonObject;
    }

    // 显示所有活动
    public List<JSONObject> loadActivity() throws Exception {
        List<BeanActivity> activityList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        activityList = session.selectList("selectAllActivity");

        for(int i=0;i<activityList.size();i++) {
            jsonObject = JsonUtil.ActivityResult(200, activityList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }

    // 显示社团活动
    public List<JSONObject> loadActivityByAssociation(int associationId) throws Exception {
        List<BeanActivity> activityList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        activityList = session.selectList("selectActivityByAssociation",associationId);

        for(int i=0;i<activityList.size();i++) {
            jsonObject = JsonUtil.ActivityResult(200, activityList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }

    // 显示部门活动
    public List<JSONObject> loadActivityByDepartment(int departmentId) throws Exception {
        List<BeanActivity> activityList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        activityList = session.selectList("selectActivityByDepartment",departmentId);

        for(int i=0;i<activityList.size();i++) {
            jsonObject = JsonUtil.ActivityResult(200, activityList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }

    // 判断场地是否可用
    public Boolean placeAvailability(int placeId, Date startTime, Date endTime) throws Exception {
        List<BeanActivity> activityList = null;
        BeanActivity activity = null;
        Date now = new Date();

        SqlSession session = MybatiesSession.getSession();
        activityList = session.selectList("selectActivityByPlace",placeId);

        int sum = 0;
        for(int i=0;i<activityList.size();i++) {
            activity = activityList.get(i);
            if (activity.getActivitystarttime().after(endTime) || activity.getActivityendtime().before(startTime)) {
                sum = sum + 1;
            }
        }
        if(sum == activityList.size())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
