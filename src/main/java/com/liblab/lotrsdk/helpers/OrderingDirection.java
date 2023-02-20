package com.liblab.lotrsdk.helpers;

/**
 * Enum class used to specify acceptable ordering directions
 * when making api request that allows ordering
 */
public enum OrderingDirection {

    //sorting direction constants
    SORT_DESC("desc"),
    SORT_ASC("asc");

    String value;
    OrderingDirection(String val){
        this.value = val;
    }

    public String getValue(){
        return this.value;
    }

}
