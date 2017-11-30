package com.liuchaoya.commonutils.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class ContextUtils {
    private static LayoutInflater inflater;
    public static View inflate(Context context, int res){
        if(inflater==null) {
             inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res,null);
    }

}
