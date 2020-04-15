package com.chang.common.wechat;

import com.alibaba.fastjson.JSONObject;
import com.chang.common.utils.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信登陆工具类
 */
public class WechatLoginUtil {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据code换取 access_token和openId
     * @param code
     * @return
     */
    public Map<String, Object> getAccessToken(String code){
        Map<String, Object> map = new HashMap<>();
        try{
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?";
            String result = HttpRequestUtil.sendGet(url,"appid="+WechatConfig.APP_ID+"&secret="+WechatConfig.APP_SECRET+"&code="+code+"&grant_type=authorization_code");
            this.logger.error("获取微信accessToken回调数据"+result);
            JSONObject jsStr = JSONObject.parseObject(result);
            this.logger.error("获取微信accessToken回调数据"+jsStr.toString());
            String accessTokenWechat = jsStr.getString("access_token");
            String openid = jsStr.getString("openid");

            map.put("access_token",accessTokenWechat);
            map.put("openid",openid);
            this.logger.error("获取微信accessToken="+accessTokenWechat+";openId="+openid);
        }catch(Exception e){
            this.logger.error("获取微信accessToken失败", e);
        }
        return map;
    }
    /**
     * 获取用户信息
     * @param accessToken
     * @param openId
     * @return
     */
    public Map<String, Object> getUserInfoByCode(String accessToken,String openId) {
        Map<String, Object> map = new HashMap<>();
        try {
            String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId;
            String result = HttpRequestUtil.sendGet(url,"access_token="+ accessToken + "&openid=" + openId);
            JSONObject jsStr = JSONObject.parseObject(result);
            String nickname = jsStr.getString("nickname");
            String sex = jsStr.getString("sex");
            String province = jsStr.getString("province");
            String city = jsStr.getString("city");
            String country = jsStr.getString("country");
            String headimgurl = jsStr.getString("headimgurl");
            String unionid = jsStr.getString("unionid");
            map.put("nickname", nickname);
            map.put("sex", sex);
            map.put("province", province);
            map.put("city", city);
            map.put("country", country);
            map.put("headimgurl", headimgurl);
            map.put("unionid", unionid);
            map.put("openid", openId);
            this.logger.error("获取微信信息成功nickname=" + nickname);
        } catch (Exception e) {
            this.logger.error("获取微信信息失败", e);
        }
        this.logger.error("获取微信信息失败");
        return map;

    }
}
