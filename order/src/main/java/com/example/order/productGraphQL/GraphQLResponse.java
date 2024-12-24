package com.example.order.productGraphQL;


import java.util.Map;

public class GraphQLResponse<T> {
    private Map<String, T> data;

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }
}
