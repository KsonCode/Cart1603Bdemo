package com.example.kson.cart1603bdemo.view;

import com.example.kson.cart1603bdemo.bean.CartBean;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/21
 * Description:
 */
public interface IcartView {
    void success(CartBean cartBean);//请求成功
    void failure(String msg);//请求失败
}
