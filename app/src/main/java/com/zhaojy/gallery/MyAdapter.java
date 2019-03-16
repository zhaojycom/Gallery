package com.zhaojy.gallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author: zhaojy
 * @data:On 2019/3/16.
 */
public class MyAdapter extends PagerAdapter {

    private List<String> mData;
    private Context mContext;

    public MyAdapter(Context ctx, List<String> data) {
        this.mContext = ctx;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();// 返回数据的个数
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {//子View显示
        View view = View.inflate(container.getContext(), R.layout.item, null);
        ImageView imageView = view.findViewById(R.id.img);
        Glide.with(mContext)
                .load(mData.get(position))
                .into(imageView);

        //添加到父控件
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;// 过滤和缓存的作用
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);//从viewpager中移除掉
    }
}

