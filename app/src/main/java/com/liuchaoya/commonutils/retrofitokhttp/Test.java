package com.liuchaoya.commonutils.retrofitokhttp;

import android.support.v4.util.ArrayMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 网络请求例子
 * Created by LiuChaoya on 2017/11/29 16:22.
 * email  1090969255@qq.com
 */

public class Test {

    private static Map<String, String> mMapParams;

    public static void main(String[] args) {
        HttpManager.IP = "http://**.**.**.**:8080/";
        try {
            String mNameed = URLEncoder.encode("yzqy020737", "GBK");
            String mPwded = URLEncoder.encode("1", "GBK");
            mMapParams = new ArrayMap<>();
            mMapParams.put("api_method","c.login");
            mMapParams.put("login_name",mNameed);
            mMapParams.put("login_pwd",mPwded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TestPresenter presenter = new TestPresenter();
        presenter.uploadData(mMapParams,1);
    }
}
