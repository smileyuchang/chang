package com.chang.controller;


import com.chang.annotation.Login;
import com.chang.annotation.LoginUser;
import com.chang.common.utils.R;
import com.chang.modules.apiuser.entity.UserEntity;
import com.chang.test.MapTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

//import com.chang.test.rabbitmq.Sender;


/**
 * 测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
@RefreshScope
public class ApiTestController {
   /* @Autowired
    private Sender sender;*/
  
    //---------------------------------------------------------------------------

    @Login
    @GetMapping("userInfo")
    @ApiOperation(value="获取用户信息", response=UserEntity.class)
    public R userInfo(@ApiIgnore @LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public R userInfo(@ApiIgnore @RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。" + "jenkins测试");
    }

    /**
     * rabbitMQ延时消费
     */
   /* @PostMapping("testRabbitMQ")
    public void testRabbitMQ(){
        //sender.sendFanout();
        // 测试延迟10秒
        messageProvider.sendMessage("测试延迟消费,写入时间：" + new Date(),
                QueueEnum.MESSAGE_TTL_QUEUE.getExchange(),
                QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(),
                10000);
    }*/

    @PostMapping("testListGroup")
    public R testListGroup(){
        return R.ok().put("data", MapTest.test3());
    }

}
