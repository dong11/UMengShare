# UMengShare
友盟分享集成

#### 使用Module形式关联
```java
dependencies {
    compile project(':lib_umeng')
}
```

#### 使用gradle形式导入
```java
dependencies {
    compile 'com.hwong:lib_umeng:1.0.1'
}
```

#### 配置
##### AndroidManifest.xml
-- 权限：
```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.READ_LOGS" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.GET_TASKS" />
    <uses-permission android:name="android.permission.SET_DEBUG_APP" />
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.USE_CREDENTIALS" />
    <uses-permission android:name="android.permission.MANAGE_ACCOUNTS" />
```

-- Activity:注 需要替换meta-data中的 UMENG_APPKEY
```xml
<activity
            android:name="com.umeng.socialize.editorpage.ShareActivity"
            android:theme="@style/Theme.UMDefault"
            android:excludeFromRecents="true"/>
        
        <meta-data
            android:name="UMENG_APPKEY"
            android:value="XXXXXXXXXXXXXXXXXXXXXX" >
        </meta-data>

        <activity
            android:name=".wxapi.WXEntryActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:exported="true"
            android:screenOrientation="portrait"
            android:theme="@android:style/Theme.Translucent.NoTitleBar" />


        <activity
            android:name=".WBShareActivity"
            android:configChanges="keyboardHidden|orientation"
            android:screenOrientation="portrait" >
            <intent-filter>
                <action android:name="com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.sina.weibo.sdk.component.WeiboSdkBrowser"
            android:configChanges="keyboardHidden|orientation"
            android:windowSoftInputMode="adjustResize"
            android:exported="false" >
        </activity>
        <service
            android:name="com.sina.weibo.sdk.net.DownloadService"
            android:exported="false">
        </service>



        <activity
            android:name="com.tencent.tauth.AuthActivity"
            android:launchMode="singleTask"
            android:noHistory="true" >
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <data android:scheme="tencent100424468" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.tencent.connect.common.AssistActivity"
            android:screenOrientation="portrait"
            android:theme="@android:style/Theme.Translucent.NoTitleBar" />
```

-- MyApplication 需替换对应的appid和key 并且在AndroidManifest.xml中的application标签中声明
```java
        PlatformConfig.setWeixin("wxaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("aaaaaaaa","aaaaaaaaaaaaaaaaaaaaaa");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa");
        // QQ和Qzone appid appkey
```
