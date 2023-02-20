package com.liblab.lotrsdk.services.movie.model;

import com.google.gson.annotations.SerializedName;
import com.liblab.lotrsdk.BaseListModel;
import lombok.Getter;

import java.util.List;

/**
 * Model that represents list of  movie quote objects returned from API.
 *
 */
@Getter
public class MovieQuotes extends BaseListModel {

    @SerializedName("docs")
    List<MovieQuote> docs;

}
