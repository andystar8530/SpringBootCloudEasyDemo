package idv.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.example.demo.config.getRedisDataConfig;

@RestController
public class ConfigController {

    @Autowired
    private getRedisDataConfig getRedisData;
//    @Autowired
//    private RedisUtil redisUtil;

    @GetMapping(name = "/configs")
    public String getConfigs() {
    	String ans=getRedisData.getConfigA()+getRedisData.getConfigB()+"=="+getRedisData.getAngus001()+"==";
        return ans;
    }
}
