package com.example.ai.updateui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    /**
     * 更新UI的第一种方法
     */
    private void handler1() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("ok");
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    handler1();
                }catch(InterruptedException e){
                }
            }
        }.start();

    }
}
