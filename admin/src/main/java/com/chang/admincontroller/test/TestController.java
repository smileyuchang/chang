package com.chang.admincontroller.test;

import com.chang.common.utils.PageUtils;
import com.chang.common.utils.R;
import com.chang.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired private RestTemplate restTemplate;

    @RequestMapping("/nacos")
    public Object list(@RequestParam Map<String, Object> params){
       return restTemplate.getForObject("http://nacos-provide/api/notToken",Object.class);
    }
}
