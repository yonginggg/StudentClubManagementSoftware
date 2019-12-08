package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.AssociationService;
import com.zks.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class AssociationsController {
    @RequestMapping(value = "/createassociation", method = RequestMethod.POST)
    public JSONObject createAssociation(@RequestParam("associationsName") String associationsName, @RequestParam("associationsType") String associationsType,
                                        @RequestParam("associationsIntroduction") String associationsIntroduction, @RequestParam("associationsLeader") String associationsLeader) throws Exception {
        AssociationService associationService = new AssociationService();
        JSONObject result = associationService.createAssociation(associationsName, associationsType, associationsIntroduction, associationsLeader);
        return result;
    }
    //查找用户所属社团
    @RequestMapping(value = "/allassociationbyuserid", method = RequestMethod.POST)
    public JSONObject selectAssociationByUserId(@RequestParam("userId") String userId) throws Exception {
        AssociationService associationService = new AssociationService();
        String allAssociations = JSON.toJSONString(associationService.selectAssociationByUserId(userId));
        JSONArray array = JSONArray.parseArray(allAssociations);
        JSONObject result = new JSONObject();
        result.put("allassociationbyuserid",array);
        return result;
    }
    //查找所有社团
    @RequestMapping(value = "/allassociations", method = RequestMethod.GET)
    public JSONObject selectAllAssociations() throws Exception {
        AssociationService associationService = new AssociationService();
        String allAssociations = JSON.toJSONString(associationService.selectAllAssociations());
        JSONArray array = JSONArray.parseArray(allAssociations);
        JSONObject result = new JSONObject();
        result.put("allassociations",array);
        return result;
    }
    //按状态查找社团
    @RequestMapping(value = "/allassociationsbystate", method = RequestMethod.POST)
    public JSONObject selectAssociationsByState(@RequestParam("associationstate") String state) throws Exception {
        AssociationService associationService = new AssociationService();
        String allAssociations = JSON.toJSONString(associationService.selectAssociationsByState(state));
        JSONArray array = JSONArray.parseArray(allAssociations);
        JSONObject result = new JSONObject();
        result.put("allassociationsbystate",array);
        return result;
    }
    //更改社团状态（比如说：已删除，正在审核，审核通过，审核失败）
    //审核通过之后，更改社团创立时间
    @RequestMapping(value = "/modifyassociationsstatebyid", method = RequestMethod.POST)
    public JSONObject modifyAssociationsStateById(@RequestParam("associationsId") int assid,@RequestParam("associationstate") String state) throws Exception {
        AssociationService associationService = new AssociationService();
        JSONObject result = associationService.modifyAssociationsState(assid,state);
        result.put("modifyassociationsstatebyid",result);
        return result;
    }
    //更改社团简介
    @RequestMapping(value = "/modifyassociationsintroductbyid", method = RequestMethod.POST)
    public JSONObject modifyAssociationsIntroductById(@RequestParam("associationsid")int assid,
                                                      @RequestParam("associationsintroduction") String intro) throws Exception {
        AssociationService associationService = new AssociationService();
        JSONObject result = associationService.modifyAssociationsIntroductById(assid,intro);
        result.put("modifyassociationsstatebyid",result);
        return result;
    }
}
