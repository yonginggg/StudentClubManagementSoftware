package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.dao.BeanUserMapper;
import com.zks.model.BeanUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    // 登陆
    public JSONObject login(String userId, String userPwd) throws Exception{
        BeanUser user = null;
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        user = session.selectOne("selectUser", userId);
//        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
//        String md5Pwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());
        if(user == null){
            jsonObject = JsonUtil.errorResult(401,"学号不存在");
        } else if(!user.getUserpwd().equals(userPwd)){
            jsonObject = JsonUtil.errorResult(401, "密码错误");
        } else {
            jsonObject = JsonUtil.UserResult(200, user);
        }

        session.commit();
        return jsonObject;
    }

    // 注册
    public JSONObject register(String userId,String userName, String oldPwd, String newPwd,String userSex,String userMajor,String userClass,String userTel) throws Exception {
        BeanUser user = null;
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        user = session.selectOne("selectUser", userId);
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        if (user != null) {
            jsonObject = JsonUtil.errorResult(401, "该学号已注册");
        } else if (oldPwd.equals("") || newPwd.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "密码不得为空");
        } else if (!oldPwd.equals(newPwd)) {
            jsonObject = JsonUtil.errorResult(401, "两次密码不同");
        } else if (userName.equals("") || userSex.equals("") || userMajor.equals("") || userClass.equals("") || userTel.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "请完善个人信息");
        } else if(!userTel.matches(regex)) {
            jsonObject = JsonUtil.errorResult(401, "手机号输入有误");
        }
        else {
            user = new BeanUser();
            user.setUserid(userId);
            user.setUsername(userName);
            //密码加密
            String md5Pwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
            user.setUserpwd(md5Pwd);
            user.setUsersex(userSex);
            user.setUsermajor(userMajor);
            user.setUserclass(userClass);
            user.setUsertel(userTel);

            session.insert("insertUser", user);
            jsonObject = JsonUtil.UserResult(200, user);
        }

        session.commit();
        return jsonObject;
    }

    // 修改密码
    public JSONObject changePwd(BeanUser user, String oldPwd, String newPwd, String newPwd2) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";

        if (oldPwd.equals("") || newPwd.equals("")|| newPwd2.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "密码不得为空");
        } else if (!oldPwd.equals(user.getUserpwd())) {
            jsonObject = JsonUtil.errorResult(401, "原密码错误");
        } else if (!newPwd.equals(newPwd2)) {
            jsonObject = JsonUtil.errorResult(401, "两次密码不同");
        } else if (newPwd.equals(oldPwd)) {
            jsonObject = JsonUtil.errorResult(401, "与原密码相同");
        } else {
            //密码加密
            String md5Pwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
            user.setUserpwd(md5Pwd);

            session.update("updateUser", user);
            jsonObject = JsonUtil.UserResult(200, user);
        }

        session.commit();
        return jsonObject;
    }

    // 编辑个人信息
    public JSONObject upadateUser(BeanUser user, String userName, String userSex, String userMajor, String userClass, String userTel) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        if (userName.equals("") || userSex.equals("") || userMajor.equals("") || userClass.equals("") || userTel.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "请完善个人信息");
        } else if(!userTel.matches(regex)) {
            jsonObject = JsonUtil.errorResult(401, "手机号输入有误");
        }
        else {
            user.setUsername(userName);
            user.setUsersex(userSex);
            user.setUsermajor(userMajor);
            user.setUserclass(userClass);
            user.setUsertel(userTel);

            session.update("updateUser", user);
            jsonObject = JsonUtil.UserResult(200, user);
        }

        session.commit();
        return jsonObject;
    }

    // 删除
    public JSONObject deleteUser(BeanUser user) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        session.delete("deleteUser",user.getUserid());
        session.commit();
        return jsonObject;
    }

    // 显示所有学生
    public List<JSONObject> loadUser() throws Exception {
        List<BeanUser> userList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        userList = session.selectList("selectAllUser");

        for(int i=0;i<userList.size();i++) {
            jsonObject = JsonUtil.UserResult(200, userList.get(i));
            list.add(jsonObject);
        }

        session.commit();
        return list;
    }

    // 学号查找学生
    public JSONObject searchUserById(String userId) throws Exception {
        BeanUser user = null;
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        user = session.selectOne("selectUser",userId);
        if(user == null){
            jsonObject = JsonUtil.errorResult(401,"学生不存在");
        } else {
           jsonObject = JsonUtil.UserResult(200,user);
        }

        session.commit();
        return jsonObject;
    }

    // 姓名查找学生
    public List<JSONObject> searchUserByName(String userName) throws Exception {
        List<BeanUser> userList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        userList = session.selectList("selectUserByName",userName);
        if(userList == null){
            jsonObject = JsonUtil.errorResult(401,"学生不存在");
        } else {
            for(int i=0;i<userList.size();i++) {
                jsonObject = JsonUtil.UserResult(200, userList.get(i));
                list.add(jsonObject);
            }
        }
        session.commit();
        return list;
    }

    public static void main(String[] args) throws Exception {
        UserService a = new UserService();

        JSONObject zs = a.register("317973","zss","12333","12333","女","yixue","1702","134331");

    }

}
