package com.mmall.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 需要安装 redis 才能调用
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestParam("k") String key, @RequestParam("v")String vlaue) throws Exception {
        redisClient.set(key,vlaue);
        return "Success";
    }


    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("k")String key) throws Exception {
        return redisClient.get(key);
    }
}
