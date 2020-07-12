package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zks.service.NoticeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin

//@ResponseBody
public class NoticeController {
    //显示所有公告
    @RequestMapping(value = "/allnotice", method = RequestMethod.GET)
    public JSONObject showAllNotice() throws Exception {
        NoticeService noticeService = new NoticeService();
        String allnotice = JSON.toJSONString( noticeService.loadNotice());
        JSONArray array= JSONArray.parseArray(allnotice);
        JSONObject result = new JSONObject();
        result.put("allnotice",array);
        return result;
    }
    //显示全校公告
    @RequestMapping(value = "/noticebyschool", method = RequestMethod.GET)
    public JSONObject showNoticeBySchool() throws Exception {
        NoticeService noticeService = new NoticeService();
        String noticebyschool = JSON.toJSONString( noticeService.loadNoticeBySchool());
        JSONArray array= JSONArray.parseArray(noticebyschool);
        JSONObject result = new JSONObject();
        result.put("noticebyschool",array);
        return result;
    }

    //显示社团公告
    @RequestMapping(value = "noticebyassociations", method = RequestMethod.POST)
    public JSONObject showNoticeByAssociations(@RequestParam("associationsId") Integer associationsId) throws Exception {
        NoticeService noticeService = new NoticeService();
        String noticebyassociations = JSON.toJSONString( noticeService.loadNoticeByAssociation(associationsId));
        JSONArray array= JSONArray.parseArray(noticebyassociations);
        JSONObject result = new JSONObject();
        result.put("noticebyassociations",array);
        return result;
    }
    //显示部门公告
    @RequestMapping(value = "noticebydepartment", method = RequestMethod.POST)
    public JSONObject showNoticeByDepartment(@RequestParam("userId") String userId,@RequestParam("associationId") Integer associationId) throws Exception {
        NoticeService noticeService = new NoticeService();
        String noticebydepartment = JSON.toJSONString( noticeService.loadNoticeByDepartment(userId,associationId));
        JSONArray array= JSONArray.parseArray(noticebydepartment);
        JSONObject result = new JSONObject();
        result.put("noticebydepartment",array);
        return result;
    }
    //管理员公告
    @RequestMapping(value = "adminnoticecreate", method = RequestMethod.POST)
    public JSONObject createNotice(@RequestParam("noticeRange") String noticeRange, @RequestParam("noticeName") String noticeName,
                                   @RequestParam("noticeContent") String noticeContent
    ) throws Exception {
        NoticeService noticeService = new NoticeService();
        JSONObject result = noticeService.createadminNotice(noticeRange,noticeName, noticeContent);
        return result;
    }
    // 创建社团公告
    @RequestMapping(value = "noticecreate", method = RequestMethod.POST)
    public JSONObject createNotice(@RequestParam("noticeRange") String noticeRange, @RequestParam("noticeName") String noticeName,
                                   @RequestParam("noticeContent") String noticeContent,@RequestParam("associationId") Integer associationId
    ) throws Exception {
        NoticeService noticeService = new NoticeService();
        JSONObject result = noticeService.createNotice(noticeRange,noticeName, noticeContent,associationId);
        return result;
    }
    // 创建部门公告
    @RequestMapping(value = "noticedepartmentcreate", method = RequestMethod.POST)
    public JSONObject createdepartmentNotice( @RequestParam("noticeName") String noticeName,
                                              @RequestParam("noticeContent") String noticeContent,@RequestParam("userId")  String userId,@RequestParam("associationId") Integer associationId
    ) throws Exception {
        NoticeService noticeService = new NoticeService();
        JSONObject result = noticeService.createDepartmentNotice(noticeName, noticeContent,userId,associationId);
        return result;
    }

    // 管理员创建全校公告
    @RequestMapping(value = "createmanagernotice", method = RequestMethod.POST)
    public JSONObject createManagerNotice( @RequestParam("noticeName") String noticeName, @RequestParam("noticeContent") String noticeContent) throws Exception {
        NoticeService noticeService = new NoticeService();
        JSONObject result = noticeService.createManagerNotice(noticeName, noticeContent);
        return result;
    }

    //审核公告
    @RequestMapping(value = "/examinenotice", method = RequestMethod.POST)
    public JSONObject examineNotice(@RequestParam("noticeid") int noticeid,@RequestParam("answer") Boolean answer) throws Exception {
        NoticeService noticeService = new NoticeService();
        JSONObject result = noticeService.changeNoticeState(noticeid,answer);
        return result;
    }

}
