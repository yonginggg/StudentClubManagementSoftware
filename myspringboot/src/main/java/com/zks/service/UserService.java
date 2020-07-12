package com.zks.service;

import com.alibaba.fastjson.JSONObject;
import com.zks.Tool.JsonUtil;
import com.zks.Tool.MybatiesSession;
import com.zks.dao.BeanUserMapper;
import com.zks.model.BeanManager;
import com.zks.model.BeanUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.DigestUtils;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    // 登陆
    public JSONObject login(String type, String userId, String userPwd) throws Exception{
        BeanUser user = null;
        BeanManager manager = null;
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        if("学生".equals(type))
            user = session.selectOne("selectUser", userId);
        else if ("管理员".equals(type))
            manager = session.selectOne("selectManager", userId);

        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        String md5Pwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());

        if("学生".equals(type)) {
            if (user == null) {
                jsonObject = JsonUtil.errorResult(401, "账号不存在");
            } else if (!user.getUserpwd().equals(md5Pwd)) {
                jsonObject = JsonUtil.errorResult(401, "密码错误");
            } else {
                jsonObject = JsonUtil.UserResult(200, user);
            }
        }
        else if ("管理员".equals(type)){

            if (manager == null) {
                jsonObject = JsonUtil.errorResult(401, "账号不存在");
            } else if (!manager.getManagerpwd().equals(md5Pwd)) {
                jsonObject = JsonUtil.errorResult(401, "密码错误");
            } else {
                jsonObject = JsonUtil.ManagerResult(200, manager);
            }
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

    // 学生修改密码
    public JSONObject changePwd(String  userId, String oldPwd, String newPwd, String newPwd2) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanUser user = session.selectOne("selectUser", userId);
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";

        if (oldPwd.equals("") || newPwd.equals("")|| newPwd2.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "密码不得为空");
        } else if (!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(user.getUserpwd())) {
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

    //管理员重置学生密码
    public JSONObject resetPwd(String  userId) throws Exception {
        JSONObject jsonObject = null;
        BeanUser user = null;

        SqlSession session = MybatiesSession.getSession();
        user = session.selectOne("selectUser", userId);
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";

        if ( user == null) {
            jsonObject = JsonUtil.errorResult(401, "学生不存在");
        }  else {
            //密码加密
            String md5Pwd = DigestUtils.md5DigestAsHex("123456".getBytes());
            user.setUserpwd(md5Pwd);

            session.update("updateUser", user);
            jsonObject = JsonUtil.UserResult(200, user);
        }

        session.commit();
        return jsonObject;
    }

    // 管理员修改密码
    public JSONObject changeManagerPwd(String  userId, String oldPwd, String newPwd, String newPwd2) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanManager manager = session.selectOne("selectManager", userId);
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";

        if (oldPwd.equals("") || newPwd.equals("")|| newPwd2.equals("")) {
            jsonObject = JsonUtil.errorResult(401, "密码不得为空");
        } else if (!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(manager.getManagerpwd())) {
            jsonObject = JsonUtil.errorResult(401, "原密码错误");
        } else if (!newPwd.equals(newPwd2)) {
            jsonObject = JsonUtil.errorResult(401, "两次密码不同");
        } else if (newPwd.equals(oldPwd)) {
            jsonObject = JsonUtil.errorResult(401, "与原密码相同");
        } else {
            //密码加密
            String md5Pwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
            manager.setManagerpwd(md5Pwd);

            session.update("updateManager", manager);
            jsonObject = JsonUtil.ManagerResult(200, manager);
        }

        session.commit();
        return jsonObject;
    }

    // 编辑个人信息
    public JSONObject upadateUser(String userId, String userName, String userSex, String userMajor, String userClass, String userTel) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        BeanUser user = session.selectOne("selectUser", userId);
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
    public JSONObject deleteUser(String userId) throws Exception {
        JSONObject jsonObject = null;

        SqlSession session = MybatiesSession.getSession();
        session.delete("deleteUser",userId);
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
            if(!userList.get(i).getUserid().equals("0")){
                jsonObject = JsonUtil.UserResult(200, userList.get(i));
                list.add(jsonObject);
            }

        }

        session.commit();
        return list;
    }

    // 显示所有管理员
    public List<JSONObject> loadManager() throws Exception {
        List<BeanManager> managerList = null;
        JSONObject jsonObject = null;
        List<JSONObject> list = new ArrayList<JSONObject>();

        SqlSession session = MybatiesSession.getSession();
        managerList = session.selectList("selectAllManager");

        for(int i=0;i<managerList.size();i++) {
            jsonObject = JsonUtil.ManagerResult(200, managerList.get(i));
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

//        List<JSONObject> zs = a.searchUserByName("zss");
//         JSONObject zs = a.login("学生","3","1234");
        JSONObject zs = a.login("管理员","3170","1234");
        System.out.println(zs);

    }



}
