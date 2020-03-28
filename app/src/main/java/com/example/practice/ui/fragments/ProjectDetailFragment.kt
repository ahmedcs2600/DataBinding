package com.example.practice.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.practice.R
import com.example.practice.base.BaseFragment
import com.example.practice.databinding.FragmentProjectDetailBinding
import com.example.practice.viewmodel.BaseViewModel
import com.example.practice.viewmodel.ProjectDetailViewModel


class ProjectDetailFragment : BaseFragment() {

    private val viewModel by viewModels<ProjectDetailViewModel>()

    private lateinit var mBinding: FragmentProjectDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentProjectDetailBinding>(
        inflater,
        R.layout.fragment_project_detail,
        container,
        false
    ).also {
        mBinding = it
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }

    private fun bindViewModel(){
        with(viewModel){
            getProjectByProjectId().observe(this@ProjectDetailFragment, Observer {
                it?.let { project -> setProject(project) }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(mProjectId: String) = ProjectListFragment().apply {
            arguments = Bundle().apply {
                putString(BUNDLE_PROJECT_ID, mProjectId)
            }
        }

        private const val BUNDLE_PROJECT_ID = "bundle_project_id"
    }

    override val mViewModel: BaseViewModel
        get() = viewModel

}
