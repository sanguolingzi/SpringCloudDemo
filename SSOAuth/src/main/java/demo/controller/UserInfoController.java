package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserInfoController {

    @RequestMapping(value="/getUser")
    public Map<String,Object> getUser(){
        Map<String,Object> map = new HashMap<>();

        map.put("id",1);
        map.put("name","testUser");
        return map;
    }
}
