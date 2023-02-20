package com.liblab.lotrsdk.services.book.request;

import com.liblab.lotrsdk.BaseListApiRequest;


/**
 * Represents Http request for getting books.
 */
public class GetBooksRequest extends BaseListApiRequest {
    public GetBooksRequest() {
        super();
        this.setEndpoint("/book");
    }

    public static GetBooksRequest create(){
        return new GetBooksRequest();
    }

}
