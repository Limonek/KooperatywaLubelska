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

import java.util.List;
import java.util.concurrent.Executors;

public class OrderDetailRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {
    private List<OrderDetail> dataset;
    private View.OnClickListener onClickListener;
    OrderDetailDao orderDetailDao;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    public OrderDetailRecyclerViewAdapter(List<OrderDetail> dataset, OrderDetailDao orderDetailDao) {
        this.dataset = dataset;
        this.orderDetailDao = orderDetailDao;
    }

    @NonNull
    @Override
    public ProductRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
        ProductRecyclerViewAdapter.ViewHolder viewHolder = new ProductRecyclerViewAdapter.ViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewAdapter.ViewHolder holder, int position) {
        OrderDetail orderDetail = dataset.get(position);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Executors.newSingleThreadExecutor().execute(() -> orderDetailDao.deleteOrderDetail(orderDetail.getId()));
                }
            }
        );
        String orderDetailInformation = orderDetail.getProductName() + " " + orderDetail.getQuantity();
        holder.textView.setText(orderDetailInformation);
    }

    void setList(List<OrderDetail> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (dataset == null)
            return 0;
        return dataset.size();
    }
}
