package com.liuchaoya.commonutils.retrofitokhttp;


import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * service统一接口数据
* Created By LiuChaoya
* On 2017/11/29
* For Myself
*/

public interface HttpService{

    /**
     * 版本更新 下载apk
     * @return
     */
    @GET
    Call<ResponseBody> HttpUpdateApk(@Url String mUrl);


    /**
     * 数据上传
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("接口地址")
    Call<ResponseBody> HttpUploadData(@FieldMap(encoded = true) Map<String, String> params);


    /**
     * 图片上传
     * @return
     */
    @Multipart
    @POST("接口地址")
    Call<ResponseBody> httpImg(@PartMap() Map<String, RequestBody> partMap, @Part MultipartBody.Part file);

}
