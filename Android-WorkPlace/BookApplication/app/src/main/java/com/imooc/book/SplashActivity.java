package com.imooc.book;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    public static final int CODE = 1001;
    public static final int TOTAL_TIME = 3000;
    public static final int INTERVAL_TIME = 1000;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        mTextView = (TextView) findViewById(R.id.time_text_view);


        final MyHandler handler = new MyHandler(this);

        Message message = Message.obtain();
        message.what = CODE;
        message.arg1 = TOTAL_TIME;
        handler.sendMessage(message);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookListActivity.start(SplashActivity.this);
                SplashActivity.this.finish();
                handler.removeMessages(CODE);
            }
        });

    }

    public static class MyHandler extends Handler {

        public final WeakReference<SplashActivity> mWeakReference;

        public MyHandler(SplashActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = mWeakReference.get();
            if (msg.what == CODE) {


                if (activity != null) {

                    // 设置textview,更新UI
                    int time = msg.arg1;
                    activity.mTextView.setText(time/ INTERVAL_TIME +"秒,点击跳过");

                    // 发送倒计时

                    Message message = Message.obtain();
                    message.what = CODE;
                    message.arg1 = time - INTERVAL_TIME;

                    if (time > 0) {
                        sendMessageDelayed(message, INTERVAL_TIME);
                    } else {
                        BookListActivity.start(activity);
                        activity.finish();
                    }

                }
            }
        }
    }

}
