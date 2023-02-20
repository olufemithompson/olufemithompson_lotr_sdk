package com.liblab.lotrsdk.services.movie.request;

import com.liblab.lotrsdk.BaseListApiRequest;

/**
 * Represents Http request for getting a list of movies
 */
public class GetMoviesRequest extends BaseListApiRequest {
    public GetMoviesRequest() {
        super();
        this.setEndpoint("/movie");
    }
    public static GetMoviesRequest create(){
        return new GetMoviesRequest();
    }

}
