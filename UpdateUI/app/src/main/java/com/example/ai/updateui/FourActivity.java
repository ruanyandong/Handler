package com.example.ai.updateui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AI on 2017/12/9.
 */

public class FourActivity extends AppCompatActivity {
    private TextView textView;

    /**
     * 更新UI的第四种方法
     */
    private void viewUI(){
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("OK");
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_layout);
        textView=findViewById(R.id.textView4);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    viewUI();
                }catch(InterruptedException e){

                }
            }
        }.start();
    }
}
