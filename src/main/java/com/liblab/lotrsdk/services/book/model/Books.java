package com.liblab.lotrsdk.services.book.model;

import com.google.gson.annotations.SerializedName;
import com.liblab.lotrsdk.BaseListModel;
import lombok.Getter;

import java.util.List;

/**
 * Model that represents list of books returned from API.
 */
@Getter
public class Books extends BaseListModel {
    @SerializedName("docs")
    List<Book> docs;
}
