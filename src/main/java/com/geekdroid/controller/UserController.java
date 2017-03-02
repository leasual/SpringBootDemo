package com.geekdroid.controller;

import com.geekdroid.model.BaseController;
import com.geekdroid.model.User;
import com.geekdroid.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james.li on 2017/3/2.
 */


/**
 * @Api注解用来表述该服务的信息，如果不使用则显示类名称.
 * @ApiOperation注解用于表述接口信息
 * @ApiParam注解用于描述接口的参数
 */

@Api(value = "用户信息服务", description = "管理用户信息")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<IUserService>{


    /**
     * 用户登录
     * @param userId
     * @param password
     * @return
     */
    @ApiOperation("用户登录")
    @GetMapping(value = "/login")
    public Map<String, Object> login(@ApiParam("用户Id")@RequestParam("userId") String userId,
                                     @ApiParam("用户密码")@RequestParam("password") String password){
        User user =  service.findByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        if (user == null){
            map.put("code", "1");
            map.put("message", "user is not exist");
        }else if (!user.getPassword().equals(password)){
            map.put("code", "1");
            map.put("message", "password is not correct");
        } else{
            map.put("code", "0");
            map.put("message", "login success");
            map.put("result", user);
        }
        return map;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping(value = "/register")
    public Map<String, Object> register(@ApiParam("用户信息")@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        if (user.getUserId() != null && user.getPassword() != null) {
            service.save(user);
            map.put("code", "0");
            map.put("message", "login success");
            map.put("result", user);
        }else{
            map.put("code", "1");
            map.put("message", "userName or password is empty");
        }
        return map;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @ApiOperation("更新用户信息")
    @PostMapping(value = "/updateUserInfo")
    public Map<String, Object> updateUserInfo(@ApiParam("用户信息")@RequestBody User user){
        service.updateUserInfo(user.getUserId(), user.getNickName(), user.getDescription());

        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("message", "update user info success");
        return map;
    }
}
