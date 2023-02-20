package com.liblab.lotrsdk;

import com.liblab.lotrsdk.helpers.SdkException;

import java.lang.reflect.Type;

/**
 * Base API Class
 *
 * An abstract class that exposes function to make http request
 *
 */
public abstract class BaseAPI {

    private final ApiClient client;

    public BaseAPI(String apiKey){
        this.client = ApiClient.createClient(apiKey);
    }

    protected  ApiResponse get(ApiRequest request, Type returnType) throws SdkException {
        return this.client.get(request, returnType);
    }
}
