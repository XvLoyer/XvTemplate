package com.xh.sample.interfaces;
import android.app.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.xh.sample.ui.*;
import com.xh.sample.util.*;

import java.util.*;

import android.support.v7.app.ActionBar;
import com.xh.sample.manager.*;

public class BaseActivity extends AppCompatActivity
{
	List<Fragment> list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		list=new ArrayList<Fragment>();
		Theme t=ThemeManager.newInstance().getTheme();
		setXhTheme(t);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			//透明状态栏
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		}
	}


	public void initFragment(int content,int point){
		FragmentManager manager=getFragmentManager();
		FragmentTransaction fragment=manager.beginTransaction();
		fragment.replace(content,list.get(point));
		fragment.commit();
	}
	public void toast(String str){
		Toast.makeText(this,str,Toast.LENGTH_LONG).show();
	}
	public void snackbar(View v,String str,OnClickListener on,String Title){
		Snackbar snackbar=Snackbar.make(v,str,Snackbar.LENGTH_LONG);
		if(on!=null){
			snackbar.setAction(Title,on);
		}
		snackbar.show();
	}
	public void eeor(Exception e){
		DeBugUtil.error(e.toString());
	}
	
	public ActionBar getToolbar()
	{
		return getSupportActionBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.toolbar_item,menu);
		return true;
	}
	public void addFragment(MainActivity.XhFragment fragment){
		list.add(fragment);
	}
	
	public void setList(List<Fragment> list)
	{
		this.list = list;
	}

	public List<Fragment> getList()
	{
		return list;
	}
	public void setXhTheme(Theme resid)
	{
		setTheme(resid.id);
	}
	
	
}
