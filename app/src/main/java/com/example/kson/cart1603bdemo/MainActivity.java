package com.example.kson.cart1603bdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kson.cart1603bdemo.bean.CartBean;
import com.example.kson.cart1603bdemo.common.Constants;
import com.example.kson.cart1603bdemo.presenter.CartPresenter;
import com.example.kson.cart1603bdemo.utils.OkHttpUtils;
import com.example.kson.cart1603bdemo.utils.RequestCallback;
import com.example.kson.cart1603bdemo.view.IcartView;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements IcartView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 添加购物车
     * @param view
     */
    public void add(View view) {

//        HashMap<String,String> params = new HashMap<>();
//        params.put("uid","71");
//        params.put("pid","100");
//        OkHttpUtils.getInstance().postData(Constants.ADD_CART, params, new RequestCallback() {
//            @Override
//            public void failure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                try {
//                    final String result = response.body().string();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

    }

    /**
     * 查询购物车
     * @param view
     */
    public void search(View view) {



//        HashMap<String,String> params = new HashMap<>();
//        params.put("uid","71");
//
//        OkHttpUtils.getInstance().postData(Constants.GETCARTS, params, new RequestCallback() {
//            @Override
//            public void failure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                try {
//                    String jsonResult = response.body().string();
//                    parseCarts(jsonResult);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        startActivity(new Intent(this,CartActivity.class));

    }

    /**
     * 解析购物车数据
     * @param jsonResult
     */
    private void parseCarts(String jsonResult) {

    }

    /**
     * 请求成功后，刷新购物车列表
     * @param cartBean
     */
    @Override
    public void success(CartBean cartBean) {

    }

    /**
     * 失败后，toast友好提示
     * @param msg
     */
    @Override
    public void failure(String msg) {

    }
}
