package com.liuchaoya.commonutils.retrofitokhttp;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LiuChaoya on 2017/11/29 16:23.
 * email  1090969255@qq.com
 */

public class TestPresenter {
    TestModel model = new TestModel();

    public void uploadData(final Map<String, String> params, final int stype) {
        model.uploadData(params, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
