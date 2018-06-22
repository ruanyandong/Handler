package com.example.ai.handler_sendmessage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AI on 2017/12/8.
 */

public class SecondActivity extends AppCompatActivity {

    private Handler handler=new Handler(){
        /**
         * handleMessage方法在UI线程里执行，不要执行耗时操作
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("UI==========>"+Thread.currentThread());
        }
    };

    class MyThread extends Thread{
        public Handler handler;
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    /**
                     * 打印出当前线程的Id
                     */
                    System.out.println("currentThread:"+Thread.currentThread());
                }
            };
            /**
             * 调用loop()方法，循环处理消息
             */
            Looper.loop();

        }
    }

    private MyThread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityThread main Looper MessageQueue
        TextView textView=new TextView(this);
        textView.setText("hello handler");
        setContentView(textView);
        thread=new MyThread();
        thread.start();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){

        }
        thread.handler.sendEmptyMessage(1);
        handler.sendEmptyMessage(1);
    }
}
