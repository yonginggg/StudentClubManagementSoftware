package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanSubjectPost;
import com.zks.model.BeanUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.List;

public class SubjectPostService {
    // 发布主题贴
    public JSONObject createSubjectPost(String title, String content, String userId) throws Exception{
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        BeanSubjectPost subjectPost = new BeanSubjectPost();
        subjectPost.setSubjectposttitle(title);
        subjectPost.setSubjectpostcontent(content);
        subjectPost.setSubjectposttime(now);
        subjectPost.setCollectnum(0);
        subjectPost.setLooknum(0);
        subjectPost.setUserid(userId);

        session.insert("insertSubjectPost",subjectPost);
        jsonObject = JsonUtil.SubjectPostResult(200, subjectPost);

        session.commit();
        return jsonObject;
    }

    // 删除主题贴
    public JSONObject deleteSubjectPost(int subjectPostId) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        session.delete("deleteSubjectPost",subjectPostId);
        session.commit();
        return jsonObject;
    }

    //我发布的
    public List<JSONObject> searchMySubjectPost(String userid) throws Exception {
        List<BeanSubjectPost> subjectPostList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        subjectPostList = session.selectList("selectSubjectPostByUserId",userid);

        for(int i=0;i<subjectPostList.size();i++) {
            jsonObject = JsonUtil.SubjectPostResult(200, subjectPostList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }
}