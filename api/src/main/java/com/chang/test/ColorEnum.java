package com.chang.test;

/**
 * 枚举测试
 * @Autauthor yuchang
 */
public enum  ColorEnum {
    RED("red","红色"),
    GREEN("green","绿色"),
    BLUE("blue","蓝色");
    //防止字段值被修改，增加的字段也统一final表示常量
    private final String key;
    private final String value;

    ColorEnum(String key,String value){
        this.key = key;
        this.value = value;
    }
    //根据key获取枚举
    public static ColorEnum getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(ColorEnum temp:ColorEnum.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }






    /**
     * witch结合enum使用
     * @param s
     */
    public static void judge(ColorEnum s){
        switch(s)
        {
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
        }


    }
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED.getValue());
        ColorEnum s = ColorEnum.RED;
        ColorEnum.judge(s);
    }
}
