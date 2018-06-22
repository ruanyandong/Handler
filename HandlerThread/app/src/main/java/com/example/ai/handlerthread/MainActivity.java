package com.example.ai.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * HandlerThread是什么
 */

public class MainActivity extends AppCompatActivity {
    private HandlerThread handlerThread;
    private Handler handler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 解决多线程问题，避免在getLooper()的时候抛出空指针
         */
        handlerThread=new HandlerThread("HandlerThread");
        handlerThread.start();

        handler=new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println("current thread"+Thread.currentThread());
            }
        };
        handler.sendEmptyMessage(1);
    }
}
