package com.intercorpretail.customers.core.response;

import java.util.List;

public class WrapperResponse<T> {
    public String error;
    public T data;
    public List<T> listData;

    public WrapperResponse(T data) {
        this.data = data;
    }

    public WrapperResponse(List<T> listData) {
        this.listData = listData;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}