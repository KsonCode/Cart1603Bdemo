package com.example.kson.cart1603bdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.kson.cart1603bdemo.bean.CartBean;
import com.example.kson.cart1603bdemo.common.Constants;
import com.example.kson.cart1603bdemo.presenter.CartPresenter;
import com.example.kson.cart1603bdemo.view.IcartView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

public class CartActivity extends AppCompatActivity implements IcartView{

    private CartPresenter cartPresenter;
    private XRecyclerView xRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initView();

        initData();
    }

    /**
     * 初始化view
     */
    private void initView() {

        xRecyclerView = findViewById(R.id.cartGV);
        //设置线性布局管理器，listview的列表样式
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    /**
     *  初始化数据
     */
    private void initData() {
        HashMap<String,String> params = new HashMap<>();
        params.put("uid","71");

        cartPresenter = new CartPresenter(this);
        cartPresenter.getCarts(params, Constants.GETCARTS);

    }

    /**
     * 刷新购物车列表
     * @param cartBean
     */
    @Override
    public void success(CartBean cartBean) {

        // TODO: 2018/8/21 展示列表数据



    }

    /**
     * 失败提示
     * @param msg
     */
    @Override
    public void failure(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
