package com.chang.controller;


import com.chang.annotation.Login;
import com.chang.common.validator.ValidatorUtils;
import com.chang.common.utils.R;
import com.chang.modules.apiuser.form.LoginForm;
import com.chang.modules.apiuser.service.TokenService;
import com.chang.modules.apiuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 登录接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = userService.login(form);

        return R.ok(map);
    }

    @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}
