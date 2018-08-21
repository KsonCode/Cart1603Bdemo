package com.example.kson.cart1603bdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.kson.cart1603bdemo.R;
import com.example.kson.cart1603bdemo.bean.CartBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/21
 * Description:
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context mContext;
    private List<CartBean.DataBean> cartList;
    public CartAdapter(Context context, List<CartBean.DataBean> list) {
        mContext = context;
        cartList = list;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.cart_item_layout,parent,false);
        CartViewHolder viewHolder = new CartViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartBean.DataBean bean = cartList.get(position);

        holder.nameTv.setText(bean.getSellerName());

        holder.productXRV.setLayoutManager(new LinearLayoutManager(mContext));
        holder.productXRV.setAdapter(new ProductAdapter(mContext,bean.getList()));


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private TextView nameTv;
        private XRecyclerView productXRV;
        public CartViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.sellerCheckbox);
            nameTv = itemView.findViewById(R.id.sellerNameTv);
            productXRV = itemView.findViewById(R.id.productXRV);
        }
    }
}
