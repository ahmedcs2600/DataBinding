package com.example.practice.views


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.HeaderMainBinding
import com.example.practice.utils.ViewOnClickListener
import com.example.practice.utils.hide
import com.example.practice.utils.invisible
import com.example.practice.utils.show
import kotlinx.android.synthetic.main.header_main.view.*

class TitleBar : RelativeLayout {

    private var menuButtonListener: ViewOnClickListener? = null
    private var backButtonListener: ViewOnClickListener? = null
    private var notificationButtonListener: ViewOnClickListener? = null


    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLayout(context)
        attrs?.let { initAttrs(context, it) }

    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initLayout(context)
        attrs?.let { initAttrs(context, it) }
    }

    private fun initAttrs(context: Context, attrs: AttributeSet) {}

    private fun initLayout(context: Context) {
        val layoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        DataBindingUtil.inflate<HeaderMainBinding>(
            layoutInflater,
            R.layout.header_main,
            this,
            true
        )


    }

    fun hideButtons() {
        txt_subHead.invisible()
        btnLeft.invisible()
        btnRight.invisible()
        btnRight2.invisible()
        txtBadge.hide()

    }

    fun showBackButton() {
        with(btnLeft) {
            show()
            setOnClickListener(backButtonListener)
        }
    }

    fun showMenuButton() {
        with(btnLeft) {
            show()
            setOnClickListener(menuButtonListener)
            setImageResource(R.drawable.ic_launcher)
        }
    }

    fun setSubHeading(heading: String) {
        with(txt_subHead) {
            show()
            text = heading
        }


    }

    fun showNotificationButton(count: Int) {
        btnRight.invisible()
        with(btnRight2) {
            show()
            setOnClickListener(notificationButtonListener)
            setImageResource(R.drawable.ic_launcher)
        }
        with(txtBadge) {
            if (count > 0) {
                show()
                text = "$count"
            } else {
                hide()
            }
        }


    }

    fun showTitleBar() {
        show()
    }

    fun hideTitleBar() {
        hide()
    }

    fun setMenuButtonListener(listener: ViewOnClickListener) {
        menuButtonListener = listener
    }

    fun setBackButtonListener(listener: ViewOnClickListener) {
        backButtonListener = listener
    }

    fun setNotificationButtonListener(listener: ViewOnClickListener) {
        notificationButtonListener = listener
    }


}