package com.chang.test.java8;

import lombok.Data;

@Data
public class Apple {
    /** 编号 */
    private long id;


    /** 重量 */
    private float weight;

    /** 产地 */
    private String origin;

    public Apple() {
    }

    public Apple(long id, float weight, String origin) {
        this.id = id;
        this.weight = weight;
        this.origin = origin;
    }
}
