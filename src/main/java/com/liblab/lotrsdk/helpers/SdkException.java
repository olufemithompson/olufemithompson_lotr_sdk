package com.liblab.lotrsdk.helpers;

/**
 * Default exception class that encapsulates
 * all exception thrown when using sdk.
 */
public class SdkException extends Exception{
    public SdkException(String message){
        super(message);
    }

}
