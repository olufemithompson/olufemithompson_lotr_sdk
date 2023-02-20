package com.liblab.lotrsdk.services.movie;
import com.google.gson.reflect.TypeToken;
import com.liblab.lotrsdk.ApiResponse;
import com.liblab.lotrsdk.helpers.SdkException;
import com.liblab.lotrsdk.BaseAPI;
import com.liblab.lotrsdk.services.movie.model.MovieQuotes;
import com.liblab.lotrsdk.services.movie.model.Movies;
import com.liblab.lotrsdk.services.movie.request.GetMovieQuotesRequest;
import com.liblab.lotrsdk.services.movie.request.GetMovieRequest;
import com.liblab.lotrsdk.services.movie.request.GetMoviesRequest;

import java.lang.reflect.Type;


/**
 * API class that provide functions that corresponds to all
 * api request under /movie endpoint
 *
 */
public class MovieAPI extends BaseAPI {

    public MovieAPI(String apiKey) {
        super(apiKey);
    }

    public ApiResponse<Movies> getMovie(GetMovieRequest getMovieRequest){
        try {
            Type returnType = (new TypeToken<Movies>() {
            }).getType();
            return get(getMovieRequest, returnType);
        } catch (SdkException e) {
            throw new RuntimeException(e);
        }
    }

    public ApiResponse<Movies> getMovies(GetMoviesRequest getMoviesRequest){
        try {
            Type returnType = (new TypeToken<Movies>() {
            }).getType();
            return get(getMoviesRequest, returnType);
        } catch (SdkException e) {
            throw new RuntimeException(e);
        }
    }


    public ApiResponse<MovieQuotes> getMovieQuotes(GetMovieQuotesRequest getMovieQuotesRequest){
        try {
            Type returnType = (new TypeToken<MovieQuotes>() {
            }).getType();
            return get(getMovieQuotesRequest, returnType);
        } catch (SdkException e) {
            throw new RuntimeException(e);
        }
    }

}
