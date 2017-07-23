package com.nguyenvanquan7826.viewdrawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class EditTextDrawable extends AppCompatEditText {

    public EditTextDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context);
    }

    public EditTextDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, context);
    }

    private void init(AttributeSet attrs, Context context) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextViewDrawable, 0, 0);

            BaseView baseView = new BaseView();
            baseView.init(a, context);
            setCompoundDrawablesWithIntrinsicBounds(
                    baseView.drawableLeft, baseView.drawableTop, baseView.drawableRight, baseView.drawableBottom);

            if (baseView.tf != null) setTypeface(baseView.tf);

            a.recycle();
        }
    }
}