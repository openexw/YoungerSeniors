package com.openoter.youngerseniors.weight;

import android.content.Context;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.Toolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.openoter.youngerseniors.R;


/**
 * Created by asus on 2016/10/26.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ONToolbar extends Toolbar {
    private LayoutInflater mInflater;

    private View mView;
    private TextView mTextTitle;
    private EditText mSearchView;
    private Button mRightButton;
    private ImageButton mRightButtonIcon;


    public ONToolbar(Context context) {
        this(context,null);
    }

    public ONToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ONToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



        initView();
        setContentInsetsRelative(10,10);




        if(attrs !=null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.ONToolbar, defStyleAttr, 0);


            final Drawable rightIcon = a.getDrawable(R.styleable.ONToolbar_rightButtonIcon);
            if (rightIcon != null) {
                //setNavigationIcon(navIcon);
                setRightButtonIcon(rightIcon);
            }


            boolean isShowSearchView = a.getBoolean(R.styleable.ONToolbar_isShowSearchView,false);

            if(isShowSearchView){

                showSearchView();
                hideTitleView();

            }



            CharSequence rightButtonText = a.getText(R.styleable.ONToolbar_rightButtonText);
            if(rightButtonText !=null){
                setRightButtonText(rightButtonText);
            }



            a.recycle();
        }

    }

    private void initView() {


        if(mView == null) {

            mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.toolbar, null);


            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title);
            mSearchView = (EditText) mView.findViewById(R.id.toolbar_searchview);
            mRightButton = (Button) mView.findViewById(R.id.toolbar_rightButton);
            mRightButtonIcon = (ImageButton) mView.findViewById(R.id.toolbar_rightButton_icon);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);

            addView(mView, lp);
        }



    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void  setRightButtonIcon(Drawable icon){

        if(mRightButtonIcon !=null){

            mRightButtonIcon.setImageDrawable(icon);
            mRightButtonIcon.setVisibility(VISIBLE);
        }

    }

    public void  setRightButtonIcon(int icon){

        setRightButtonIcon(getResources().getDrawable(icon));
    }



    public  void setRightButtonOnClickListener(OnClickListener li){

        mRightButton.setOnClickListener(li);
    }
    public void setRightButtonText(CharSequence text){
        if(mRightButton != null){
            mRightButton.setText(text);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    public void setRightButtonText(int id){
        setRightButtonText(getResources().getString(id));
    }



    public Button getRightButton(){

        return this.mRightButton;
    }



    @Override
    public void setTitle(int resId) {

        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {

        initView();
        if(mTextTitle !=null) {
            mTextTitle.setText(title);
            showTitleView();
        }





    }



    public  void showSearchView(){

        if(mSearchView !=null){
            mSearchView.setVisibility(VISIBLE);
            mSearchView.requestFocus();
        }
    }


    public void hideSearchView(){
        if(mSearchView !=null)
            mSearchView.setVisibility(GONE);
    }

    public void showTitleView(){
        if(mTextTitle !=null)
            mTextTitle.setVisibility(VISIBLE);
    }


    public void hideTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);
    }
}
