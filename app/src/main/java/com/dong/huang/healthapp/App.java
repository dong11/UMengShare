package com.dong.huang.healthapp;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/7/7
 * @time 下午10:38
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setWeixin("wxcb98a56f7265f375", "444e6ff310d0a28a0af3c277dc5e03f1");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("990358814","3b764734e2882790a468d30c62e16038");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // QQ和Qzone appid appkey
    }
}
