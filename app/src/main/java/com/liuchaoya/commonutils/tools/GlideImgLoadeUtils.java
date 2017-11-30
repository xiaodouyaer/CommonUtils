package com.liuchaoya.commonutils.tools;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.liuchaoya.commonutils.R;

import java.io.File;


public class GlideImgLoadeUtils {


    //加载网络图片
    public static void   setHttpImg(Context context, String url, ImageView iv_img){
        if((iv_img.getTag() == null) || (!iv_img.getTag().equals(url))){

//            RequestOptions requestOptions = new RequestOptions()
//                    .placeholder(R.mipmap.placeholder) //加载中图片
//                    .error(R.mipmap.error) //加载失败图片
//                    .fallback(R.mipmap.fallback) //url为空图片
//                    .centerCrop() // 填充方式
//                    .override(600,600) //尺寸
//                    .transform(new CircleCrop()) //圆角
//                    .priority(Priority.HIGH) //优先级
//                    .diskCacheStrategy(DiskCacheStrategy.NONE); //缓存策略，后面详细介绍

//           TransitionOptions是用来设置占位图片或者缩略图片切换到真正需要加载的图片之间的过度效果。


            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(new ColorDrawable(Color.GRAY))//站位图
                    .error(R.drawable.default_image)//当请求失败的时候，error资源被显示。又或者url为null，而fallback图片没有被设置，那么加载中的图片也将会一直被显示
                    .priority(Priority.HIGH)
                    .centerCrop()//设置图片尺寸，当ImageView为wrap尺寸时有效
//                    .transform(new CircleCrop())//设置圆角图片
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.NONE);


            Glide.with(context)
                    .load(url)
                    .apply(options)
//            .transition(TransitionOptions)
//                    .centerCrop()
                    .thumbnail(0.5f)//缩略图
//                    .placeholder(R.drawable.default_image)
//                    .error(R.drawable.default_image)
//                    .dontAnimate()
//                    .crossFade(1000)

                    .into(iv_img);
        }
        iv_img.setTag(url);
    }
    //加载本地图片
    public static void   setLocalImg(Context context, String url, ImageView iv_img){
        System.out.println("img++++"+url);

        if((iv_img.getTag() == null) || (!iv_img.getTag().equals(url))){

//            Glide.with(context).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT)
//                    .centerCrop().placeholder(R.drawable.default_image)
//                    .into(iv_img);

//            RequestOptions options = new RequestOptions();
//            options.placeholder(R.drawable.default_image);

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(new ColorDrawable(Color.GRAY))//站位图
                    .error(R.drawable.default_image)//当请求失败的时候，error资源被显示。又或者url为null，而fallback图片没有被设置，那么加载中的图片也将会一直被显示
                    .priority(Priority.HIGH)
                    .centerCrop()//设置图片尺寸，当ImageView为wrap尺寸时有效
//                    .transform(new CircleCrop())//设置圆角图片
//            .dontAnimate()
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    ;

            Glide.with(context)
                    .load(new File(url))
                    .apply(options)
//                    .transition(new DrawableTransitionOptions().crossFade(1000)) //淡入淡出1秒
//                    .fitCenter()
//                    .asBitmap()
//                    .placeholder(R.drawable.default_image)
                    .into(iv_img);
        }
        iv_img.setTag(url);
    }

    //加载本地图片
    public static void   setLocalImgRound(Context context, String url, ImageView iv_img){

        if((iv_img.getTag() == null) || (!iv_img.getTag().equals(url))){


            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(new ColorDrawable(Color.GRAY))//站位图
                    .error(R.drawable.default_image)//当请求失败的时候，error资源被显示。又或者url为null，而fallback图片没有被设置，那么加载中的图片也将会一直被显示
                    .priority(Priority.HIGH)
                    .centerCrop()//设置图片尺寸，当ImageView为wrap尺寸时有效
//                    .transform(new CircleCrop())//设置圆角图片
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.NONE);

            Glide.with(context)
                    .load(new File(url))
                    .thumbnail(0.5f)
                    .apply(options)
                    .transition(new DrawableTransitionOptions().crossFade(1000)) //淡入淡出1秒
//                    .bitmapTransform(new GlideRoundTransform(context,10))
//                    .crossFade(1000)
                    .into(iv_img);
        }
        iv_img.setTag(url);
    }


}
