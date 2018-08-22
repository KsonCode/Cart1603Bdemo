package com.example.kson.cart1603bdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.kson.cart1603bdemo.adapter.CartAdapter;
import com.example.kson.cart1603bdemo.adapter.CartAllCheckboxListener;
import com.example.kson.cart1603bdemo.bean.CartBean;
import com.example.kson.cart1603bdemo.common.Constants;
import com.example.kson.cart1603bdemo.presenter.CartPresenter;
import com.example.kson.cart1603bdemo.utils.SpaceItemDecoration;
import com.example.kson.cart1603bdemo.view.IcartView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

public class CartActivity extends AppCompatActivity implements IcartView,CartAllCheckboxListener{

    private CartPresenter cartPresenter;
    private XRecyclerView xRecyclerView;
    private CartAdapter cartAdapter;
    private List<CartBean.DataBean> list;
    private CheckBox allCheckbox;

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

        list = new ArrayList<>();
        xRecyclerView = findViewById(R.id.cartGV);
        allCheckbox = findViewById(R.id.allCheckbox);
        //设置线性布局管理器，listview的列表样式
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        xRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        cartAdapter = new CartAdapter(this,list);
        cartAdapter.setCartAllCheckboxListener(this);

        allCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){//
                    if (list!=null&&list.size()>0){
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setSelected(true);
                            for (int i1 = 0; i1 < list.get(i).getList().size(); i1++) {
                                list.get(i).getList().get(i1).setSelected(true);
                            }
                        }

                    }
                }else{
                    if (list!=null&&list.size()>0){
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setSelected(false);
                            for (int i1 = 0; i1 < list.get(i).getList().size(); i1++) {
                                list.get(i).getList().get(i1).setSelected(false);
                            }
                        }

                    }
                }

                cartAdapter.notifyDataSetChanged();//全部刷新

            }
        });



//        allCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    for (CartBean.DataBean bean : list) {
//                        bean.setChecked(true);
//                        for (CartBean.DataBean.ListBean listBean : bean.getList()) {
//                            listBean.setChecked(true);
//                        }
//                    }
//                }else{
//                    for (CartBean.DataBean bean : list) {
//                        bean.setChecked(false);
//                        for (CartBean.DataBean.ListBean listBean : bean.getList()) {
//                            listBean.setChecked(false);
//                        }
//                    }
//                }
//                cartAdapter.notifyDataSetChanged();
//            }
//        });

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

        if (cartBean!=null&&cartBean.getData()!=null){

            list = cartBean.getData();

            cartAdapter = new CartAdapter(this,list);

            xRecyclerView.setAdapter(cartAdapter);

//            cartAdapter.notifyDataSetChanged();

        }




    }

    /**
     * 失败提示
     * @param msg
     */
    @Override
    public void failure(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 去结算
     * @param view
     */
    public void buy(View view) {

    }

    /**
     * 全选按钮是否选中的回调
     */
    @Override
    public void notifyAllCheckboxStatus() {

        for (int i = 0; i < list.size(); i++) {
            //一级列表状态
            if (!list.get(i).isSelected()){
                allCheckbox.setChecked(false);
                break;
            }else{
                allCheckbox.setChecked(true);
            }

            for (int i1 = 0; i1 < list.get(i).getList().size(); i1++) {
                if (!list.get(i).getList().get(i1).isSelected()){
                    allCheckbox.setChecked(false);
                    break;
                }
            }


        }

    }
}
