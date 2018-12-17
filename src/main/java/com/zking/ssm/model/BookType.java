package com.zking.ssm.model;

import java.io.Serializable;

public class BookType implements Serializable {

    private String bType;
    private String bValue;

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getbValue() {
        return bValue;
    }

    public void setbValue(String bValue) {
        this.bValue = bValue;
    }

    public BookType() {
        super();
    }

    public BookType(String bType, String bValue) {
        this.bType = bType;
        this.bValue = bValue;
    }
}
