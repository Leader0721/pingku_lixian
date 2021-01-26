package com.example.ckxt_yezhan.bean;


public class MainBean {
    private String name;
    private String type;
    private String content;

    public MainBean(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public MainBean(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
