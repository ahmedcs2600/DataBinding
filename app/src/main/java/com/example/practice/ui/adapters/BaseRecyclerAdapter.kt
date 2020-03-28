package com.example.practice.ui.adapters
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.ui.viewholder.BaseViewHolder

abstract class BaseRecyclerAdapter<DS ,VH : BaseViewHolder>() : RecyclerView.Adapter<VH>(){
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(position)
    }
}