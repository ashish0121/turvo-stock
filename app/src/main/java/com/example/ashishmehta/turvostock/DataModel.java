package com.example.ashishmehta.turvostock;

public class DataModel {

    String name;
    String code;
    int value;

    public DataModel(String name, String code, int value) {
        this.name=name;
        this.code=code;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }
}