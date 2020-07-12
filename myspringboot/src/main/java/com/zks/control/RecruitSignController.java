package com.zks.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zks.model.BeanUser;
import com.zks.service.RecruitSignService;
import com.zks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/api")
@CrossOrigin
@ResponseBody
public class RecruitSignController {
    //显示所有申请表
    @RequestMapping(value = "/allrecruitnotice", method = RequestMethod.GET)
    public JSONObject showAllRecruitSign() throws Exception {
        RecruitSignService recruitSign = new RecruitSignService();
        String allRecruitSign = JSON.toJSONString( recruitSign.loadAllRecruitSign());
        JSONArray array= JSONArray.parseArray(allRecruitSign);
        JSONObject result = new JSONObject();
        result.put("allrecruitnotice",array);
        return result;
    }

    //显示该社团下所有申请表
    @RequestMapping(value = "/allassociationrecruit", method = RequestMethod.POST)
    public JSONObject showAllRecruitSignByAssociation(@RequestParam("associationId") Integer associationId) throws Exception {
        RecruitSignService recruitSign = new RecruitSignService();
        String allRecruitSign = JSON.toJSONString( recruitSign.loadAllRecruitSignByAssociationsId(associationId));
        JSONArray array= JSONArray.parseArray(allRecruitSign);
        JSONObject result = new JSONObject();
        result.put("allassociationrecruit",array);
        return result;
    }

    //创建招新申请表(招新报名)
    @RequestMapping(value = "/createrecruitsign", method = RequestMethod.POST)
    public JSONObject createRecruitSign(@RequestParam("userId") String userId, @RequestParam("associationsId") int associationsId,
                                        @RequestParam("recruitSignContent") String recruitSignContent,
                                        @RequestParam("recruitNoticeStartTime") String startTime) throws Exception {
        RecruitSignService recruitSign = new RecruitSignService();
        JSONObject result = recruitSign.insertrecruit(userId, associationsId, recruitSignContent,startTime);
        return result;
    }

    //审核招新报名表
    @RequestMapping(value = "/changerecruitnotice", method = RequestMethod.POST)
    public JSONObject changeRecruitSignState(@RequestParam("recruitSignId") int recruitSignId,
                                             @RequestParam("recruitSignApplicationState") String recruitSignApplicationState) throws Exception {
        RecruitSignService recruitSignState = new RecruitSignService();
        JSONObject result = recruitSignState.changeState(recruitSignId,recruitSignApplicationState);
        return result;
    }

    //社长分配部门
    @RequestMapping(value = "/changedepartment", method = RequestMethod.POST)
    public JSONObject changedepartment(@RequestParam("memberId") int memberId, @RequestParam("associationsId") int associationsId) throws Exception {
        RecruitSignService member = new RecruitSignService();
        JSONObject result = member.changeDepartment(memberId, associationsId);
        return result;
    }
}
