package com.xh.sample;
import android.app.Application;
import com.xh.sample.manager.ThemeManager;
import android.text.format.Time;
import com.xh.sample.util.DeBugUtil;
import android.widget.*;

public class XhApplication extends Application
{
	
	@Override
	public void onCreate()
	{
		if(ThemeManager.isSetTheme){
			ThemeManager manager=ThemeManager.newInstance();

			if(getSharedPreferences("CustomColor",MODE_PRIVATE).getInt("Color",0)==0){
				int hour=new Time().hour;
				if(hour<21){
					manager.setThemeModel(ThemeManager.LIGHT);
					DeBugUtil.debug("Light");
				}
				else{
					manager.setThemeModel(ThemeManager.DARK);
					DeBugUtil.debug("Dark");
				}
			}
			else{
				manager.setThemeModel(ThemeManager.CUSTOM);
				DeBugUtil.debug("Custom");
			}
			manager.setThemeModel(ThemeManager.DARK);
		}

		super.onCreate();
	}

}
