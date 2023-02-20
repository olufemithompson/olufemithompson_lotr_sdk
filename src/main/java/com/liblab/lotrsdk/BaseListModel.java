package com.liblab.lotrsdk;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Base Model for every API response that returns a list of objects, including fields for pagination
 *
 */
@Getter
public class BaseListModel {

    @SerializedName("total")
    int total;

    @SerializedName("limit")
    int limit;

    @SerializedName("offset")
    int offset;

    @SerializedName("page")
    int page;

    @SerializedName("pages")
    int pages;

}
