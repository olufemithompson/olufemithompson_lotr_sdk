package com.liblab.lotrsdk;
import java.util.Map;
import java.util.HashMap;


/**
 * Base class that represents HttpRequest object. holds information about
 * query parameters, endpoint e.t.c
 */
public abstract class ApiRequest {

    private String endpoint;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;


    public ApiRequest() {
        this.headers = new HashMap<String, String>();
        this.queryParams = new HashMap<String, String>();
    }



    protected void addQueryParam(String key, String value) {
        this.queryParams.put(key, value);
    }

    protected void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

}
