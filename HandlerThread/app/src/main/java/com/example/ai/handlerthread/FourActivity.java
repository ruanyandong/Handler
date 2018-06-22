package com.example.ai.handlerthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by AI on 2017/12/9.
 */

/**
 * 实现主线程给子现场发送消息
 */

public class FourActivity extends AppCompatActivity {
    private Button sendMessage;
    private Button stopMessage;

    /**
     * 主线程的handler
     */
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Message message=new Message();
            Log.d("Main Handler========>", "handleMessage: ");
            /**
             * 向子线程发送消息
             */
            threadHandler.sendMessageDelayed(message,1000);
        }
    };

    /**
     * 子线程的handler
     */
    private Handler threadHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_activity);
        sendMessage=findViewById(R.id.button);
        stopMessage=findViewById(R.id.button2);

        HandlerThread handlerThread=new HandlerThread("handler");
        handlerThread.start();

        threadHandler=new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Message message=new Message();
                Log.d("Thread Handler========>", "handleMessage: ");
                /**
                 * 向主线程发送消息
                 */
                handler.sendMessageDelayed(message,1000);
            }
        };

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(1);
            }
        });

        stopMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeMessages(1);
            }
        });
    }
}
