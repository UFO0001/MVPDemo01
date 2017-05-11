package com.demo.mvpdemo01.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mvpdemo01.Application.MyApplication;
import com.demo.mvpdemo01.R;

/**
 * Created by UFO on 17/5/11.
 */

public class AllToast {

    public static final int GRAVITY_TOP = 2;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_BOTTOM = 0;
    public static final int TOAST_SHORT = 0;
    public static final int TOAST_LONG = 1;

    private Context mContext;
    private Toast allToast;

    public AllToast(Context context){
        mContext = context;
    }

    public void toastShow(Builder builder){
        if (allToast == null){
            allToast = new Toast(mContext);
        }
        //toast的位置
        if(builder.mGravity == GRAVITY_CENTER){
            allToast.setGravity(GRAVITY_CENTER| Gravity.CENTER_VERTICAL,0,0);
        }else if(builder.mGravity == GRAVITY_TOP){
            allToast.setGravity(Gravity.TOP|Gravity.CENTER_VERTICAL,0,Tools.dip2px(mContext,20));// 根据手机的分辨率从 dp 的单位 转成为 px(像素)
        }else{
            allToast.setGravity(Gravity.BOTTOM|Gravity.CENTER_VERTICAL,0,Tools.dip2px(mContext,20));
        }

        if(builder.mDuration == TOAST_LONG){
            allToast.setDuration(Toast.LENGTH_LONG);
        }else{
            allToast.setDuration(Toast.LENGTH_SHORT);
        }

        if(builder.hasCustomerView&&builder.mCustomerView!=null){
            allToast.setView(builder.mCustomerView);
        }else{
            allToast.setView(builder.mDefaultView);
        }
        allToast.show();

    }
    /**
     * Toast的显示样式
     */
    public static class Builder{
        private View mDefaultView;
        private View mCustomerView;
        private ImageView mIvImage;
        private TextView mTvFirst,mTvSecond;
        private View dividerFirst;
        private View dividerSecond;
        private int mDuration = TOAST_SHORT;//0:short 1:long
        private int mGravity = 0;
        private boolean hasCustomerView = false;//是否自定义layout
        /**
         * 使用全局的ApplicationContext进行初始化
         */
        public Builder(Context context){
            mDefaultView = LayoutInflater.from(context).inflate(R.layout.layout_alltoast,null);
            mIvImage = (ImageView) mDefaultView.findViewById(R.id.iv_img_allToast);
            mTvFirst = (TextView) mDefaultView.findViewById(R.id.tv_text_first_allToast);
            mTvSecond = (TextView) mDefaultView.findViewById(R.id.tv_text_second_allToast);
            dividerFirst = mDefaultView.findViewById(R.id.divider_first);
            dividerSecond = mDefaultView.findViewById(R.id.divider_second);
        }
        public Builder setImageResource(int id){
            this.mIvImage.setImageResource(id);
            this.mIvImage.setVisibility(View.VISIBLE);
            this.dividerFirst.setVisibility(View.VISIBLE);
            return this;
        }
        public Builder setFirstText(String firstText){
            this.mTvFirst.setText(firstText);
            this.mTvFirst.setVisibility(View.VISIBLE);
            this.dividerSecond.setVisibility(View.VISIBLE);
            return this;
        }
        public Builder setSecondText(String secendText){
            this.mTvSecond.setText(secendText);
            this.mTvSecond.setVisibility(View.VISIBLE);
            return this;
        }
        public Builder setDuration(int duration){
            this.mDuration = duration;
            return this;
        }
        public Builder setGravity(int gravity){
            this.mGravity = gravity;
            return this;
        }

        /**
         * 为Toast指定自定义的layout 此时上面对ImageView和textView的设置失效
         * @param customerView
         * @return
         */
        public Builder setCustomerView(View customerView){
            this.mCustomerView =customerView;
            this.hasCustomerView = true;
            return this;
        }
    }
}
