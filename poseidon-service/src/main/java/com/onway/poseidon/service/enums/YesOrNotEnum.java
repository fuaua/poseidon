package com.onway.poseidon.service.enums;

/**
 * @author: fuheng
 * @date: 2021/1/25 18:24
 * @description:
 */
public enum YesOrNotEnum {

    YES("是", 1),

    NOT("否", 0);

    YesOrNotEnum(String name, Integer value) {
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
