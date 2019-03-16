package com.zhaojy.gallery;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private ViewPager mViewPager;
    private View ll_layout;

    //向导界面的图片
    private List<String> mPics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewPager);
        ll_layout = findViewById(R.id.ll_layout);


        mPics.add("http://b-ssl.duitang.com/uploads/item/201805/25/20180525123345_TGxzY.jpeg");
        mPics.add("http://n.sinaimg.cn/sinacn10022/200/w108" +
                "0h720/20181219/4caa-hqnkypr2999634.jpg");
        mPics.add("http://tpic.home.news.cn/xhCloudNewsPic/x" +
                "hpic1501/M04/33/04/wKhTlVhUroyEXqb4AAAAAHKsVuI178.jpg");
        mPics.add("http://b-ssl.duitang.com/uploads/item/201810/12/2018" +
                "1012052451_avkjo.thumb.700_0.jpg");
        mPics.add("http://b-ssl.duitang.com/uploads/item/201608/24/20160824184555_5jcrT.jpeg");
        mPics.add("http://b-ssl.duitang.com/uploads/item/201702/13/20170213125122_NM3A8.jpeg");
        mPics.add("http://b-ssl.duitang.com/uploads/item/201411/28/20141128214635_MHdWt.jpeg");

        //设置适配器
        mViewPager.setAdapter(new MyAdapter(this, mPics));
        mViewPager.setPageMargin(10);
        //mViewPager.setOffscreenPageLimit(mPics.size());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //3D画廊模式

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.e(TAG, i + "");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //左右都有图
        // mViewPager.setCurrentItem(1);

        //viewPager左右两边滑动无效的处理
        ll_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
    }

}
