package io.renren.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//数据结构处理
public class MapTest {

    /*
     {
        "msg": "success",
        "mapTest": [
            {
                "items": [
                    {
                        "itemName": "iphone",
                        "price": "10000",
                        "count": "100"
                    },
                    {
                        "itemName": "iphone",
                        "price": "9000",
                        "count": "10"
                    }
                ],
                "name": "iphone"
            },
            {
                "items": [
                    {
                        "itemName": "华为",
                        "price": "10000",
                        "count": "100"
                    }
                ],
                "name": "华为"
            }
        ],
        "code": 0
    }
    */
    public static List<ReturnWrap> test (){
        List<ReturnWrap> returnWapList = new ArrayList<ReturnWrap>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("itemName","iphone");
        map1.put("price","10000");
        map1.put("count","100");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("itemName","iphone");
        map3.put("price","9000");
        map3.put("count","10");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("itemName","华为");
        map2.put("price","10000");
        map2.put("count","100");
        List<Map<String,Object>> goodsList = new ArrayList<>();
        goodsList.add(map1);
        goodsList.add(map2);
        goodsList.add(map3);

        for (Map<String,Object> map : goodsList) {
            boolean flag = false;
            if (!flag) {
                List<Map<String,Object>> itemList  = new ArrayList<Map<String,Object>>();
                itemList.add(map);
                returnWapList.add(new ReturnWrap(itemList, map.get("itemName").toString()));
            }
        }
        return returnWapList;
    }

  /*list<Map<String,Object>>    lambda表达式 groupingBy分组
    {
        "msg": "success",
            "code": 0,
            "data": {
                    "华为": [
                    {
                        "itemName": "华为",
                            "price": "10000",
                            "count": "100"
                    }
                    ],
                    "iphone": [
                    {
                        "itemName": "iphone",
                            "price": "10000",
                            "count": "100"
                    },
                    {
                        "itemName": "iphone",
                            "price": "9000",
                            "count": "10"
                    }
                ]
            }
        }
    */

    public static Object test2 (){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("itemName","iphone");
        map1.put("price","10000");
        map1.put("count","100");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("itemName","iphone");
        map3.put("price","9000");
        map3.put("count","10");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("itemName","华为");
        map2.put("price","10000");
        map2.put("count","100");
        List<Map<String,Object>> goodsList = new ArrayList<>();
        goodsList.add(map1);
        goodsList.add(map2);
        goodsList.add(map3);

        Map<Object, List<Map<String, Object>>> result  =  goodsList.stream().collect(Collectors.groupingBy(m -> m.get("itemName")));

        return result;
    }


/*list<Map<String,Object>>    lambda表达式 groupingBy分组
    {
        "msg": "success",
            "code": 0,
            "data": [
                        {
                            "targetType": "华为",
                                "items": [
                                {
                                    "itemName": "华为",
                                        "price": "10000",
                                        "count": "100"
                                }
                            ]
                        },
                        {
                            "targetType": "iphone",
                                "items": [
                            {
                                "itemName": "iphone",
                                    "price": "10000",
                                    "count": "100"
                            },
                            {
                                "itemName": "iphone",
                                    "price": "9000",
                                    "count": "10"
                            }
                            ]
                        }
                    ]
    }*/
    public static Object test3 (){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("itemName","iphone");
        map1.put("price","10000");
        map1.put("count","100");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("itemName","iphone");
        map3.put("price","9000");
        map3.put("count","10");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("itemName","华为");
        map2.put("price","10000");
        map2.put("count","100");
        List<Map<String,Object>> goodsList = new ArrayList<>();
        goodsList.add(map1);
        goodsList.add(map2);
        goodsList.add(map3);

        goodsList = goodsList.stream().collect(Collectors.groupingBy(e -> e.get("itemName")))
                .entrySet().stream().map(e -> {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("items", e.getValue());
            mapa.put("targetType", e.getKey());
            return mapa;
        }).collect(Collectors.toList());

        return goodsList;
    }


    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.test();
    }
}


/**
 * test1用到
 */
class ReturnWrap {

    private List<Map<String,Object>> items;

    private String name;

    public ReturnWrap(List<Map<String, Object>> items, String name) {
        super();
        this.items = items;
        this.name = name;
    }

    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


