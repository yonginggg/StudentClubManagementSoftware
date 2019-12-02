package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanActivity;
import com.zks.model.BeanNotice;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//创建公告
public class NoticeService {
    public JSONObject createNotice(String noticerange, String noticename, String noticecontent, Date noticetime, int associationid, int departmentid) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (noticename==null) {
            jsonObject = JsonUtil.errorResult(401, "公告名字不得为空");
        } else if (noticecontent==null) {
            jsonObject = JsonUtil.errorResult(401, "公告内容不得为空");
        } else if (noticerange==null) {
            jsonObject = JsonUtil.errorResult(401, "请选择公告范围");
        } else {
            BeanNotice notice = new BeanNotice();
            notice.setNoticerange(noticerange);
            notice.setNoticename(noticename);
            notice.setNoticecontent(noticecontent);
            notice.setNoticetime(noticetime);
            notice.setAssociationsid(associationid);
            if (noticerange.equals("全校") || noticerange.equals("全社"))
                notice.setDepartmentid(0);
            else
                notice.setDepartmentid(departmentid);
            if (noticerange.equals("全校")){
                notice.setNoticestate("等待审核");
            }
            else
                notice.setNoticestate("审核通过");

            session.insert("insertNotice", notice);
            jsonObject = JsonUtil.NoticeResult(200, notice);
        }

        session.commit();
        return jsonObject;

    }
    //审核公告
    public JSONObject changeNoticeState(int noticeid, Boolean answer) throws Exception {
        BeanNotice notice = new BeanNotice();
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();

        notice = session.selectOne("selectNotice",noticeid);
        if(notice == null){
            jsonObject = JsonUtil.errorResult(401,"社团不存在");
        }
        else {
            if(answer == true){
                notice.setNoticestate("审核通过");
            } else{
                notice.setNoticestate("审核拒绝");
            }

            session.update("updateNotice", notice);
            jsonObject = JsonUtil.NoticeResult(200, notice);
        }

        session.commit();
        return jsonObject;
    }
    // 显示所有公告
    public List<JSONObject> loadNotice() throws Exception {
        List<BeanNotice> noticeList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        noticeList = session.selectList("selectAllNotice");
        System.out.println(noticeList.size());
        for(int i=0;i<noticeList.size();i++) {
            jsonObject = JsonUtil.NoticeResult(200, noticeList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }
    //显示全校公告
    public List<JSONObject> loadNoticeBySchool() throws Exception {
        List<BeanNotice> noticeList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        noticeList = session.selectList("selectNoticeBySchool");

        for(int i=0;i<noticeList.size();i++) {
            jsonObject = JsonUtil.NoticeResult(200, noticeList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }
    // 显示社团公告
    public List<JSONObject> loadNoticeByAssociation(int associationId) throws Exception {
        List<BeanNotice> noticeList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        noticeList = session.selectList("selectNoticeByAssociation",associationId);

        for(int i=0;i<noticeList.size();i++) {
            jsonObject = JsonUtil.NoticeResult(200, noticeList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }
    // 显示部门公告
    public List<JSONObject> loadNoticeByDepartment(int departmentId) throws Exception {
        List<BeanNotice> noticeList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        noticeList = session.selectList("selectNoticeByDepartment",departmentId);

        for(int i=0;i<noticeList.size();i++) {
            jsonObject = JsonUtil.NoticeResult(200, noticeList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }


}
