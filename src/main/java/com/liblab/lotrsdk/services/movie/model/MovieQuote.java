package com.liblab.lotrsdk.services.movie.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Model that represents a movie quote object returned from API.
 *
 */
@Getter
public class MovieQuote {

  @SerializedName("_id")
  String id;

  @SerializedName("dialog")
  String dialog;

  @SerializedName("movie")
  String movie;

  @SerializedName("character")
  String character;


}
