package com.zks.Tool;

import com.zks.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtil {

    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //报错提示
    public static JSONObject errorResult(int port, String ErrorResult){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("ErrorResult",ErrorResult);
        return jsonObject;
    }

    //用户
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

    //管理员
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

    //活动
    public static JSONObject ActivityResult(int port, BeanActivity activity){
        SqlSession session = MybatiesSession.getSession();
        BeanAssociations a = session.selectOne("selectAssociations",activity.getAssociationsid());
        BeanDepartment d = session.selectOne("selectDepartment",activity.getDepartmentid());
        String place = " ";
        if(activity.getActivitypalce()==1)
            place = "理四1楼大教室";
        else if(activity.getActivitypalce()==2)
            place = "南校操场";
        else if(activity.getActivitypalce()==3)
            place = "北校操场";
        else if(activity.getActivitypalce()==4)
            place = "风雨操场";
        else if(activity.getActivitypalce()==5)
            place = "科技楼";

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
        jsonObject.put("activitypalce",place);
        jsonObject.put("associationsid",activity.getAssociationsid());
        jsonObject.put("associationsname",a.getAssociationsname());
        jsonObject.put("departmentid",activity.getDepartmentid());
        jsonObject.put("departmentname",d.getDepartmentname());
        jsonObject.put("activitiesapplicationtime",df.format(activity.getActivitiesapplicationtime()));
        jsonObject.put("activitiesapplicationstate",activity.getActivitiesapplicationstate());
        return jsonObject;
    }

    //活动报名
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

    //公告
    public static JSONObject NoticeResult(int port, BeanNotice notice){
        SqlSession session = MybatiesSession.getSession();
        BeanAssociations a = session.selectOne("selectAssociations",notice.getAssociationsid());
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("noticeid",notice.getNoticeid());
        jsonObject.put("noticerange",notice.getNoticerange());
        jsonObject.put("noticename",notice.getNoticename());
        jsonObject.put("noticetcontent",notice.getNoticecontent());
        jsonObject.put("noticetime",df.format(notice.getNoticetime()));
        jsonObject.put("associationsid",notice.getAssociationsid());
        jsonObject.put("associationsname",a.getAssociationsname());
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
        jsonObject.put("associationsTime",df.format(associations.getAssociationstime()));
        jsonObject.put("associationsType",associations.getAssociationstype());
        jsonObject.put("associationsIntroduction",associations.getAssociationsintroduction());
        jsonObject.put("associationsNumber",associations.getAssociationsnumber());
        jsonObject.put("associationsLeader",associations.getAssociationsleader());
        jsonObject.put("associationsApplicationTime",df.format(associations.getAssociationsapplicationtime()));
        jsonObject.put("associationsApplicationState",associations.getAssociationsapplicationstate());
        return jsonObject;
    }

    //招新申请
    public static JSONObject RecruitSignResult(int port, BeanRecruitSign recruitSign){
        SqlSession session = MybatiesSession.getSession();
        BeanUser u = session.selectOne("selectUser",recruitSign.getUserid());
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("recruitSignId",recruitSign.getRecruitsignid());
        jsonObject.put("recruitSignTime",df.format(recruitSign.getRecruitsigntime()));
        jsonObject.put("userId",recruitSign.getUserid());
        jsonObject.put("username",u.getUsername());
        jsonObject.put("associationsId",recruitSign.getAssociationsid());
        jsonObject.put("recruitSignContent ",recruitSign.getRecruitSignContent());
        jsonObject.put("recruitSignApplicationState",recruitSign.getRecruitSignApplicationState());
        return jsonObject;
    }

    public static JSONObject SubjectPostResult(int port, BeanSubjectPost subjectPost){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("subjectpostid",subjectPost.getSubjectpostid());
        jsonObject.put("subjectposttitle",subjectPost.getSubjectposttitle());
        jsonObject.put("subjectpostcontent",subjectPost.getSubjectpostcontent());
        jsonObject.put("subjectposttime",df.format(subjectPost.getSubjectposttime()));
        jsonObject.put("collectnum",subjectPost.getCollectnum());
        jsonObject.put("looknum",subjectPost.getLooknum());
        jsonObject.put("userid",subjectPost.getUserid());
        return jsonObject;
    }

//    public static JSONObject MemberResult(int port, BeanMember member){
//        JSONObject jsonObject = new JSONObject(true);
//        jsonObject.put("port",port);
//        jsonObject.put("memberId",member.getMemberid());
//        jsonObject.put("memberPost",member.getMemberpost());
//        jsonObject.put("memberTime",df.format(member.getMembertime()));
//        jsonObject.put("memberIntroduction",member.getMemberintroduction());
//        jsonObject.put("userId ",member.getUserid());
//        jsonObject.put("associationsId",member.getAssociationsid());
//        return jsonObject;
//    }

    // 社团成员
    public static JSONObject MemberResult(int port, BeanMember member){
        JSONObject jsonObject = new JSONObject(true);
        SqlSession session = MybatiesSession.getSession();
        BeanUser u = session.selectOne("selectUser",member.getUserid());
        jsonObject.put("port",port);
        jsonObject.put("memberid",member.getMemberid());
        jsonObject.put("memberpost",member.getMemberpost());
        jsonObject.put("membertime",member.getMembertime());
        jsonObject.put("memberintroduction",member.getMemberintroduction());
        jsonObject.put("userid",member.getUserid());
        jsonObject.put("associationsid",member.getAssociationsid());
        jsonObject.put("departmentid",member.getDepartmentid());
        jsonObject.put("username",u.getUsername());
        jsonObject.put("usersex",u.getUsersex());
        jsonObject.put("usermajor",u.getUsermajor());
        jsonObject.put("userclass",u.getUserclass());
        jsonObject.put("usertel",u.getUsertel());

        return jsonObject;
    }

    //招新表
    public static JSONObject RecruitNoticeResult(int port, BeanRecruitNotice recruitNotice){
        SqlSession session = MybatiesSession.getSession();
        BeanAssociations a = session.selectOne("selectAssociations",recruitNotice.getAssociationsid());
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("recruitNoticeId",recruitNotice.getRecruitnoticeid());
        jsonObject.put("recruitNoticeContent",recruitNotice.getRecruitnoticecontent());
        jsonObject.put("recruitNoticeStartTime",df.format(recruitNotice.getRecruitnoticestarttime()));
        jsonObject.put("recruitNoticeEndTime",df.format(recruitNotice.getRecruitnoticeendtime()));
        jsonObject.put("recruitNoticeReleaseTime",df.format(recruitNotice.getRecruitnoticereleasetime()));
        jsonObject.put("associationsId",recruitNotice.getAssociationsid());
        jsonObject.put("associationsname",a.getAssociationsname());
        return jsonObject;
    }

    public static JSONObject TwoRecruitNoticeResult(int port, BeanRecruitNotice recruitNotice, String associationsName){
        JSONObject jsonObject = new JSONObject(true);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("port",port);
        jsonObject.put("recruitNoticeId",recruitNotice.getRecruitnoticeid());
        jsonObject.put("recruitNoticeContent",recruitNotice.getRecruitnoticecontent());
        jsonObject.put("recruitNoticeStartTime",df.format(recruitNotice.getRecruitnoticestarttime()));
        jsonObject.put("recruitNoticeEndTime",df.format(recruitNotice.getRecruitnoticeendtime()));
        jsonObject.put("recruitNoticeReleaseTime",df.format(recruitNotice.getRecruitnoticereleasetime()));
        jsonObject.put("associationsId",recruitNotice.getAssociationsid());
        jsonObject.put("associationsName",associationsName);
        return jsonObject;
    }
    public static JSONObject DepartmentResult(int port, BeanDepartment department){
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("port",port);
        jsonObject.put("departmentid",department.getDepartmentid());
        jsonObject.put("departmentname",department.getDepartmentname());
        jsonObject.put("departmentleader",department.getDepartmentleader());
        jsonObject.put("associationsid",department.getAssociationsid());
        return jsonObject;
    }
}
