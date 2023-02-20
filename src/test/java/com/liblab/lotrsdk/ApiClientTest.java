package com.liblab.lotrsdk;

import com.google.gson.reflect.TypeToken;
import com.liblab.lotrsdk.helpers.SdkException;
import com.liblab.lotrsdk.services.movie.model.MovieQuotes;
import com.liblab.lotrsdk.services.movie.model.Movies;
import com.liblab.lotrsdk.services.movie.request.GetMovieQuotesRequest;
import com.liblab.lotrsdk.services.movie.request.GetMoviesRequest;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ApiClientTest extends Mockito {

    private CloseableHttpClient httpClient;
    private CloseableHttpResponse response;
    private HttpEntity entity;
    private StatusLine statusline;

    @Before
    public void setUp() throws Exception {
        this.httpClient = mock(CloseableHttpClient.class);
        this.response = mock(CloseableHttpResponse.class);
        this.entity = mock(HttpEntity.class);
        this.statusline = mock(StatusLine.class);
    }

    @Test
    public void testBuildUri() {
        ApiClient client = ApiClient.createClient("123");

        URI uri = null;
        GetMoviesRequest request = GetMoviesRequest.create()
                .withLimit(100)
                .withPage(1);

        try {
            uri = client.buildUri(request);
        } catch (URISyntaxException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            Assert.assertTrue(errors.toString(), false);
        }

        URL url = null;
        try {
            url = uri.toURL();
        } catch (MalformedURLException ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            Assert.assertTrue(errors.toString(), false);
        }

        Assert.assertTrue(url.getProtocol().equals("https"));
        Assert.assertTrue(url.getPath().endsWith("/movie"));
        Assert.assertTrue(this.checkQueryParamValue(url, "limit", "100"));
        Assert.assertTrue(this.checkQueryParamValue(url, "page", "1"));
    }

    @Test
    public void testGetResponseForGetMoviesRequest() {

        GetMoviesRequest request = GetMoviesRequest.create()
                .withLimit(100)
                .withPage(1);

        when(statusline.getStatusCode()).thenReturn(200);
        when(response.getStatusLine()).thenReturn(statusline);
        String responseString = (new StringBuilder())
                .append("{\"total\":\"1\",")
                .append("\"limit\":\"1\",")
                .append("\"offset\":\"1\",")
                .append("\"pages\":\"1\",")
                .append("\"page\":\"1\",")
                .append("\"docs\":[{")
                .append("\"id\":\"abcdee\",")
                .append("\"name\":\"movie1\"}]}")
                .toString();


        when(response.getEntity()).thenReturn(
                new InputStreamEntity(
                        new ByteArrayInputStream(responseString.getBytes())));
        when(response.getAllHeaders()).thenReturn(new Header[0]);

        try (MockedStatic<HttpClients> mocked = Mockito.mockStatic(HttpClients.class)) {
            mocked.when(HttpClients::createDefault).thenReturn(httpClient);

            ApiClient client = ApiClient.createClient("123");
            ApiResponse<Movies>  testResponse = null;
            try {
                when(httpClient.execute(any(HttpGet.class))).thenReturn(response);
                Type returnType = (new TypeToken<Movies>() {
                }).getType();
                testResponse = client.get(request, returnType);
            } catch (IOException ex) {
                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));
                Assert.assertTrue(errors.toString(), false);
            } catch (SdkException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                Assert.assertTrue(errors.toString(), false);
            }


            Assert.assertTrue(testResponse.getStatusCode() == 200);
            Assert.assertEquals(testResponse.getData().getPages(), 1);
            Assert.assertEquals(testResponse.getData().getLimit(), 1);
            Assert.assertEquals(testResponse.getData().getTotal(), 1);
            Assert.assertEquals(testResponse.getData().getOffset(), 1);
        }
    }

    @Test
    public void testGetResponseForGetMovieQuotesRequest() {


        when(statusline.getStatusCode()).thenReturn(200);
        when(response.getStatusLine()).thenReturn(statusline);
        String responseString = (new StringBuilder())
                .append("{\"total\":\"1\",")
                .append("\"limit\":\"1\",")
                .append("\"offset\":\"1\",")
                .append("\"pages\":\"1\",")
                .append("\"page\":\"1\",")
                .append("\"docs\":[{")
                .append("\"_id\":\"abcdee\",")
                .append("\"dialog\":\"latest dialog\"}]}")
                .toString();


        when(response.getEntity()).thenReturn(
                new InputStreamEntity(
                        new ByteArrayInputStream(responseString.getBytes())));
        when(response.getAllHeaders()).thenReturn(new Header[0]);

        try (MockedStatic<HttpClients> mocked = Mockito.mockStatic(HttpClients.class)) {
            mocked.when(HttpClients::createDefault).thenReturn(httpClient);

            ApiClient client = ApiClient.createClient("123");
            ApiResponse<MovieQuotes>  testResponse = null;
            try {
                when(httpClient.execute(any(HttpGet.class))).thenReturn(response);
                Type returnType = (new TypeToken<MovieQuotes>() {
                }).getType();
                testResponse = client.get(new GetMovieQuotesRequest("123"), returnType);
            } catch (IOException ex) {
                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));
                Assert.assertTrue(errors.toString(), false);
            } catch (SdkException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                Assert.assertTrue(errors.toString(), false);
            }


            Assert.assertTrue(testResponse.getStatusCode() == 200);
            Assert.assertEquals(testResponse.getData().getPages(), 1);
            Assert.assertEquals(testResponse.getData().getLimit(), 1);
            Assert.assertEquals(testResponse.getData().getTotal(), 1);
            Assert.assertEquals(testResponse.getData().getOffset(), 1);
            Assert.assertEquals(testResponse.getData().getDocs().size(), 1);
        }
    }


    private boolean checkQueryParamValue(URL url, String key, String value) {
        return url.getQuery().indexOf(key + "=" + value) != -1;
    }
}
