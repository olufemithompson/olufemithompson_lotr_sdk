package com.liblab.lotrsdk;

import com.liblab.lotrsdk.helpers.OrderingDirection;
import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class BaseListApiRequest extends ApiRequest {

    public BaseListApiRequest() {
       super();
    }


    //pagination query params
    public  <T extends BaseListApiRequest> T  withLimit(@NonNull Integer limit){
        this.addQueryParam("limit", limit.toString());
        return (T)this;
    }

    public  <T extends BaseListApiRequest> T  withPage(@NonNull Integer page){
        this.addQueryParam("page", page.toString());
        return (T)this;
    }

    public  <T extends BaseListApiRequest> T  withOffset(@NonNull Integer offset){
        this.addQueryParam("offset", offset.toString());
        return (T)this;
    }



    //sorting params
    public <T extends BaseListApiRequest> T  withSort(@NonNull  String sortField, OrderingDirection sortDirection ){
        this.addQueryParam("sort", sortField+":"+sortDirection.getValue());
        return (T)this;
    }


    //filtering params
    public <T extends BaseListApiRequest> T  whereFieldEquals(@NonNull  String field, @NonNull String value){
        this.addQueryParam(field, value);
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldNotEquals(@NonNull  String field, @NonNull String value){
        this.addQueryParam(field+"!", value);
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldIncludes(@NonNull  String field, @NonNull String... values){
        this.addQueryParam(field, Arrays.stream(values).collect(Collectors.joining(",")));
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldExcludes(@NonNull  String field, @NonNull String... values){
        this.addQueryParam(field+"!", Arrays.stream(values).collect(Collectors.joining(",")));
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldExist(@NonNull  String field){
        this.addQueryParam(field, "");
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldDoesntExist(@NonNull  String field){
        this.addQueryParam("!"+field, "");
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldHasRegex(@NonNull  String field, @NonNull  String regex){
        this.addQueryParam(field, regex);
        return (T)this;
    }


    public <T extends BaseListApiRequest> T  whereFieldIsGreaterThan(@NonNull  String field, @NonNull  String value){
        this.addQueryParam(field+">"+value, "");
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldIsGreaterThanOrEqual(@NonNull  String field, @NonNull  String value){
        this.addQueryParam(field+">="+value, "");
        return (T)this;
    }
    public <T extends BaseListApiRequest> T  whereFieldIsLessThan(@NonNull  String field, @NonNull  String value){
        this.addQueryParam(field+"<"+value, "");
        return (T)this;
    }

    public <T extends BaseListApiRequest> T  whereFieldIsLessThanOrEqual(@NonNull  String field, @NonNull  String value){
        this.addQueryParam(field+"<="+value, "");
        return (T)this;
    }

}
