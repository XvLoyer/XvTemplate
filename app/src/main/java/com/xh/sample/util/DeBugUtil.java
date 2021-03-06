package com.xh.sample.util;


import android.content.Context;

import android.util.Log;

import android.widget.Toast;


public class DeBugUtil {
    public static final boolean OPEN_STRICT_MODE = true;

    public static final String TAG = "XhDebugUtil";

    public static final String HUM = "HUM";

    public static final boolean DEBUG = true;

    public static void toast(Context context, String content) {

        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();

    }
    public static void debug(String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.d(tag, msg, tr);
        }
    }



    public static void debug(String tag, String msg) {

        if (DEBUG) {
            Log.d(tag, msg);
        }

    }
    public static void debug(String msg) {

        if (DEBUG) {
            Log.d(TAG, msg);
        }

    }



    public static void error(String tag, String msg, Throwable tr) {
        if (DEBUG) {
            Log.e(tag, msg, tr);
        }
    }



    public static void error(String tag, String error) {
        Log.e(tag, error);

    }



    public static void error(String error) {
        Log.e(TAG, error);

    }
	public static void codeDeBug(eeorDebug eeor){
		eeor.start();
		long use=System.currentTimeMillis();
		try{
			eeor.onPause();
		}catch(Exception e){
			eeor.onEeor(e);
			debug(e.toString());
			return;
		}
		long end=System.currentTimeMillis();
		eeor.end(end-use);
	}
	public interface eeorDebug{
		public void start();
		public void onPause()throws Exception;
		public void end(long time);
		public void onEeor(Exception e);
	}
}

