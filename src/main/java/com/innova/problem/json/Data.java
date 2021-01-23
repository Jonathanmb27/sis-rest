package com.innova.problem.json;

public class Data {

    private String message;
    private String url;

    public Data(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }
}
