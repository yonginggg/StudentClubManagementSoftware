package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class DepartmentController {
    //创建部门
    @RequestMapping(value = "/createdepartment", method = RequestMethod.POST)
    public JSONObject createDepartment(@RequestParam("departmentName") String departmentName,  @RequestParam("departmentLeader") String departmentLeader,
                                       @RequestParam("associationId") String associationId) throws Exception {
        DepartmentService departmentService = new DepartmentService();
        JSONObject result = departmentService.createDepartment(departmentName, departmentLeader, Integer.valueOf(associationId));
        return result;
    }
    //查找用户所在部门id与部门名字
    @RequestMapping(value = "/alldepartmentbyuserid", method = RequestMethod.POST)
    public JSONObject selectDepartmentByUserId(@RequestParam("userId") String userId) throws Exception {
        DepartmentService departmentService = new DepartmentService();
        String allDepartment = JSON.toJSONString(departmentService.selectDepartmentByUserId(userId));
        JSONArray array = JSONArray.parseArray(allDepartment);
        JSONObject result = new JSONObject();
        result.put("allallDepartmentbyuserid",array);
        return result;
    }
    //改变部门职位
    @RequestMapping(value = "/updatedepartmentleader", method = RequestMethod.POST)
    public JSONObject updateDepartmentLeader(@RequestParam("departmentId") Integer departmentId,
                                             @RequestParam("departmentLeader") String departmentLeader) throws Exception {
        DepartmentService departmentService = new DepartmentService();
        JSONObject result = departmentService.updateDepartmentLeader(departmentId,departmentLeader);
        result.put("departmentLeader",result);
        return result;
    }
    //改变部门名字
    @RequestMapping(value = "/updatedepartmentname", method = RequestMethod.POST)
    public JSONObject updateDepartmentName(@RequestParam("departmentId") Integer departmentId,
                                             @RequestParam("departmentName") String departmentName) throws Exception {
        DepartmentService departmentService = new DepartmentService();
        JSONObject result = departmentService.updateDepartmentName(departmentId,departmentName);
        result.put("departmentName",result);
        return result;
    }
    //解散部门
//    @RequestMapping(value = "/deletedepartment", method = RequestMethod.POST)
//    public JSONObject deleteDepartment(@RequestParam("departmentId") Integer departmentId
//                                             ) throws Exception {
//        DepartmentService departmentService = new DepartmentService();
//        JSONObject result = departmentService.deleteDepartment(departmentId);
//        result.put("department",result);
//        return result;
//    }
}
