package com.chang.money;

import lombok.Data;

@Data
public class MushMoneyResponse {

    /**
     * code : 200
     * msg : 请求成功【success】
     * data : {"category_id":50025705,"coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=4FyOYoWUnv0GQASttHIRqV35f01cx01l3Jdw3v5sUHwz4gyqj4NKJsqatRQD5SiDppB3gLXGTEi3kopoiy8v6L1rvoTSYZDESEyvAL3v9LIdpsGU%2BrnkFLCSyLFw4qsuJ47rYvIjaE20%2Bc5Gzwi6gW5us6IkMHWUSn4qX%2BrddxhSB%2B1Ec1jfd9l4X1VWjKahWW8TJtOxgH2JeYsp2j05Lw%3D%3D&traceId=0b0fb30a15777133523193534e&union_lens=lensId:0b57b770_8f71_16f570b3e9e_d703&xId=kuGd2TpFC8lqZncGS2ICSDDwQfCEulw3M20n0wipe5Ax04vOoMv2pwigagjTAKHCDqhLaplRqyuHbkcaT040hv","coupon_end_time":"2020-01-01","coupon_info":"满19元减5元","coupon_remain_count":94000,"coupon_start_time":"2019-12-30","coupon_total_count":100000,"coupon_type":3,"item_id":583558487732,"item_url":"https://s.click.taobao.com/t?e=m%3D2%26s%3DVTL7LhphpHBw4vFB6t2Z2ueEDrYVVa64K7Vc7tFgwiHLWlSKdGSYDkQvdAic%2Fpkz8sviUM61dt2c2prFaV2LKudbrTqsfX0%2BNZnkUf0aQqZOnjDOOPy2MHcw31TL7nyO9Ylf5BETfD2enTT7xcx0tKLWMw3EOEsyGtHDED2isd0JWaXGOTpUQ%2BuS2z%2F8om8GA13NwUW6D5vkwRZR8lHBs%2BLsmurvEScN4%2FA2YHvW%2FiMnQmfKQHknZMYOae24fhW0&union_lens=lensId:0b57b770_8f71_16f570b3e9e_d703&xId=kuGd2TpFC8lqZncGS2ICSDDwQfCEulw3M20n0wipe5Ax04vOoMv2pwigagjTAKHCDqhLaplRqyuHbkcaT040hv","max_commission_rate":"9.00","coupon":"5"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * category_id : 50025705
         * coupon_click_url : https://uland.taobao.com/coupon/edetail?e=4FyOYoWUnv0GQASttHIRqV35f01cx01l3Jdw3v5sUHwz4gyqj4NKJsqatRQD5SiDppB3gLXGTEi3kopoiy8v6L1rvoTSYZDESEyvAL3v9LIdpsGU%2BrnkFLCSyLFw4qsuJ47rYvIjaE20%2Bc5Gzwi6gW5us6IkMHWUSn4qX%2BrddxhSB%2B1Ec1jfd9l4X1VWjKahWW8TJtOxgH2JeYsp2j05Lw%3D%3D&traceId=0b0fb30a15777133523193534e&union_lens=lensId:0b57b770_8f71_16f570b3e9e_d703&xId=kuGd2TpFC8lqZncGS2ICSDDwQfCEulw3M20n0wipe5Ax04vOoMv2pwigagjTAKHCDqhLaplRqyuHbkcaT040hv
         * coupon_end_time : 2020-01-01
         * coupon_info : 满19元减5元
         * coupon_remain_count : 94000
         * coupon_start_time : 2019-12-30
         * coupon_total_count : 100000
         * coupon_type : 3
         * item_id : 583558487732
         * item_url : https://s.click.taobao.com/t?e=m%3D2%26s%3DVTL7LhphpHBw4vFB6t2Z2ueEDrYVVa64K7Vc7tFgwiHLWlSKdGSYDkQvdAic%2Fpkz8sviUM61dt2c2prFaV2LKudbrTqsfX0%2BNZnkUf0aQqZOnjDOOPy2MHcw31TL7nyO9Ylf5BETfD2enTT7xcx0tKLWMw3EOEsyGtHDED2isd0JWaXGOTpUQ%2BuS2z%2F8om8GA13NwUW6D5vkwRZR8lHBs%2BLsmurvEScN4%2FA2YHvW%2FiMnQmfKQHknZMYOae24fhW0&union_lens=lensId:0b57b770_8f71_16f570b3e9e_d703&xId=kuGd2TpFC8lqZncGS2ICSDDwQfCEulw3M20n0wipe5Ax04vOoMv2pwigagjTAKHCDqhLaplRqyuHbkcaT040hv
         * max_commission_rate : 9.00
         * coupon : 5
         */

        private int category_id;
        private String coupon_click_url;
        private String coupon_end_time;
        private String coupon_info;
        private int coupon_remain_count;
        private String coupon_start_time;
        private int coupon_total_count;
        private int coupon_type;
        private long item_id;
        private String item_url;
        private String max_commission_rate;
        private String coupon;

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCoupon_click_url() {
            return coupon_click_url;
        }

        public void setCoupon_click_url(String coupon_click_url) {
            this.coupon_click_url = coupon_click_url;
        }

        public String getCoupon_end_time() {
            return coupon_end_time;
        }

        public void setCoupon_end_time(String coupon_end_time) {
            this.coupon_end_time = coupon_end_time;
        }

        public String getCoupon_info() {
            return coupon_info;
        }

        public void setCoupon_info(String coupon_info) {
            this.coupon_info = coupon_info;
        }

        public int getCoupon_remain_count() {
            return coupon_remain_count;
        }

        public void setCoupon_remain_count(int coupon_remain_count) {
            this.coupon_remain_count = coupon_remain_count;
        }

        public String getCoupon_start_time() {
            return coupon_start_time;
        }

        public void setCoupon_start_time(String coupon_start_time) {
            this.coupon_start_time = coupon_start_time;
        }

        public int getCoupon_total_count() {
            return coupon_total_count;
        }

        public void setCoupon_total_count(int coupon_total_count) {
            this.coupon_total_count = coupon_total_count;
        }

        public int getCoupon_type() {
            return coupon_type;
        }

        public void setCoupon_type(int coupon_type) {
            this.coupon_type = coupon_type;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public String getItem_url() {
            return item_url;
        }

        public void setItem_url(String item_url) {
            this.item_url = item_url;
        }

        public String getMax_commission_rate() {
            return max_commission_rate;
        }

        public void setMax_commission_rate(String max_commission_rate) {
            this.max_commission_rate = max_commission_rate;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }
    }
}
