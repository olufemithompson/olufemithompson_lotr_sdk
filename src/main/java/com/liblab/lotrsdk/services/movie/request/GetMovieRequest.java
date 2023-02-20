package com.liblab.lotrsdk.services.movie.request;

import com.liblab.lotrsdk.ApiRequest;
import lombok.NonNull;

/**
 * Represents Http request for getting a movie
 */
public class GetMovieRequest extends ApiRequest {
    public GetMovieRequest(@NonNull String id) {
        super();
        this.setEndpoint(String.format("/movie/%s",id));
    }

}
