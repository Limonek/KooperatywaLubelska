package com.example.kooperatywalubelska.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.database.OrderDetail;
import com.example.kooperatywalubelska.database.OrderDetailDao;
import com.example.kooperatywalubelska.database.Product;

import java.util.List;
import java.util.concurrent.Executors;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {
    private List<Product> dataset;
    private View.OnClickListener onClickListener;
    Integer orderId;
    OrderDetailDao orderDetailDao;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    public ProductRecyclerViewAdapter(List<Product> dataset, OrderDetailDao orderDetailDao) {
        this.dataset = dataset;
        this.orderDetailDao = orderDetailDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = dataset.get(position);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orderId != null) {
                    OrderDetail orderDetail = new OrderDetail( 1, product.getId(), 1, orderId);
                    Executors.newSingleThreadExecutor().execute(() -> orderDetailDao.save(orderDetail));
                }
            }
        });
        holder.textView.setText(product.getName());
    }

    void setList(List<Product> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (dataset == null)
            return 0;
        return dataset.size();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}

