package com.xh.sample.ui;

import android.app.*;
import android.os.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xh.sample.interfaces.BaseActivity;
import com.xh.sample.manager.ThemeManager;

public class MainActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		addFragment(new XhFragment());
		initFragment(R.id.xh_fragment_content,0);
    }

    public static final class XhFragment extends Fragment implements View.OnClickListener
    {
        View v;
        private EditText edit;
        protected ThemeManager themeManager=ThemeManager.newInstance();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View v=inflater.from(getActivity()).inflate(R.layout.fragment_test,null);
            setView(v);
            Button btn1=(Button) findView(R.id.fragmenttestButton1);
            Button btn2=(Button) findView(R.id.fragmenttestButton2);
             edit=(EditText) findView(R.id.fragmenttestEditText1);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            return v;
        }
        public void setView(View v){
            this.v=v;
        }
        public final View findView(int id){
            return v.findViewById(id);
        }
        @Override
        public void onClick(View p1)
        {
            String str=edit.getText().toString();
            Toast.makeText(getActivity(),str,Toast.LENGTH_LONG).show();
        }


    }
}
