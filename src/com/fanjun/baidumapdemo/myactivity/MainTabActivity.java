package com.fanjun.baidumapdemo.myactivity;

import com.example.baidumapdemo.R;
import com.fanjun.baidumapdemo.myfragment.FragmentPage1;
import com.fanjun.baidumapdemo.myfragment.FragmentPage2;
import com.fanjun.baidumapdemo.myfragment.FragmentPage3;
import com.fanjun.baidumapdemo.myfragment.FragmentPage4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

/**
 * 
 * @author fanjun
 *	功能描述：自定义TabHost
 */
public class MainTabActivity extends FragmentActivity{
	//定义FragmentTabHost对象
	private FragmentTabHost mTabHost;
	
	//定义一个布局
	private LayoutInflater layoutInflater;
	
	//定义数组来存放Fragment界面
	private Class fragmentArray[]={FragmentPage1.class,
									FragmentPage2.class,
									FragmentPage3.class,
									FragmentPage4.class};
	
	//定义数组来存放按钮图片
	private int mImageViewArray[]={R.drawable.tab_home_btn,
									R.drawable.tab_message_btn,
									R.drawable.tab_address_btn,
									R.drawable.tab_circle_btn};
	
	//定义数组来存放选项卡文字
	private String mTextViewArray[]={"首页","消息","通讯录","发现"};
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_tab_layout);
		initView();
	}
	
	/**
	 * 初始化组件
	 */
	private void initView(){
		//实例化布局对象
		layoutInflater=LayoutInflater.from(this);
		//实例化TabHost对象，得到TabHost
		mTabHost=(FragmentTabHost)findViewById(R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		//去除Tab分割线
		mTabHost.getTabWidget().setDividerDrawable(null);
		
		//得到Fragment的个数
		int count=fragmentArray.length;
		
		for(int i=0;i<count;i++){
			//为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec=mTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
			//将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			//设置Tab按钮的背景
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(android.R.color.white);
		}
	}
	
	//给Tab按钮设置图标和文字
	private View getTabItemView(int index){
		View view=layoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView imageView=(ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		
		TextView textView=(TextView) view.findViewById(R.id.textview);
		textView.setText(mTextViewArray[index]);
		
		return view;
	}
}
