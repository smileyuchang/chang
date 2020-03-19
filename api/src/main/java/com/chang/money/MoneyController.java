package com.chang.money;

import com.chang.common.utils.HttpRequestUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money")
public class MoneyController {

    /**
     * 获取淘宝优惠券
     * @param tkl  淘口令
     * @return
     */
    @RequestMapping("/getMoney")
    public MushMoneyResponse getMoney (String tkl){
        String result = HttpRequestUtil.sendPost(CommonData.MUCH_MONEY_URL,"apikey=" + CommonData.APIKEY + "&tkl=" + tkl);
        MushMoneyResponse moneyResponse = new Gson().fromJson(result, MushMoneyResponse.class);
        return moneyResponse;
    }
}
