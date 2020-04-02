package com.example.practice.views

import android.content.Context
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView

class AppTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        if (!isInEditMode) {
            //Util.setTypeface( attrs, this );
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {

        if (!isInEditMode) {
            //Util.setTypeface( attrs, this );
        }
    }
}
