package com.liblab.lotrsdk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.liblab.lotrsdk.helpers.SdkException;
import io.gsonfire.GsonFireBuilder;
import lombok.NonNull;
import org.apache.http.Header;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Main ApiClient Class that handles submission of http request and handling http responses.
 *
 * For this class only GET http request is implemented, considering the scope of the work is limited to that.
 *
 */
public class ApiClient implements Closeable {


    private CloseableHttpClient httpClient;


    //base server api host
    private final String baseApiHostName ="the-one-api.dev/v2";

    // api key
    private final String apiKey;


    private final Gson gson;


    private ApiClient(@NonNull String apiKey) {
        this.httpClient = HttpClients.createDefault();
        this.apiKey  = apiKey;
        this.gson = this.createGson().create();
    }


    private  GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder();
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    public static ApiClient createClient(@NonNull String apiKey){
        return new ApiClient(apiKey);
    }

    protected URI buildUri(ApiRequest request) throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(baseApiHostName);
        builder.setPath(request.getEndpoint());
        if (request.getQueryParams() != null) {
            for (Map.Entry<String, String> entry : request.getQueryParams().entrySet()) {
                builder.setParameter(entry.getKey(), entry.getValue());
            }
        }
        URI uri = builder.build();
        return uri;
    }


    private  Header[]  getResponseHeaders(CloseableHttpResponse response){
        Header[] headers = response.getAllHeaders();
        Map<String, String> responseHeaders = new HashMap<String, String>();
        for (Header h : headers) {
            responseHeaders.put(h.getName(), h.getValue());
        }
        return headers;
    }


    private <T> T parseAndReturnResponseObject(CloseableHttpResponse response, Type returnType) throws IOException {
        ResponseHandler<String> handler = new ApiResponseHandler();
        String responseBody = handler.handleResponse(response);
        JsonReader jsonReader = new JsonReader(new StringReader(responseBody));
        jsonReader.setLenient(true);
        return this.gson.fromJson(jsonReader, returnType);
    }


    public <T> ApiResponse<T> get(ApiRequest request, Type type) throws SdkException {
        URI uri = null;
        HttpGet httpGet = null;

        try {
            uri = buildUri(request);
            httpGet = new HttpGet(uri.toString());
        } catch (URISyntaxException ex) {
            throw new SdkException(ex.getMessage());
        }
        httpGet.setHeader("Authorization","Bearer "+apiKey);
        if (request.getHeaders() != null) {
            for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }

        try {
            CloseableHttpResponse serverResponse = httpClient.execute(httpGet);
            try {
                int statusCode = serverResponse.getStatusLine().getStatusCode();
                Header[] headers = getResponseHeaders(serverResponse);
                T data = parseAndReturnResponseObject(serverResponse, type);
                return new ApiResponse(statusCode,headers,data);
            } finally {
                serverResponse.close();
                close();
            }
        }
        catch(IOException e) {
            throw new SdkException(e.getMessage());
        }
    }


    @Override
    public void close() throws IOException {
        this.httpClient.close();
    }

    @Override
    public void finalize() throws Throwable {
        try {
            close();
        } catch(IOException e) {
            throw new Throwable(e.getMessage());
        } finally {
            super.finalize();
        }
    }
}
