
# LOTR SDK

A java sdk to help you make API calls as listed on https://the-one-api.dev/documentation. 
This project only provides support for /movie endpoint


## How to use this sdk

Add the following repository to the repositories section of your pom.xml file in your maven project
```bash 
    <repository>
      <id>github</id>
      <url>https://olufemithompson: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@maven.pkg.github.com/olufemithompson/olufemithompson_lotr_sdk</url>
    </repository>
```

Add the following  dependency to your pom.xml file in your maven project
```bash 
    <dependency>
      <groupId>com.liblab</groupId>
      <artifactId>lotrsdk</artifactId>
      <version>0.0.1</version>
    </dependency>
```




## Sample API calls

Initialize the API Object
```bash 
MovieAPI movieApi = new MovieAPI("api-key");
```


Get movies with provided ID
```bash 
GetMovieRequest getMovieRequest = new GetMovieRequest("movie-id")
ApiResponse<Movies> response = movieApi.getMovie(getMovieRequest);
```



Get all movies with pagination parameters
```bash 
GetMoviesRequest getMoviesRequest = GetMoviesRequest
                .create()
                .withLimit(10)
                .withPage(1)
                .withOffset(1)
ApiResponse<Movies> response = movieApi.getMovies(getMoviesRequest);
```


Get all movies by specifying sorting
```bash 
GetMoviesRequest getMoviesRequest = GetMoviesRequest
                .create()
                .withSort("name", SortDirection.SORT_ASC)
ApiResponse<Movies> response = movieApi.getMovies(getMoviesRequest);
```


Get all movies with filters
```bash 
GetMoviesRequest getMoviesRequest = GetMoviesRequest
                .create()
                .whereFieldIsLessThanOrEqual("academyAwardWins","4")
ApiResponse<Movies> response = movieApi.getMovies(getMoviesRequest);
```
