package com.zks.Tool;

import com.zks.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtil {

    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        SqlSession session = MybatiesSession.getSession();
        BeanAssociations a = session.selectOne("selectAssociations",activity.getAssociationsid());
        BeanDepartment d = session.selectOne("selectDepartment",activity.getDepartmentid());

        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("activityid",activity.getActivityid());
        jsonObject.put("activityrange",activity.getActivityrange());
        jsonObject.put("activityname",activity.getActivityname());
        jsonObject.put("activityintroduction",activity.getActivityintroduction());
        jsonObject.put("activitystarttime",df.format(activity.getActivitystarttime()));
        jsonObject.put("activityendtime",df.format(activity.getActivityendtime()));
        jsonObject.put("activityreleasetime",df.format(activity.getActivityreleasetime()));
        jsonObject.put("activitydeadline",df.format(activity.getActivitydeadline()));
        jsonObject.put("activitypalce",activity.getActivitypalce());
        jsonObject.put("associationsid",activity.getAssociationsid());
        jsonObject.put("associationsname",a.getAssociationsname());
        jsonObject.put("departmentid",activity.getDepartmentid());
        jsonObject.put("departmentname",d.getDepartmentname());
        jsonObject.put("activitiesapplicationtime",df.format(activity.getActivitiesapplicationtime()));
        jsonObject.put("activitiesapplicationstate",activity.getActivitiesapplicationstate());
        return jsonObject;
    }

    public static JSONObject ActivitySignResult(int port, BeanActivitySign activitySign){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("activitysignid",activitySign.getActivitysignid());
        jsonObject.put("studentsigntime",df.format(activitySign.getStudentsigntime()));
        jsonObject.put("activitysignstate",activitySign.getActivitysignstate());
        jsonObject.put("userid",activitySign.getUserid());
        jsonObject.put("activityid",activitySign.getActivityid());
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
    //社团
    public static JSONObject AssociationResult(int port, BeanAssociations associations){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("associationsId",associations.getAssociationsid());
        jsonObject.put("associationsName",associations.getAssociationsname());
        jsonObject.put("associationsTime",associations.getAssociationstime());
        jsonObject.put("associationsType",associations.getAssociationstype());
        jsonObject.put("associationsIntroduction",associations.getAssociationsintroduction());
        jsonObject.put("associationsNumber",associations.getAssociationsnumber());
        jsonObject.put("associationsLeader",associations.getAssociationsleader());
        jsonObject.put("associationsApplicationTime",associations.getAssociationsapplicationtime());
        jsonObject.put("associationsApplicationState",associations.getAssociationsapplicationstate());
        return jsonObject;
    }

    //招新申请
    public static JSONObject RecruitSignResult(int port, BeanRecruitSign recruitSign){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("recruitSignId",recruitSign.getRecruitsignid());
        jsonObject.put("recruitSignTime",recruitSign.getRecruitsigntime());
        jsonObject.put("userId",recruitSign.getUserid());
        jsonObject.put("associationsId",recruitSign.getAssociationsid());
        jsonObject.put("recruitSignContent ",recruitSign.getRecruitSignContent());
        jsonObject.put("recruitSignApplicationState",recruitSign.getRecruitSignApplicationState());
        return jsonObject;
    }
}
