package com.liuchaoya.commonutils.tools;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * Created by LiuChaoya on 2017/11/15 16:51.
 * email  1090969255@qq.com
 */

public class NullStringToEmptyAdapterFactory implements TypeAdapterFactory {

    @Override
    public TypeAdapter create(Gson gson, TypeToken type) {
        Class rawType = (Class) type.getRawType();
        if (rawType != String.class) {
            return null;
        }
        return new StringNullAdapter();
    }
}
