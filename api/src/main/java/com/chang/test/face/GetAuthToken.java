package com.chang.test.face;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAuthToken {

    // 设置APPID/AK/SK
    public static final String APP_ID = "20001571";
    public static final String API_KEY = "yn7Vy3aNDnaywSs0qzUzgvX3";
    public static final String SECRET_KEY = "asIuU6IwiqCQISLgilNQLz9oIGQ79Yp6";


    //24.f231b90f42c26baa2e1fb55acc3cc873.2592000.1592706222.282335-20001571
    public static final String access_token = "24.f231b90f42c26baa2e1fb55acc3cc873.2592000.1592706222.282335-20001571";
    public static final String url = "https://baike.baidu.com/pic/%E4%B9%A0%E8%BF%91%E5%B9%B3/515617/0/54fbb2fb43166d22ca0c87944a2309f79052d2b3?fr=lemma&ct=single";

    //face_token：ba22b304bc21d06d3e0886dc976be3fb
    //ba22b304bc21d06d3e0886dc976be3fb
    //867a300fa8f0aa822685c9f1edb60a7a
    public static void main(String[] args) throws Exception{
        //System.out.println("access_token=====" + getAuth(API_KEY, SECRET_KEY));
       /* try {
            add(access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
       search();
    }

    /**
     * 获取 access_token
     * @param ak
     * @param sk
     * @return
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost

                + "grant_type=client_credentials"		// 1. grant_type为固定参数
                + "&client_id=" + ak					// 2. 官网获取的 API Key
                + "&client_secret=" + sk;				// 3. 官网获取的 Secret Key
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);

            JSONObject jsonObject = JSONObject.parseObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }


    /**
     * 人脸注册
     * @return
     * @throws Exception
     */
    public static String add(String accessToken) throws Exception {

        byte[] bytes1 = FileUtil.readFileByBytes("/Users/yuchang/Downloads/李克强.jpeg");
        //String image1 = Base64Util.encode(getImgerFormNetByUrl(url));
        String image1 = Base64Util.encode(bytes1);
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", image1);
            map.put("group_id", "group_repeat");
            map.put("user_id", "likeqiang");
            map.put("user_info", "abc");
            map.put("liveness_control", "NORMAL");
            //map.put("image_type", "FACE_TOKEN");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            Gson gson = new Gson();
            String param = gson.toJson(map);
            // 客户端可自行缓存，过期后重新获取。
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String search() throws Exception {

        byte[] bytes1 = FileUtil.readFileByBytes("/Users/yuchang/Downloads/李克强.jpeg");
        //String image1 = Base64Util.encode(getImgerFormNetByUrl(url));
        String image1 = Base64Util.encode(bytes1);
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image1); //图片base64数据
            map.put("liveness_control", "NORMAL");  //活体检测控制一般的
            map.put("group_id_list", "group_repeat");  //指定用户组group 人脸库总已经存在的用户组
            map.put("image_type", "BASE64");     //图片类型，这里转化过的base64
            map.put("quality_control", "LOW");   //图片质量控制

            Gson gson = new Gson();
            String param = gson.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。

            String result = HttpUtil.post(url, access_token, "application/json", param);
            String score = result.split(",")[9].split(":")[1];
            System.out.println(result);
            System.out.println(score);
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

