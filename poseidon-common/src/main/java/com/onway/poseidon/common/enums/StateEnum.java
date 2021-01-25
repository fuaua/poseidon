package com.onway.poseidon.common.enums;

/**
 * @author: fuheng
 * @date: 2021/1/25 15:09
 * @description:
 */
public enum StateEnum {

    VALID("有效", 1),
    INVALID("无效", 0);

    StateEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private Integer value;

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
