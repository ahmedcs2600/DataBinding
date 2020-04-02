package com.example.practice.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.practice.App
import com.example.practice.ui.activities.MainActivity
import com.example.practice.utils.replaceFragment
import com.example.practice.viewmodel.BaseViewModel

abstract class BaseFragment : Fragment() {

    abstract val mViewModel : BaseViewModel?

    private val mBaseActivity: BaseActivity
        get() = activity as BaseActivity

    val app : App
    get() = mBaseActivity.app

    private val mActivity : MainActivity
    get() = activity as MainActivity

    protected fun changeFragment(mFragment: Fragment,tag : String?) {
        mBaseActivity.replaceFragment(mFragment,tag)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel?.let {
            it.mLoadingLiveData.observe(viewLifecycleOwner, Observer { state ->
                mBaseActivity.setLoadingState(state)
            })
        }
    }
}