package com.huyva.base.utils;

import org.hashids.Hashids;

public class HashUtils {

    private static Hashids hashids;

    public static void setHashids(String key){
        hashids =  new Hashids(key, 8);

    }

    public static String hashId(Long id){
        return hashids.encode(id);
    }

    public static Long decode(String value){
        return hashids.decode(value)[0];
    }



}
