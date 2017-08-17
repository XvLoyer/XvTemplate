package com.xh.sample.manager;
/*
 主题管理器
*/
import android.content.*;

import com.xh.sample.util.Theme;

public class ThemeManager
{
	//当前主题
	 int THEME_MODEL=0;
	//亮主题
	public static final int LIGHT=1;
	//暗主题
	public static final int DARK=2;
	//自定义主题
	public static final int CUSTOM=3;
	//是否由应用自动更换主题
	public static boolean isSetTheme=true;

    static ThemeManager manager;
	
	public void hook(){

	}
	public Theme getTheme(){
		Theme t=new Theme();
		switch(THEME_MODEL){
			case DARK:
				break;
			case LIGHT:
				break;
			case CUSTOM:
				break;
		}
		return t;
	}
	public void setCustomTheme(Context context,int color){
		SharedPreferences shared=context.getSharedPreferences("CustomColor",Context.MODE_PRIVATE);
		shared.edit().putInt("Color",color).commit();
	}
	public void setThemeModel(int model)
	{
		THEME_MODEL = model;
	}

	public int getThemeModel()
	{
		return THEME_MODEL;
	}
	
	public static ThemeManager newInstance(){
		if(manager==null){
			manager=new ThemeManager();
		}
		return manager;
	}
}
