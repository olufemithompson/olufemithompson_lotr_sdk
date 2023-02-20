package com.liblab.lotrsdk.services.book;

import com.google.gson.reflect.TypeToken;
import com.liblab.lotrsdk.ApiResponse;
import com.liblab.lotrsdk.helpers.SdkException;
import com.liblab.lotrsdk.BaseAPI;
import com.liblab.lotrsdk.services.book.model.Books;
import com.liblab.lotrsdk.services.book.request.GetBooksRequest;

import java.lang.reflect.Type;

/**
 * API class that provide functions that corresponds to all
 * api request under /book endpoint
 *
 */
public class BookAPI extends BaseAPI {

    public BookAPI(String apiKey) {
        super(apiKey);
    }


    public ApiResponse<Books> getBooks(GetBooksRequest getBooksRequest){
        try {
            Type returnType = (new TypeToken<Books>() {
            }).getType();
            return get(getBooksRequest, returnType);
        } catch (SdkException e) {
            throw new RuntimeException(e);
        }
    }
}
