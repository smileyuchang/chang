package com.chang.admincontroller.test;

import com.chang.common.utils.PageUtils;
import com.chang.common.utils.R;
import com.chang.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sys/user")
public class TestController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserService.queryPage(params);
        return R.ok().put("page", page);
    }
}
