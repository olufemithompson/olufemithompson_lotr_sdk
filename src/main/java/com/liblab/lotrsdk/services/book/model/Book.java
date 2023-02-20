package com.liblab.lotrsdk.services.book.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Model that represents a book object returned from API.
 *
 */
@Getter
public class Book {
    @SerializedName("_id")
    String id;

    @SerializedName("name")
    String name;
}
