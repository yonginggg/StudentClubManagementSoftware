package com.zks.Tool;

import com.zks.model.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {
    public static JSONObject errorResult(int port, String ErrorResult){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("ErrorResult",ErrorResult);
        return jsonObject;
    }

    public static JSONObject UserResult(int port, BeanUser user){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("userid",user.getUserid());
        jsonObject.put("username",user.getUsername());
        jsonObject.put("userpwd",user.getUserpwd());
        jsonObject.put("usersex",user.getUsersex());
        jsonObject.put("usermajor",user.getUsermajor());
        jsonObject.put("userclass",user.getUserclass());
        jsonObject.put("usertel",user.getUsertel());
        return jsonObject;
    }

    public static JSONObject ManagerResult(int port, BeanManager manager){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("managerid",manager.getManagerid());
        jsonObject.put("managerpwd",manager.getManagerpwd());
        jsonObject.put("managername",manager.getManagername());
        jsonObject.put("managerpalce",manager.getManagerpalce());
        jsonObject.put("managertel",manager.getManagertel());
        return jsonObject;
    }

    public static JSONObject ActivityResult(int port, BeanActivity activity){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("activityid",activity.getActivityid());
        jsonObject.put("activityrange",activity.getActivityrange());
        jsonObject.put("activityname",activity.getActivityname());
        jsonObject.put("activityintroduction",activity.getActivityintroduction());
        jsonObject.put("activitystarttime",activity.getActivitystarttime());
        jsonObject.put("activityendtime",activity.getActivityendtime());
        jsonObject.put("activityreleasetime",activity.getActivityreleasetime());
        jsonObject.put("activitydeadline",activity.getActivitydeadline());
        jsonObject.put("activitypalce",activity.getActivitypalce());
        jsonObject.put("associationsid",activity.getAssociationsid());
        jsonObject.put("departmentid",activity.getDepartmentid());
        jsonObject.put("activitiesapplicationtime",activity.getActivitiesapplicationtime());
        jsonObject.put("activitiesapplicationstate",activity.getActivitiesapplicationstate());
        return jsonObject;
    }

    public static JSONObject SubjectPostResult(int port, BeanSubjectPost subjectPost){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("subjectpostid",subjectPost.getSubjectpostid());
        jsonObject.put("subjectposttitle",subjectPost.getSubjectposttitle());
        jsonObject.put("subjectpostcontent",subjectPost.getSubjectpostcontent());
        jsonObject.put("subjectposttime",subjectPost.getSubjectposttime());
        jsonObject.put("collectnum",subjectPost.getCollectnum());
        jsonObject.put("looknum",subjectPost.getLooknum());
        jsonObject.put("userid",subjectPost.getUserid());
        return jsonObject;
    }
    public static JSONObject NoticeResult(int port, BeanNotice notice){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("noticeid",notice.getNoticeid());
        jsonObject.put("noticerange",notice.getNoticerange());
        jsonObject.put("noticename",notice.getNoticename());
        jsonObject.put("noticetcontent",notice.getNoticecontent());
        jsonObject.put("noticetime",notice.getNoticetime());
        jsonObject.put("associationsid",notice.getAssociationsid());
        jsonObject.put("departmentid",notice.getDepartmentid());
        jsonObject.put("noticestate",notice.getNoticestate());
        return jsonObject;
    }

}
