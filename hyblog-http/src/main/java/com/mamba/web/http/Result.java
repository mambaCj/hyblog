package com.mamba.web.http;

public class Result<T> {

    protected String code;
    protected String result;
    private T data;

    public Result(T data) {
        this(null, null, data);
    }

    public Result(String code) {
        this(code, null, null);
    }

    public Result(String code, String message) {
        this(code, message, null);
    }

    public Result(String code, String result, T data) {
        this.code = code;
        this.result = result;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
