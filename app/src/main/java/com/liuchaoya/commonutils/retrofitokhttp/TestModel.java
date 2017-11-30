package com.liuchaoya.commonutils.retrofitokhttp;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by LiuChaoya on 2017/11/29 16:22.
 * email  1090969255@qq.com
 */

public class TestModel {

    public void uploadData(Map<String, String> params, Callback<ResponseBody> mCallback) {
        Call<ResponseBody> call = HttpManager.getRetrofit().HttpUploadData(params);
        call.enqueue(mCallback);
    }
}
