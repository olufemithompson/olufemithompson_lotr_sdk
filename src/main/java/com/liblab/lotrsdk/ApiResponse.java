package com.liblab.lotrsdk;

import org.apache.http.Header;


/**
 * Base class that represents the response from the API server
 *
 * @param <T> Actual object model from the response
 */
public class ApiResponse<T> {
    private final int statusCode;
    private final Header[] headers;
    private final T data;

    public ApiResponse(int statusCode, Header[] headers) {
        this(statusCode, headers, null);
    }

    public ApiResponse(int statusCode, Header[] headers, T data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public Header[] getHeaders() {
        return this.headers;
    }

    public T getData() {
        return this.data;
    }
}
