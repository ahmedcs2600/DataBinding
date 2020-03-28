package com.example.practice.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.R
import com.example.practice.base.BaseFragment
import com.example.practice.callback.ItemClickListener
import com.example.practice.databinding.FragmentProjectListBinding
import com.example.practice.models.Project
import com.example.practice.ui.adapters.ProjectAdapter
import com.example.practice.viewmodel.BaseViewModel
import com.example.practice.viewmodel.ProjectListViewModel

class ProjectListFragment : BaseFragment() {

    private lateinit var binding: FragmentProjectListBinding

    private val viewModel by viewModels<ProjectListViewModel>()

    private lateinit var mAdapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        DataBindingUtil.inflate<FragmentProjectListBinding>(
            inflater,
            R.layout.fragment_project_list,
            container,
            false
        ).also {
            binding = it
        }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.getProjectList().observe(this, Observer {
            it?.let {
                mAdapter.updateList(it)
            }
        })
    }

    private fun setUpAdapter() {
        mAdapter = ProjectAdapter(object : ItemClickListener<Project> {
            override fun onClick(item: Project) {
                changeFragment(ProjectDetailFragment.newInstance(item.id.toString()),ProjectDetailFragment::class.java.simpleName)
            }
        })
        with(binding) {
            with(rvList) {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProjectListFragment()
    }

    override val mViewModel: BaseViewModel
        get() = viewModel
}
