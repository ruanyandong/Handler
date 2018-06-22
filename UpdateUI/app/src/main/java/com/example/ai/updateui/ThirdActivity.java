package com.example.ai.updateui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AI on 2017/12/9.
 */

public class ThirdActivity extends AppCompatActivity {
    private TextView textView;

    /**
     * 更新UI的第三种方法
     */
    private void UpdateUI(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("OK");
            }
        });
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        textView=findViewById(R.id.textView3);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    UpdateUI();
                }catch(InterruptedException e){

                }
            }
        }.start();

    }
}
