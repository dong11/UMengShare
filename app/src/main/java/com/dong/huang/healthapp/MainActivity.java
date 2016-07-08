package com.dong.huang.healthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view){
        switch (view.getId()) {
            case R.id.btn_wechat:
                new ShareAction(this)
                        .setPlatform(SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener)
//                                .withText("hello umeng video")
                        .withText("猪吗")
                        .withMedia(new UMImage(this, "http://c.hiphotos.baidu.com/image/pic/item/0dd7912397dda1449fad6f63b6b7d0a20df486be.jpg"))
                        .withTargetUrl("http://www.baidu.com")
                        .share();
                break;
            case R.id.btn_weibo:
                new ShareAction(this)
                        .setPlatform(SHARE_MEDIA.SINA)
                        .setCallback(umShareListener)
                        .withText("测试")
                        .withMedia(new UMImage(this, "https://www.baidu.com/img/bd_logo1.png"))
                        .withTargetUrl("http://www.baidu.com")
                        .share();
                break;
        }
    }

    UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, platform + "分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {

            Toast.makeText(MainActivity.this, platform + "分享失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, platform + "分享取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(MainActivity.this).onActivityResult(requestCode, resultCode, data);
    }


}
