package com.liblab.lotrsdk.services.movie.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Model that represents a movie object returned from API.
 *
 */
@Getter
public class Movie {

  @SerializedName("_id")
  String id;

  @SerializedName("name")
  String name;

  @SerializedName("runtimeInMinutes")
  long runtimeInMinutes;

  @SerializedName("budgetInMillions")
  double budgetInMillions;

  @SerializedName("boxOfficeRevenueInMillions")
  double boxOfficeRevenueInMillions;

  @SerializedName("academyAwardNominations")
  int academyAwardNominations;

  @SerializedName("academyAwardWins")
  int academyAwardWins;

  @SerializedName("rottenTomatoesScore")
  double rottenTomatoesScore;

}
