package com.example.ai.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Handler handler=new Handler();
    private ImageView imageView;
    private Button button;


    /**
     * 用handler更新ImageView，方法是postDelayed（Runnable,long）
     */
    private int[] image=new int[]{
            R.drawable.sights1,
            R.drawable.sights2,
            R.drawable.sights3
    };
    private int index;
    private MyRunnable myRunnable=new MyRunnable();
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            index++;
            index=index%3;
            imageView.setImageResource(image[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.btn);
        //移除循环图片的handler
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(myRunnable);
            }
        });

        handler.postDelayed(myRunnable,1000);

        /**
         * 用handler更新textView的UI,方法是post(Runnable)方法
         */
        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("UpdateUI");
                        }
                    });
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
