package com.example.prit.silverlabsdemoapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.prit.silverlabsdemoapp.BR;
import com.example.prit.silverlabsdemoapp.R;
import com.example.prit.silverlabsdemoapp.databinding.ItemDataBinding;
import com.example.prit.silverlabsdemoapp.model.DataModel;
import com.example.prit.silverlabsdemoapp.viewmodel.DataItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private static final String TAG = "DataAdapter";
    private List<DataModel> data;

    public DataAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataModel dataModel = data.get(position);
        holder.setViewModel(new DataItemViewModel(dataModel), position);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<DataModel> data) {
        //if (data == null || data.isEmpty()) {
            this.data.clear();
        //} else {
            this.data.addAll(data);
        //}
        notifyDataSetChanged();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        ItemDataBinding binding;

        DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        void setViewModel(DataItemViewModel viewModel, Integer position) {
            if (binding != null) {
                binding.setViewModel(viewModel);
                binding.setVariable(BR.position, position);
            }
        }
    }
}
