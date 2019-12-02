package com.zks.control;

import com.alibaba.fastjson.JSONObject;
import com.zks.service.AssociationService;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
