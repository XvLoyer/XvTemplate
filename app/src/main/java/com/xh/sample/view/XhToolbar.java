package com.xh.sample.view;
import android.content.*;
import android.graphics.*;
import android.support.v7.widget.*;
import android.util.*;
import com.xh.sample.interfaces.*;
import com.xh.sample.manager.ThemeManager;
import com.xh.sample.ui.*;
import com.xh.sample.util.Theme;

public final class XhToolbar extends Toolbar
{
	BaseActivity base;
	public XhToolbar(Context con){
		super(con);
		init(con);
	}
	public XhToolbar(Context con,AttributeSet set){
		super(con,set);
		init(con);
	}
	public XhToolbar(Context con,AttributeSet set,int type){
		super(con,set,type);
		init(con);
	}
	private void init(Context c){
		if(!(c instanceof BaseActivity)){
			return;
		}
		base=(BaseActivity) c;
		base.setSupportActionBar(this);
		setPopupTheme(R.style.popup_theme_Light);
		intTheme();
	}
	public void intTheme(){
		//判断夜间模式
		if(ThemeManager.newInstance().getThemeModel()==ThemeManager.DARK){
			setTitleTextColor(Color.WHITE);
			setPopupTheme(R.style.popup_theme_Dark);
		}
		//日间模式
		else if(ThemeManager.newInstance().getThemeModel()==ThemeManager.LIGHT){
			setTitleTextColor(Color.BLACK);
			setPopupTheme(R.style.popup_theme_Light);
		}
		//自定义主题
		else{

		}
	}
}
