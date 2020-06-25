package com.sdongwan.security.DTO;


public class SimpleResponse {
    private String content;

    public SimpleResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
