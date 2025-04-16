package com.service.product.api.Medicalcommerce.API;

import java.util.List;

public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    private List<T> dataList;

    public ApiResponse(){

    }
    public ApiResponse(int status, String message, T data, List<T> dataList) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.dataList = dataList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> data) {
        this.dataList = data;
    }
}