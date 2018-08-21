package com.example.kson.cart1603bdemo.model;

import android.text.TextUtils;

import com.example.kson.cart1603bdemo.bean.CartBean;
import com.example.kson.cart1603bdemo.utils.OkHttpUtils;
import com.example.kson.cart1603bdemo.utils.RequestCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/21
 * Description:
 */
public class CartModel {

    /**
     * 请求购物车数据
     *
     * @param params 参数
     * @param url    请求url
     */
    public void getCarts(HashMap<String, String> params, String url, final CartCallback cartCallback) {

        OkHttpUtils.getInstance().postData(url, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {

                if (cartCallback != null) {
                    cartCallback.fail("网络有异常，请稍后再试");
                }

            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    String jsonResult = response.body().string();
                    if (!TextUtils.isEmpty(jsonResult)) {

                        parseResult(jsonResult, cartCallback);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 解析购物车数据
     *
     * @param jsonResult
     * @param cartCallback
     */
    private void parseResult(String jsonResult, CartCallback cartCallback) {
        CartBean cartBean = new Gson().fromJson(jsonResult, CartBean.class);
        if (cartCallback != null && cartBean != null) {//代码规范，代码优化
            cartCallback.success(cartBean);
        }


    }

    public interface CartCallback {
        void success(CartBean cartBean);//回调bean对象给presenter

        void fail(String msg);//异常信息回调
    }
}
