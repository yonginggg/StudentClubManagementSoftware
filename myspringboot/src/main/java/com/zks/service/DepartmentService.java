package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.model.BeanDepartment;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    //查找用户的部门
    public List<JSONObject> selectDepartmentByUserId(String userid) throws Exception{
        List<JSONObject> list = new ArrayList<JSONObject>();
        JSONObject jsonObject = null;
        List<BeanDepartment> deId = null;
        SqlSession session = MybatiesSession.getSession();
        deId = session.selectList("selectDepartmentByUserId",userid);
        if(deId==null){
            jsonObject = JsonUtil.errorResult(401, "该成员未加入部门");
        }
        else{
        for(int i=0;i<deId.size();i++) {
            jsonObject = JsonUtil.DepartmentResult(200, deId.get(i));
            list.add(jsonObject);
        }}
        session.commit();
        return list;
    }


    //创建部门
    public JSONObject createDepartment(String departmentname, String departmentleader,int associationid) throws Exception {
        JSONObject jsonObject = null;
        SqlSession session = MybatiesSession.getSession();
        if (departmentname==null) {
            jsonObject = JsonUtil.errorResult(401, "部门名字不得为空");
        } else if (departmentleader==null) {
            jsonObject = JsonUtil.errorResult(401, "部门领导者不得为空");
        }
        else {
            BeanDepartment department = new BeanDepartment();
            department.setDepartmentname(departmentname);
            department.setDepartmentleader(departmentleader);
            department.setAssociationsid(associationid);

            session.insert("insertDepartment", department);
            jsonObject = JsonUtil.DepartmentResult(200, department);
        }

        session.commit();
        return jsonObject;
    }

    // 解散部门
    public JSONObject deleteDepartment(int departmentid) throws Exception {
        JSONObject jsonObject = null;
        SqlSession session = MybatiesSession.getSession();
        session.update("updateMember", departmentid);
        session.delete("deleteDepartment", departmentid );
        session.commit();
        return jsonObject;
    }

    //职务改变
    public JSONObject updateDepartmentLeader(int departmentid,String departmentleader) throws Exception {
        JSONObject jsonObject = null;
        BeanDepartment department = new BeanDepartment();
        SqlSession session = MybatiesSession.getSession();
        department = session.selectOne("selectde",departmentid);
        if(department == null){
            jsonObject = JsonUtil.errorResult(401,"部门不存在");
        }
        else{
            department.setDepartmentleader(departmentleader);
            session.update("updateDepartmentLeader", department);
            jsonObject = JsonUtil.DepartmentResult(200, department);}
        session.commit();
        return jsonObject;

    }
    public JSONObject updateDepartmentName(int departmentid,String departmentname) throws Exception {
        JSONObject jsonObject = null;
        BeanDepartment department = new BeanDepartment();
        SqlSession session = MybatiesSession.getSession();
        department = session.selectOne("selectde",departmentid);
        if(department == null){
            jsonObject = JsonUtil.errorResult(401,"部门不存在");
        }
        else{
            department.setDepartmentname(departmentname);
            session.update("updateDepartmentName", department);
            jsonObject = JsonUtil.DepartmentResult(200, department);}
        session.commit();
        return jsonObject;

    }

}
