package com.nguyenvanquan7826.viewdrawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;

/**
 * Created by nguyenvanquan7826 on 7/23/17
 */

class BaseView {
    Drawable drawableLeft = null;
    Drawable drawableRight = null;
    Drawable drawableBottom = null;
    Drawable drawableTop = null;
    Typeface tf;

    void init(TypedArray a, Context context) {

        int colorFilter = a.getColor(R.styleable.TextViewDrawable_colorFilter, 0xffffffff);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            drawableLeft = a.getDrawable(R.styleable.TextViewDrawable_drawableLeftCompat);

            drawableRight = a.getDrawable(R.styleable.TextViewDrawable_drawableRightCompat);

            drawableTop = a.getDrawable(R.styleable.TextViewDrawable_drawableTopCompat);

            drawableBottom = a.getDrawable(R.styleable.TextViewDrawable_drawableBottomCompat);

        } else {
            final int drawableLeftId = a.getResourceId(R.styleable.TextViewDrawable_drawableLeftCompat, -1);

            final int drawableRightId = a.getResourceId(R.styleable.TextViewDrawable_drawableRightCompat, -1);

            final int drawableTopId = a.getResourceId(R.styleable.TextViewDrawable_drawableTopCompat, -1);

            final int drawableBottomId = a.getResourceId(R.styleable.TextViewDrawable_drawableBottomCompat, -1);

            if (drawableLeftId != -1) {
                drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId);
            }

            if (drawableRightId != -1) {
                drawableRight = AppCompatResources.getDrawable(context, drawableRightId);
            }

            if (drawableTopId != -1) {
                drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
            }

            if (drawableBottomId != -1) {
                drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
            }
        }

        if (drawableLeft != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft.mutate().setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN);
            } else {
                DrawableCompat.setTint(drawableLeft, colorFilter);
            }
        }

        if (drawableRight != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawableRight.mutate().setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN);
            } else {
                DrawableCompat.setTint(drawableRight, colorFilter);
            }
        }


        if (drawableTop != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawableTop.mutate().setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN);
            } else {
                DrawableCompat.setTint(drawableTop, colorFilter);
            }
        }

        if (drawableBottom != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawableBottom.mutate().setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN);
            } else {
                DrawableCompat.setTint(drawableBottom, colorFilter);
            }
        }

        String fontName = a.getString(R.styleable.TextViewDrawable_font_name);
        if (!TextUtils.isEmpty(fontName)) {
            tf = Typeface.createFromAsset(context.getAssets(), "fonts/".concat(fontName));
        }

    }
}
