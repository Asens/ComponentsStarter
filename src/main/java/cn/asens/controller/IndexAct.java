package cn.asens.controller;

import cn.asens.entity.User;
import cn.asens.mng.UserMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Asens on 2017/7/13
 */

@RestController
public class IndexAct {
    private static Logger log= LogManager.getLogger(IndexAct.class);
    @Resource
    private UserMng userMng;

    @RequestMapping("/")
    public String index(ModelMap model) {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("cc");
            userMng.save(user);
        }
        return "success";
    }



}
