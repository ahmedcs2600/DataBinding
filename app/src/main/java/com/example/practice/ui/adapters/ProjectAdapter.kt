package com.example.practice.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.callback.ItemClickListener
import com.example.practice.databinding.ProjectListItemBinding
import com.example.practice.models.Project


class ProjectAdapter(private val mListener: ItemClickListener<Project>) :
    RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    private val mDataSet: MutableList<Project> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ProjectListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.project_list_item,
            parent,
            false
        ).run {
            ViewHolder(this)
        }


    override fun getItemCount() = mDataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mDataSet[position])
    }


    fun updateList(newData: List<Project>) {
        mDataSet.clear()
        mDataSet.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val mBinding: ProjectListItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        internal fun onBind(project: Project) {
            with(mBinding) {
                data = project
                listener = mListener
            }

        }
    }
}