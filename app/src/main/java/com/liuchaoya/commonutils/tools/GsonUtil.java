package com.liuchaoya.commonutils.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 可将后台返回的字段值为null的值替换为空字符串""
 * Created by LiuChaoya on 2017/11/15 16:59.
 * email  1090969255@qq.com
 */

public class GsonUtil {
    private static final byte[] instanceLock = new byte[0];
    private static Gson instance;
    private GsonUtil() {
        //TODO 私有构造器，防止new实例调用
    }
    public static Gson getInstance() {
        if (instance == null) {
            synchronized (instanceLock) {
                if (instance == null) {
                    instance = new GsonBuilder()
                            .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                            .create();
                }
            }
        }
        return instance;
    }
}
