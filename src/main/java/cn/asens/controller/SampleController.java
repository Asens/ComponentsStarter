package cn.asens.controller;

import cn.asens.config.BaseJDBC;
import cn.asens.dao.UserDao;
import cn.asens.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asens on 2017/7/13
 */

@Controller
public class SampleController {
    private static Logger log= LogManager.getLogger(SampleController.class);

    private String name;

    @Autowired
    private UserDao userDao;

    @Resource
    private BaseJDBC baseJDBC;

    @PostConstruct
    public void init(){
       // baseJDBC.update("SET SCHEMA note_test");
    }

    @RequestMapping("/")
    public String home(ModelMap model) {
        User user=userDao.findByaaId();
        model.put("freeMarker","freeMarker");
        model.put("user",user);
        return "welcome";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(ModelMap model) {
        User user=new User();
        user.setName("aa"+System.currentTimeMillis());
        userDao.save(user);
        return "success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(ModelMap model) {
        User user=userDao.findByaaId();
        userDao.delete(user);
        return "success";
    }



}
