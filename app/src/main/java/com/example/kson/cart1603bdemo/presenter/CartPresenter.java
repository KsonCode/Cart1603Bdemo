package com.example.kson.cart1603bdemo.presenter;

import com.example.kson.cart1603bdemo.CartActivity;
import com.example.kson.cart1603bdemo.bean.CartBean;
import com.example.kson.cart1603bdemo.model.CartModel;
import com.example.kson.cart1603bdemo.view.IcartView;

import java.util.HashMap;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/21
 * Description:购物车逻辑层
 */
public class CartPresenter {

    private CartModel cartModel;
    private  IcartView icartView;

    public CartPresenter(IcartView icartView) {
        cartModel =new CartModel();
        attachView(icartView);

    }

    /**
     * 绑定view到presenter
     * @param icartView
     */
    public void attachView(IcartView icartView){
        this.icartView = icartView;
    }

    public void getCarts(HashMap<String,String> params,String url){

        cartModel.getCarts(params, url, new CartModel.CartCallback() {
            @Override
            public void success(CartBean cartBean) {

                if (icartView!=null){
                    icartView.success(cartBean);
                }

            }

            @Override
            public void fail(String msg) {

                if (icartView!=null){
                    icartView.failure(msg);
                }

            }
        });

    }

    /**
     * 解除绑定，把view和presenter解绑，避免内存泄漏
     */
    public void detachView(){
        this.icartView = null;
    }
}
