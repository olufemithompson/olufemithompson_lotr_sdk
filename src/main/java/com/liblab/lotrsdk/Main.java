package com.liblab.lotrsdk;

import com.liblab.lotrsdk.helpers.OrderingDirection;
import com.liblab.lotrsdk.services.movie.MovieAPI;
import com.liblab.lotrsdk.services.movie.model.Movie;
import com.liblab.lotrsdk.services.movie.model.Movies;
import com.liblab.lotrsdk.services.movie.request.GetMoviesRequest;

import java.util.List;

public class Main {

    public static void main(String[] args){




        MovieAPI movieApi = new MovieAPI("4-zJs6UFGmJNxPwUZ-fc");
//
//        GetMovieQuotesRequest getMovieRequest = GetMovieQuotesRequest
//                .create("5cd95395de30eff6ebccde5b")
//                .withLimit(100)
//                .withOffset(0);
//
//
//                new GetMovieQuotesRequest("5cd95395de30eff6ebccde5b");
//        ApiResponse<MovieQuotes> response = movieApi.getMovieQuotes(getMovieRequest);
//
//        List<MovieQuote>  quotes = response.getData().getDocs();
//        for(MovieQuote quote : quotes){
//            System.out.println(quote.getId()+ "\t" + quote.getMovie());
//        }



//        GetMovieRequest getMovieRequest = new GetMovieRequest("5cd95395de30eff6ebccde5b");
//        ApiResponse<Movies> response = movieApi.getMovie(getMovieRequest);

        GetMoviesRequest getBooksRequest = GetMoviesRequest
                .create()
                .whereFieldIsLessThanOrEqual("academyAwardWins","4")
                .withSort("name", OrderingDirection.SORT_ASC)
                ;

        ApiResponse<Movies> response = movieApi.getMovies(getBooksRequest);



        List<Movie> movies = response.getData().getDocs();
        for(Movie movie : movies){
            System.out.println(movie.getId()+ "\t" + movie.getName() + "\t"+movie.getAcademyAwardWins());
        }



    }
}
