package com.chang.money;


import lombok.Data;

@Data
public class MuchMoney {
    private String apikey;//接口秘钥，请登录后台获取

    private String tkl;//淘口令，支持传入包含口令的整个文案，但最好是直接传一个口令
}
