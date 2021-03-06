package com.wicare.wistorm.toolkit;

import com.wicare.wistorm.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Wu
 * 关于页面
 */
public abstract class WAboutApp extends Activity {
	
	private ImageView ivBack;
	private RelativeLayout rl_updata;
	
	protected abstract void onClickUpdata();//检查版本更新 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.ws_about_app);
		ivBack = (ImageView)findViewById(R.id.iv_back);
		ivBack.setOnClickListener(onClickListener);
		rl_updata = (RelativeLayout)findViewById(R.id.rl_updata);
		rl_updata.setOnClickListener(onClickListener);
//		tvUpdataCheck.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
//		tvUpdataCheck.getPaint().setAntiAlias(true);//抗锯齿
	}
	
	/**
	 * 点击监听事件
	 */
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.iv_back){
				WAboutApp.this.finish();
			}
			if(v.getId() == R.id.rl_updata){
				onClickUpdata();
			}
		}
	};
	
	
	
	/**
	 * @param resId 应用的logo
	 */
	public void setAppLogo(int resId){
		ImageView ivLogo = (ImageView)findViewById(R.id.iv_app_logo);
		ivLogo.setImageResource(resId);
	}
	
	
	/**
	 * @param resId 资源文件id（设置app的名字）
	 */
	public void setAppOrg(int resId){
		TextView tv_app_org = (TextView) findViewById(R.id.tv_app_org);
		tv_app_org.setText(resId);
	}
	
	/**
	 * @param appOrg app的名字
	 */
	public void setAppName(String appOrg){
		TextView tv_app_org = (TextView) findViewById(R.id.tv_app_org);
		tv_app_org.setText(appOrg);
	}

	
	
	/**
	 * @param resId 资源文件id（设置app的版本）
	 */
	public void setAppVersion(int resId){
		TextView tv_app_version = (TextView) findViewById(R.id.tv_app_version);
		tv_app_version.setText(resId);
	}
	
	/**
	 * @param appVersion app的版本
	 */
	public void setAppVersion(String appVersion){
		TextView tv_app_version = (TextView) findViewById(R.id.tv_app_version);
		tv_app_version.setText(appVersion);
	}
	
	
	/**
	 * @param resId 资源文件id（设置app的版权）
	 */
	public void setAppCopyright(int resId){
		TextView tv_app_copyright = (TextView) findViewById(R.id.tv_app_copyright);
		tv_app_copyright.setText(resId);
	}
	
	/**
	 * @param appCopyright app的版权
	 */
	public void setAppCopyright(String appCopyright){
		TextView tv_app_copyright = (TextView) findViewById(R.id.tv_app_copyright);
		tv_app_copyright.setText(appCopyright);
	}
}
