package com.liblab.lotrsdk.services.movie.request;

import com.liblab.lotrsdk.BaseListApiRequest;
import lombok.NonNull;

/**
 * Represents Http request for getting movie quotes
 */
public class GetMovieQuotesRequest extends BaseListApiRequest {

    public GetMovieQuotesRequest(@NonNull String movieId) {
        super();
        this.setEndpoint(String.format("/movie/%s/quote",movieId));
    }

    public static GetMovieQuotesRequest create(@NonNull String movieId){
        return new GetMovieQuotesRequest(movieId);
    }
}
