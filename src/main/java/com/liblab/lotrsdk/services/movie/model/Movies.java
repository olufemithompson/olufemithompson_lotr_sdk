package com.liblab.lotrsdk.services.movie.model;

import com.google.gson.annotations.SerializedName;
import com.liblab.lotrsdk.BaseListModel;
import lombok.Getter;

import java.util.List;

/**
 * Model that represents list of  movie  objects returned from API.
 *
 */
@Getter
public class Movies  extends BaseListModel {

    @SerializedName("docs")
    List<Movie> docs;

}
