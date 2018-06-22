package com.example.ai.updateui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AI on 2017/12/9.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText("ok");
        }
    };

    /**
     * 更新UI的第二种方法
     */
    private void handler2(){
        handler.sendEmptyMessage(1);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        textView=findViewById(R.id.textView2);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    handler2();
                }catch(InterruptedException e){
                }
            }
        }.start();

    }
}
