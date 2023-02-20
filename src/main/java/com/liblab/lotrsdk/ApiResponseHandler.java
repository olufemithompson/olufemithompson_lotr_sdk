package com.liblab.lotrsdk;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class ApiResponseHandler extends AbstractResponseHandler<String> {

    @Override
    public String handleResponse(final HttpResponse response)
            throws HttpResponseException, IOException {
        final HttpEntity entity = response.getEntity();
        return entity == null ? null : handleEntity(entity);
    }

    @Override
    public String handleEntity(HttpEntity entity) throws IOException {
        return EntityUtils.toString(entity);
    }
}
